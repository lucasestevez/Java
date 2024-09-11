package Date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class DateAndTimeFormatter {
    public static void main(String[] args) {

        Locale usLocale = new Locale("en", "US");
        Locale lkLocale = new Locale("si", "LK");
        Locale jpLocale = new Locale("ja");
        Locale deLocale = new Locale("de", "CH");

        LocalDate today = LocalDate.now();

        DateTimeFormatter usDateTimeFormatter = DateTimeFormatter.ofPattern("EEEE MMM dd yyyy", usLocale);

        DateTimeFormatter myDateTimeFormatter = DateTimeFormatter
                .ofLocalizedDate(FormatStyle.LONG)
                .localizedBy(lkLocale);

        DateTimeFormatter jpDateTimeFormatter = DateTimeFormatter
                .ofPattern("EEEE yyyy dd MMM", jpLocale);

        DateTimeFormatter deDateTimeFormatter = DateTimeFormatter
                .ofLocalizedDate(FormatStyle.MEDIUM)
                .localizedBy(deLocale);

        String localizedDateForUS = today.format(usDateTimeFormatter);
        String localizedDateForLK = today.format(myDateTimeFormatter);
        String localizedDateForJP = today.format(jpDateTimeFormatter);
        String localizedDateForDe = today.format(deDateTimeFormatter);

        System.out.println(localizedDateForUS);
        System.out.println(localizedDateForLK);
        System.out.println(localizedDateForJP);
        System.out.println(localizedDateForDe);

    }
}
