package models.createCourse;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import models.Lesson;
import models.courseResponse.Course;
import models.courseResponse.CoursePart;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateCourseData {
    private Course course;
    private CoursePart coursePart;
    private Lesson lesson;
    private List<Reminder> reminders;

    public CreateCourseData(Course course, CoursePart coursePart, Lesson lesson, List<Reminder> reminders) {
        this.course = course;
        this.coursePart = coursePart;
        this.lesson = lesson;
        this.reminders = reminders;
    }

}
