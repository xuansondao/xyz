package common.util;

import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class LocalDatetimeUtil {
    private static String DATE_PATTERN_DF = "dd/MM/uuuu";

    public static Date toUTCDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().toInstant(ZoneOffset.UTC));
    }

    public static Date toDateLocal(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date toDateLocal(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDate toLocalDateFromDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static LocalDateTime toLocalDateTimeFromDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public static String localDateToString(LocalDate localDate, String pattern) {
        pattern = StringUtils.isEmpty(pattern) ? DATE_PATTERN_DF : pattern;
        return localDate.format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String localDateToString(LocalDate localDate) {
        return localDate.format(DateTimeFormatter.ofPattern(DATE_PATTERN_DF));
    }

    public static String dateToString(Date date) {
        return localDateToString(toLocalDateFromDate(date));
    }

    public static String localDateTimeToString(LocalDateTime dateTime, String pattern) {
        if (StringUtils.isEmpty(pattern)) return dateTime.format(DateTimeFormatter.ISO_DATE_TIME);
        return dateTime.format(DateTimeFormatter.ofPattern(pattern));
    }

    public static Date stringToDate(String dateStr, String pattern) {
        if (pattern == null) pattern = DATE_PATTERN_DF;
        return toDateLocal(LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(pattern)));
    }

    public static LocalDate stringToLocalDate(String dateStr, String pattern) {
        if (pattern == null) pattern = DATE_PATTERN_DF;
        return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(pattern));
    }

    public static LocalDate isoStringToLocalDate(String isoDateStr) {
        return LocalDate.parse(isoDateStr, DateTimeFormatter.ISO_DATE);
    }
}
