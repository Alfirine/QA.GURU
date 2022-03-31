package helpers;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

import static java.time.format.DateTimeFormatter.ISO_OFFSET_DATE_TIME;
import static java.time.temporal.ChronoUnit.SECONDS;

public class TimeGenerateHelper {

    /**
     * Получаем текущее время в Московском часовом поясе
     */
    public static String getMoscowTime() {
        return LocalTime.now(ZoneId.of("Europe/Moscow")).truncatedTo(ChronoUnit.SECONDS).toString();
    }

    public static String getCurrentTime() {
        return ZonedDateTime.now().truncatedTo(SECONDS).format(ISO_OFFSET_DATE_TIME);
    }
}

