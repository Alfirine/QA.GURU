package testdata.course;

import api.CourseApi;
import api.CourseInstanceApi;
import helpers.CourseHelper;
import models.User;
import models.courseResponse.CourseResponseData;
import models.courseSettings.CourseData;
import models.createCourse.CreateCourseData;

import java.util.List;
import java.util.Objects;

import static enums.Periodicity.END;

public final class NewCourse {
    private final User user;

    NewCourse(User user) {
        this.user = user;
    }

    public User user() {
        return user;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (NewCourse) obj;
        return Objects.equals(this.user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user);
    }

    @Override
    public String toString() {
        return "NewCourse[" +
                "user=" + user + ']';
    }

    public CourseData getDefaultUnpublishedCourse() {
        CreateCourseData defaultCreateCourseData = new CreateCourseData();
        CourseResponseData courseResponseData = CourseInstanceApi.createCourse(user, defaultCreateCourseData);
        int courseId = courseResponseData.getCourseInstance().getCourse().getId();
        return new CourseData(user, courseId);
    }

    public CourseData getDefaultCourse() {
        CourseData courseData = getDefaultUnpublishedCourse();
        CourseApi.publishCourse(user, courseData);
        return courseData;
    }

    public CourseData getCourseWithTags(List<String> tags) {
        CourseData courseData = getDefaultCourse();
        courseData.setAutoAssignmentSettingTags(tags);
        courseData = CourseApi.courseSettings(user, courseData);
        return courseData;
    }

    public CourseData getCourseWithTwoGroups() {
        CourseData courseData = getDefaultCourse();
        courseData.setCourseInstances(CourseHelper.getCourseInstancesWithGroups(2));
        courseData.getCourse().setPeriodicity(END.getApiValue());
        courseData = CourseApi.courseSettings(user, courseData);
        return courseData;
    }
}
