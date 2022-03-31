package testdata.course;

import lombok.Getter;
import models.User;
import models.courseSettings.CourseData;

@Getter
public class CourseProvider {

    public static NewCourse createCourse(User user) {
        return new NewCourse(user);
    }

    public static EditCourse editCourse(User user, CourseData courseData) {
        return new EditCourse(user, courseData);
    }
}
