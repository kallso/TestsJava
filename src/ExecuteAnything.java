import java.net.InetAddress;
import java.net.UnknownHostException;

import static java.lang.Math.sqrt;

public class ExecuteAnything {

    public static void main(String[] args) throws UnknownHostException {
        // Date date = new Date("2022-08-09 17:10:46.766 +0530");
        // Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS X").parse("2022-08-09 17:10:46.766 +0530");
        // Date date = new SimpleDateFormat().parse("2022-08-09 17:10:46.766 +05:30");

//        Timestamp ts = new Timestamp();
//        Date date = new Date(ts.getTime());
       //  System.out.println(date);

        //DateTimeFormatter origFormatter = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss.SSS XXXX");
        // DateTimeFormatter desiredFormatter = DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm:ss");
        // ZoneId desiredZone = ZoneId.of("America/Fort_Nelson");

        // String feUltMod = "2018-07-20 18:53:46.598000 +02:00:00";
//       String originalDateTime = "2022-08-09 17:10:46.766 +0530";
//       OffsetDateTime offsetDateTime = OffsetDateTime.parse(originalDateTime, origFormatter);
        // ZonedDateTime dateTimeWithTimeZoneApplied = dateTime.atZoneSameInstant(desiredZone);
        // feUltMod = dateTimeWithTimeZoneApplied.format(desiredFormatter);
//        System.out.println(offsetDateTime);
//        LocalDateTime localDateTime = offsetDateTime.toLocalDateTime();

//        Instant instant = offsetDateTime.toInstant();
      //  Date date = Date.from(instant);

//        System.out.println("OffsetDateTime: " + offsetDateTime);
//        System.out.println("LocalDateTime: " + localDateTime);
       // System.out.println("Date: " + date);

        System.out.println(sqrt(169));

        System.out.println("tel:+915755251036151".replaceAll("\\D+", ""));

        System.out.println("""
                        {
                            "terminalLocation": [],
                            "errorMessageList": [
                                "Not Found MSISDN 91575525103615"
                            ]
                        }
                        """);

        InetAddress inetAddress = InetAddress.getByName("lts.myvi.in");
        System.out.println(inetAddress);

        Object[] array;

        // array.
    }
}
