package Date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class ExtractAndCombineDateTime {
    public static void main(String[] args) {

        LocalDate someDay = LocalDate.of(2020, 3, 19);
        System.out.println("Someday : " + someDay);

        LocalTime someTime = LocalTime.of(23, 53);
        System.out.println("Sometime : " + someTime);

        //Combine Time into the Date
        LocalDateTime someDateTime = someDay.atTime(someTime);
        System.out.println(someDateTime);

        //Combine Date into the Time
        LocalDateTime someTimeDate = someTime.atDate(someDay);
        System.out.println(someTimeDate);

        //Extracting only the date from DateTime
        LocalDate whatWasTheDate = someDateTime.toLocalDate();
        System.out.println(whatWasTheDate);

        //Extracting only the Time from DateTime
        LocalTime whatWasTheTime = someDateTime.toLocalTime();
        System.out.println(whatWasTheTime);

        //Extract only selected portion from date and time
        int year = someDateTime.getYear();
        Month month = someDateTime.getMonth();
        int hour = someDateTime.getHour();

        System.out.println("Year : " + year);
        System.out.println("Month : " + month);
        System.out.println("Hour : " + hour);
    }
}
