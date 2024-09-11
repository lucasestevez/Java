package Date;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class FindingPastDateTime {
    public static void main(String[] args) {
        //Setting a pastime and date
        LocalDateTime pastDateTime = LocalDateTime.of(2021, 2, 20, 18, 30);

        //Setting the Zone to Berlin, Germany
        ZoneId berlinZone = ZoneId.of("Europe/Berlin");

        //Setting the Zone to Denver, Colorado, USA
        ZoneId denverColZone = ZoneId.of("GMT-6");

        //Mapping the Date and Time with the Zone, (2021 Feb 20, 6.30PM in Berlin)
        ZonedDateTime pastDateTimeInBerlin = ZonedDateTime.of(pastDateTime, berlinZone);

        //What was the time in Denver when at 2021 Feb 20th 6.30PM in Berlin?
        ZonedDateTime pastTimeInDenver = pastDateTimeInBerlin.withZoneSameInstant(denverColZone);

        System.out.println(pastDateTimeInBerlin);
        System.out.println(pastTimeInDenver);
    }
}
