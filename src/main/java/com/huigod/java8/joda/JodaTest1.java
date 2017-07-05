package com.huigod.java8.joda;


import org.joda.time.*;

public class JodaTest1 {
    public static void main(String[] args) {
        DateTime today = new DateTime();
        DateTime tomorrow = today.plusDays(1);

        System.out.println(today.toString("yyyy-MM-dd"));
        System.out.println(tomorrow.toString("yyyy-MM-dd"));

        System.out.println("--------");

        DateTime d1 = today.withDayOfMonth(1);

        System.out.println(d1.toString("yyyy-MM-dd"));

        System.out.println("--------");

        LocalDate localDate = new LocalDate();
        System.out.println(localDate);

        System.out.println("--------");

        localDate = localDate.plusMonths(3).dayOfMonth().withMinimumValue();
        System.out.println(localDate);

        System.out.println("--------");

        DateTime dateTime = new DateTime();
        DateTime endTime = new DateTime(2017, 1, 1, 0, 0);

        DateTime dateTime2 = dateTime.minusYears(2).monthOfYear().
                setCopy(3).dayOfMonth().withMinimumValue();

        System.out.println(dateTime2.toString("yyyy-MM-dd"));
        System.out.println(Seconds.secondsBetween(dateTime,endTime).getSeconds());
        System.out.println(Days.daysBetween(dateTime,endTime).getDays());
        System.out.println(dateTime.isBefore(endTime));
        System.out.println(dateTime.monthOfYear().get() + "," + dateTime.weekOfWeekyear().get() + "," + dateTime.dayOfWeek().get());

//        Arrays.stream(TimeZone.getAvailableIDs()).forEach(System.out::println);
        DateTime dateTimeZone = new DateTime().withZone(DateTimeZone.forID("Africa/Accra"));
        DateTime dateTimeZone2 = new DateTime().withZone(DateTimeZone.forOffsetHours(3));
        System.out.println(dateTimeZone);
        System.out.println(dateTimeZone2);
    }













}
