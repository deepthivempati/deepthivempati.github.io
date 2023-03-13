---
title:  "Crud Operation Examples"
date:   2022-10-14 17:22:00
categories: ['Spring Boot']
tags: ['Spring Boot']
---

{% include toc title="Index" %}
**CRUD (CREATE,READ,UPDATE,DELETE)operation spring program to find student by id with get and post request**

## Example-1:
### Here's an example Spring program that demonstrates how to perform CRUD operations and implement GET and POST requests to find a student by their ID.

* First, let's define the Student class that represents a student and their details.
* First, let's define the Student class that represents a student and their details.
``` java
public class Student {
    private int id;
    private String name;
    private String email;
    // getters and setters
}
```
* Next, let's create a StudentController class that handles the requests.
``` java
@RestController
@RequestMapping("/students")
public class StudentController {

    private Map<Integer, Student> students = new HashMap<>(); // a collection to store students

    // POST request to add a new student
    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        students.put(student.getId(), student);
        return ResponseEntity.ok(student);
    }

    // GET request to find a student by ID
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        if (students.containsKey(id)) {
            return ResponseEntity.ok(students.get(id));
        }
        return ResponseEntity.notFound().build();
    }
}
```
* In this class, we have defined two methods - addStudent and getStudentById.
* The addStudent method handles a POST request to add a new student to the collection. It takes in a Student object in the request body, adds it to the students collection, and returns the same student object with an HTTP status code of 200 (OK).
* The getStudentById method handles a GET request to find a student by their ID. It takes in the id of the student in the path variable, checks if the students collection contains a student with that ID, and returns the student object with an HTTP status code of 200 (OK) if found, or a 404 (Not Found) status code if not found.

* Finally, let's define the main class that runs the Spring application.
``` java
@SpringBootApplication
public class StudentApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentApplication.class, args);
    }
}
```
* That's it! You can now run the application and test it out using a REST client or a web browser. Here are a few sample requests:

* To add a new student:
``` java
POST http://localhost:8080/students/add
Content-Type: application/json

{
    "id": 1,
    "name": "John Doe",
    "email": "johndoe@example.com"
}
```

* To find a student by ID:
``` java
GET http://localhost:8080/students/1
```

* This should return the following response:
``` java
{
    "id": 1,
    "name": "John Doe",
    "email": "johndoe@example.com"
}
```