package models.courseSettings;

import api.CourseApi;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import models.User;
import models.courseResponse.Course;
import models.courseResponse.CourseInstance;
import models.createCourse.Reminder;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseData {
    private List<String> autoAssignmentSettingTags;
    private Course course;
    private List<CourseInstance> courseInstances;
    private List<Reminder> reminders;

    public CourseData(Course course, List<CourseInstance> courseInstances, List<Reminder> reminders) {
        this.course = course;
        this.courseInstances = courseInstances;
        this.reminders = reminders;
    }

    public CourseData(Course course, List<CourseInstance> courseInstances, List<Reminder> reminders, List<String> autoAssignmentSettingTags) {
        this.course = course;
        this.courseInstances = courseInstances;
        this.reminders = reminders;
        this.autoAssignmentSettingTags = autoAssignmentSettingTags;
    }

    public CourseData(User user, int courseId) {
        this.course = CourseApi.getCourse(user, courseId);
        this.courseInstances = CourseApi.getCourseInstances(user, courseId);
        this.reminders = CourseApi.getReminders(user, courseId);
    }

    public CourseData() {
    }
}
