package helpers;

import models.Lesson;
import models.courseResponse.Course;
import models.courseResponse.CoursePart;
import models.createCourse.CreateCourseData;
import models.createCourse.Reminder;

import java.util.ArrayList;
import java.util.List;

import static enums.localization.CourseBlock.REMINDERS_LETTER_TEXT;
import static enums.localization.CourseBlock.REMINDERS_LETTER_TITLE;

public class CourseDataBuilder {
    private Course course;
    private CoursePart coursePart;
    private Lesson lesson;
    private List<Reminder> reminders;

    public static CourseDataBuilder builder() {
        return new CourseDataBuilder();
    }

    public CourseDataBuilder addCourse(Course course) {
        this.course = course;
        return this;
    }

    public CourseDataBuilder addCoursePart(CoursePart coursePart) {
        this.coursePart = coursePart;
        return this;
    }

    public CourseDataBuilder addLesson(Lesson lesson) {
        this.lesson = lesson;
        return this;
    }

    public CourseDataBuilder addReminders(List<Reminder> reminders) {
        this.reminders = reminders;
        return this;
    }

    public CreateCourseData build() {
        return new CreateCourseData(course, coursePart, lesson, reminders);
    }

    public CreateCourseData buildDefault() {
        List<Reminder> reminders = new ArrayList<>() {{
            add(new Reminder(REMINDERS_LETTER_TITLE.getValue(), REMINDERS_LETTER_TEXT.getValue(), "week", "BEFORE", 1, true, null));
            add(new Reminder(REMINDERS_LETTER_TITLE.getValue(), REMINDERS_LETTER_TEXT.getValue(), "day", "BEFORE", 1, true, null));
            add(new Reminder(REMINDERS_LETTER_TITLE.getValue(), REMINDERS_LETTER_TEXT.getValue(), "day", "BEFORE", 0, false, null));
        }};

        return builder()
                .addCourse(new Course())
                .addCoursePart(new CoursePart())
                .addLesson(new Lesson())
                .addReminders(reminders).build();
    }
}
