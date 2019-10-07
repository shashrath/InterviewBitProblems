package shasha.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

public class Solution {
    public static void main(String[] args) {
        System.out.println(validTimestamp("1970-01-01T01:02:00Z"));
    }

    public static String validTimestamp(String timestamp) {
        String timeFormat = null;

        final List<String> dateFormats = Arrays.asList("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", "yyyy-MM-dd'T'HH:mm:ss'Z'",
                "yyyy-MM-dd'T'HH:mm:ss.SSSXXX", "yyyy-MM-dd'T'HH:mm:ssXXX", "yyyyMMdd'T'HHmmssZ",
                "yyyyMMdd'T'HHmmssSSSZ");

        for (String format : dateFormats) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
                sdf.parse(timestamp);
                timeFormat = format;
                break;
            } catch (ParseException e) {
                // intentionally empty
            }

        }
        return timeFormat;
    }
}
