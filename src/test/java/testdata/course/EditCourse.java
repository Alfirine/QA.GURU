package testdata.course;

import models.User;
import models.courseSettings.CourseData;

public class EditCourse {

    private final User user;
    private CourseData courseData;

    public EditCourse(User user, CourseData courseData) {
        this.user = user;
        this.courseData = courseData;
    }
}
