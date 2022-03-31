package enums.localization;

public enum Course {
    REMINDERS_LETTER_TITLE("Напоминание о курсе"),
    REMINDERS_LETTER_TEXT("{first_name} {second_name}, напоминаем, что Вы приглашены на курс"),
    PART_NAME("Новая часть"),
    LESSON_NAME("Новый урок"),
    COURSE_NAME("Новый курс"),
    COURSE_STARTED_TEXT("Курс начался"),
    COURSE_WILL_START_TEXT("Курс начнется"),
    SUCCESSFUL_REGISTRATION_FOR_COURSE_TEXT("Вы записаны на курс"),
    SIGN_UP_TEXT("Записаться");

    private final String value;

    Course(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;

    }
}
