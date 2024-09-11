package Date;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class CalculateTimePeriod {
    public static void main(String[] args) {
        //Get the current date
        LocalDate today = LocalDate.now();

        //Christmas Date of 2021
        LocalDate christmasDayOfThisYear = LocalDate.of(today.getYear(), Month.DECEMBER, 25);

        //Calculate period left from current date to Christmas
        Period howLongForChristmas = Period.between(today, christmasDayOfThisYear);

        //Extracting the elements years, months and Dates
        int years = howLongForChristmas.getYears();
        int months = howLongForChristmas.getMonths();
        int days = howLongForChristmas.getDays();

        System.out.println("Current Date: "+ today);
        System.out.println("Years  : " + years);
        System.out.println("Months : " + months);
        System.out.println("Days   : " + days);
    }
}
