package testdata.course;

import api.CourseApi;
import api.CourseInstanceApi;
import helpers.CourseDataBuilder;
import helpers.CourseHelper;
import models.User;
import models.courseResponse.CourseResponseData;
import models.courseSettings.CourseData;
import models.createCourse.CreateCourseData;

import java.util.List;

import static enums.Periodicity.END;

public class CourseDataProvider {

    public static CourseData getDefaultUnpublishedCourse(User user) {
        CreateCourseData defaultCreateCourseData = CourseDataBuilder.builder().buildDefault();
        CourseResponseData courseResponseData = CourseInstanceApi.createCourse(user, defaultCreateCourseData);
        int courseId = courseResponseData.getCourseInstance().getCourse().getId();
        return new CourseData(user, courseId);
    }

    public static CourseData getDefaultCourse(User user) {
        CourseData courseData = getDefaultUnpublishedCourse(user);
        CourseApi.publishCourse(user, courseData);
        return courseData;
    }

    public static CourseData getCourseWithTags(User user, List<String> tags) {
        CourseData courseData = getDefaultCourse(user);
        courseData.setAutoAssignmentSettingTags(tags);
        courseData = CourseApi.courseSettings(user, courseData);
        return courseData;
    }

    public static CourseData getCourseWithTwoGroups(User user) {
        CourseData courseData = getDefaultCourse(user);
        courseData.setCourseInstances(CourseHelper.getCourseInstancesWithGroups(2));
        courseData.getCourse().setPeriodicity(END.toApi());
        courseData = CourseApi.courseSettings(user, courseData);
        return courseData;
    }

    public static CourseData changeToCourseWithOneGroupWithTags(User user, CourseData courseData, List<String> tags) {
        courseData.setCourseInstances(CourseHelper.getCourseInstancesWithGroups(1));
        courseData.getCourse().setPeriodicity(END.toApi());
        courseData.setAutoAssignmentSettingTags(tags);
        courseData = CourseApi.courseSettings(user, courseData);
        return courseData;
    }
}
