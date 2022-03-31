package models.createCourse;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import models.Lesson;
import models.courseResponse.Course;
import models.courseResponse.CoursePart;

import java.util.ArrayList;
import java.util.List;

import static enums.localization.Course.REMINDERS_LETTER_TEXT;
import static enums.localization.Course.REMINDERS_LETTER_TITLE;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateCourseData {
    private Course course = new Course();
    private CoursePart coursePart = new CoursePart();
    private Lesson lesson = new Lesson();
    private List<Reminder> reminders = getDefaultReminders();

    public CreateCourseData(Course course, CoursePart coursePart, Lesson lesson) {
        this.course = course;
        this.coursePart = coursePart;
        this.lesson = lesson;
    }

    public CreateCourseData() {
    }

    private static List<Reminder> getDefaultReminders() {
        return new ArrayList<>() {{
            add(new Reminder(REMINDERS_LETTER_TITLE.getValue(), REMINDERS_LETTER_TEXT.getValue(), "week", "BEFORE", 1, true, null));
            add(new Reminder(REMINDERS_LETTER_TITLE.getValue(), REMINDERS_LETTER_TEXT.getValue(), "day", "BEFORE", 1, true, null));
            add(new Reminder(REMINDERS_LETTER_TITLE.getValue(), REMINDERS_LETTER_TEXT.getValue(), "day", "BEFORE", 0, false, null));
        }};
    }
}
