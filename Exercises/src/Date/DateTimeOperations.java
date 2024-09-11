package Date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DateTimeOperations {
    public static void main(String[] args) {

        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();

        LocalDateTime futureDateTime = currentDateTime
                .plusYears(1) // Add one year to "current date and time
                .plusDays(2) // Add two days
                .plusHours(3); //Add three more hours

        boolean isBefore = futureDateTime.isBefore(currentDateTime); //false
        boolean isAfter = futureDateTime.isAfter(currentDateTime); //true

        System.out.println(today);
        System.out.println(now);
        System.out.println(currentDateTime);
        System.out.println(futureDateTime);
        System.out.println(isBefore);
        System.out.println(isAfter);

    }
}
