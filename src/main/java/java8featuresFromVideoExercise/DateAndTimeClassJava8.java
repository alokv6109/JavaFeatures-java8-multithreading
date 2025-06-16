package java8featuresFromVideoExercise;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Set;

public class DateAndTimeClassJava8 {
    public static void main(String[] args) throws InterruptedException {
        LocalDate nowed = LocalDate.now();
        System.out.println(nowed);
        System.out.println(nowed.minusDays(21));


        LocalDate localDate = LocalDate.of(1997, 6, 10);
        System.out.println(localDate);
        int dayOfMonth = localDate.getDayOfMonth();
        int year = localDate.getYear();
        Month month = localDate.getMonth();
        String date1 = "2025-04-05";
        LocalDate localDate1 = LocalDate.parse(date1);
        System.out.println(localDate1);
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        System.out.println(dayOfWeek);
        System.out.println(month);

        System.out.println("--------------------------------------------------");

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        LocalTime localTime1 = LocalTime.of(12, 34, 43);
        System.out.println(localTime1);
        LocalTime localTime2 = localTime.minusHours(1);
        if(localTime.isAfter(localTime2)){
            System.out.println("han bhai ");
        }

        System.out.println("---------------------------------------------------");

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        LocalDateTime parse = LocalDateTime.parse(
                "2025-03-21T13:48");
        System.out.println(parse.getDayOfMonth());
        System.out.println(parse.getHour());

        System.out.println("-------------------------------------------------------");

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
//        availableZoneIds.stream().forEach(e -> System.out.println(e));
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println(now);

        System.out.println("------------------------------------------------------------");

        Instant now1 = Instant.now();
        System.out.println(now1);
        System.out.println(now1.atZone(ZoneId.of("Asia/Calcutta")));

        System.out.println(now1.getEpochSecond());
        System.out.println(now1.getNano());
        System.out.println("----------------------------------------------------------");

        Instant instant = Instant.now();
        for(long i =0; i<1000000000; i++){
            i = i+1;
        }
        Instant instant1 = Instant.now();

        Instant minus = instant1.minus(7, ChronoUnit.DAYS);
        System.out.println(minus);

        Duration between = Duration.between(instant, instant1);
        Duration duration = Duration.of(1, ChronoUnit.HOURS);

        System.out.println(between);
        System.out.println(duration);
        Thread.sleep(2000);
        Instant now2 = Instant.now();
        Duration between1 = Duration.between(instant1, now2);
        System.out.println(between1);
        System.out.println("--------------------------------------------");
        LocalDate nowed1 = LocalDate.now();
        LocalDate localDate2 = LocalDate.of(1997, 6, 10);
        Period between2 = Period.between(nowed1, localDate2);
        System.out.println(between2);
        Period period = Period.ofDays(30);
//        LocalDate.

        System.out.println("-----------------------------------------------");
//        LocalDate localDate3 = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate parse1 = LocalDate.parse(
                "12/06/1997", dateTimeFormatter);
        System.out.println(parse1);
        String string  = "2023-04-24 10:30+05:30";
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mmXXX");
        ZonedDateTime dateTime = ZonedDateTime.parse(string, dateTimeFormatter1);
        System.out.println(dateTime);


    }
}
