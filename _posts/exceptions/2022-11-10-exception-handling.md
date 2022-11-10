---
title:  "Exception Handling"
date:   2022-11-09 19:48:00
categories: Java
tags: ['Java']
---

{% include toc title="Index" %}

## Exception Handling Overview
* Unwanted or unexpected event that disturbs normal flow of programs is exception.
* If a program needs graceful termination we use exceptional handling not to loose any data or resources.
* ex: open db connection, read data, close db connection.
* In the above ex we may get sql exception if the file is not found. Since we did not handle the unexpected event program gets terminated abnormally without closing db. It might result in application crashing when many db connections are opened and not closed.
* Defining backup facility(alternative way) to continue the rest of the program normally is known as exception handling.

``` java
try{
read the data
load file
}
catch(FileNotFoundException ex){
use local file and continue
}
```
* we use try catch and finally blocks for exception handling. Only Risky code should be in try block. Handling code should be in catch block. cleanup code is writtern in finally block. Ex: file.close().
``` java
try{  // Risky code
open db connection
read data
}
catch(Exception e){  // Handling code
sout("file not found");
}
finally{  // Cleanup code
close db connection
}
```
* finally block will compulsarily execute even without catch or no catch block getting executed.
* finally will be executed in the abnormal execution. After finally block stack trace will be printed if any exception arised.
* when the JVM crashes or exits explicitly, the finally block does not gets executed.
* ex: System.exit(0) --> Terminating JVM explicitly. 0 is status code which states normal termination. non-zero states abnormal termination. just this status codes are used to know why jvm is termination .
* Exceptions can be arised in try, catch and finally blocks.
* There can be nested try catch blocks in try, catch, finally blocks.
* No lines of code should be between try, catch, finally blocks.
* try without catch or finally gives compile time error.
* catch without try gives compile time error.
* only finally without try gives compile error.
* For every method call JVM makes an entry in the stacktrace
* An exception object is created by method where Exception is raised and JVM gives the object to and turns **Default Exception Handler** which prints exception stacktrace as **Exception in main Thread: {type of exception and details}**.
* **Throwable** is a class and its a parent class for all the Exceptions and Errors. It is not an interface.

## Checked and Unchecked Exceptions
* **Checked and Unchecked Exceptions** occurs at runtime only. Compile time exceptions are just syntactical errors.
* Exceptions which are checked or handled by compiler for smooth running of program at Runtime are called Checked Exceptions
* Ex: HallTicketNotFound Exception
* **Unreported Exceptions** are compile time Exceptions.

``` java
Class Test{
psvm(String[] args){
PrintWriter pw = new PrintWriter("abc.txt");
pw.print("Hello")
}
}
```
* Gives compile time Exception because abc.txt file might not be existing to print Hello and this is not handled by exception.
* CE in console: UnsupportedException java.io.FileNotFound must be caught or declared to be thrown.
* Every java program will atleast contain one thread(main)
* Example for RE in console: Exception in main thread --> starts with this in console.

## Fully and Partially Checked Exceptions
* If both Parent and Child Exceptions are checked then they are **fully checked** exceptions.
* Ex: IOException is fully checked because EOFException and FileNotFoundException which are child class of IOException are also fully checked.
* only is the parent is checked and child is unchecked then they are **partially checked** exceptions.
* Exception class is partially checked because some of its child classes like RuntimeException child of Exception is unchekced.
* Throwable is partially checked Exception.

* **IOException** --> Checked(Fully Checked)
* **RuntimeException** --> Unchecked
* **InterruptedException** --> Checked(Fully Checked)
* **Error** --> Unchecked
* **Throwable** --> Checked(Partially Checked)
* **ArithmeticException** --> Checked(Partially Checked)
* **Exception** --> Checked(Partially Checked)
* **FileNotFoundException** --> Checked(Fully Checked)

## Methods to print Exception
* 1) `e.printStackTrace()` -> o/p: starts with name of Exception: Description & stackTrace.
* 2) `e.toString()
      sout(e);
      sout(e.toString)` -> o/p: starts with name of Exception: only Description no stackTrace 
* When we are trying to call any object reference we call toString().
* 3) `e.getMessage()` -> o/p: only description no stackTrace. No name of exception and stackTrace.

## Exceptional Handling pre-defined java classes

* Class Error Extends Throwable{}
* Class Exception Extends Throwable{}
* Class InteruptedException Extends Exception{}
* Class RuntimeException Extends Exception{}
* Class NullPointerException Extends RuntimeException{}

## Exceptional handling best practices
* Never hide exceptions
* Do not use it for control flow
* Think about your user
* Think about your support team
* Think about the calling methods
* Have global exceptional handling

## Special feature
* we can use multiple exceptions in catch block using pipe

``` java
try{
//code}
catch(IOException|SQLException ex){
ex.printStackTrace();
}
```
## Ways of using try catch and finally blocks
* There are many forms to use try catch finally blocks for exceptional handling
[Link]: (https://www.youtube.com/watch?v=w1lBFIXx12s&list=PLd3UqWTnYXOnT6p6dll1oiKsDu96QGANk&index=18)

## Top 10 Exceptions
* ArrayIndexOutOfBoundsException
* NullPointerExceptions
* StackOverFlowException
* ClassCastException
* NoClassDefFoundException
* ExceptionInInitializerError
* IllegalArgumentException
* NumberFormatException
* IllegalStateException
* AssertionException

## Try with Resources
* Try block contains arguments in this case.
* 1.6 version --> complexity increases and length of code readability decreases.
``` java
BufferReader br = null;
try{
br = new BR((new FR("input.txt"));
// based on our requirement use 'br' to read data
}
catch(IOException e)
{
// Handling code
}
fianlly{
if(br != null)
{
br.close();
}
}
```
* 1.7 version --> complexity decreases and length of code readability increases.
``` java
try(BR br = new BR(new FR("input.txt")))
{
use br based on our requirement. once control reaches end of try block automatically br will be closed. we are not requires to close explicitly.
}
catch(IOException e)
{
// handling code
}
```

## throws keyword
* To handle CustomException to JVM manually we throw an Exception using throws keyword.
* Checked Exception can be thrown by throws keyword or using try catch block.
``` java 
class Eat{  
 void method()throws IOException{  
  throw new IOException("device error");  
 }  
}  
class Testthrows{  
   public static void main(String args[])throws IOException{ //declare exception  
     Eat eat=new Eat();  
     eat.method();  
    System.out.println("normal flow...");  
  }  
}  
```
``` java 
class Testthrows{  
  void eat()throws IOException{  
    throw new IOException("device error"); //checked exception  
  }  
  void food()throws IOException{  
    eat();  
  }  
  void goodFood(){  
   try{  
    food();  
   }catch(Exception e){System.out.println("exception handled");}  
  }  
  public static void main(String args[]){  
   Testthrows obj=new Testthrows();  
   obj.goodFood();  
   System.out.println("normal flow...");  
  }  
}
```


