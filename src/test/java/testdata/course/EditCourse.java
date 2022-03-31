package testdata.course;

import api.CourseApi;
import helpers.CourseHelper;
import models.User;
import models.courseSettings.CourseData;

import java.util.List;

import static enums.Periodicity.END;

public class EditCourse {

    private final User user;
    private CourseData courseData;

    public EditCourse(User user, CourseData courseData) {
        this.user = user;
        this.courseData = courseData;
    }

    public CourseData changeToCourseWithOneGroupWithTags(List<String> tags) {
        courseData.setCourseInstances(CourseHelper.getCourseInstancesWithGroups(1));
        courseData.getCourse().setPeriodicity(END.getApiValue());
        courseData.setAutoAssignmentSettingTags(tags);
        courseData = CourseApi.courseSettings(user, courseData);
        return courseData;
    }
}
