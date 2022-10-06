import java.time.*;
import java.util.*;

public class AgeCalculation {
    public static void main(String[] args) {
        ageCalculator();
    }
    private static void ageCalculator() {
        int year = 1998;
        int month = 11;
        int day = 11;
        LocalDate dob = LocalDate.of(year, month, day);
        LocalDate todaysDate = LocalDate.now();
        Period period = Period.between(dob, todaysDate);
        int years = period.getYears();
        int months = period.getMonths();
        int days = period.getDays();
        System.out.printf("Your age is %d Years %d Months and %d Days", years, months, days);
    }
}
