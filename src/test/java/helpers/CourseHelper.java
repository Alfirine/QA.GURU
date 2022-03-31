package helpers;

import api.CourseApi;
import config.Project;
import models.User;
import models.courseResponse.CourseInstance;
import models.courseSettings.CourseData;
import models.lessons.LessonInPart;
import models.lessons.Part;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import static java.time.LocalDateTime.now;

public class CourseHelper {

    /**
     * Получить ссылку на курс по id
     */
    public static String getCourseUrl(CourseData courseData) {
        return String.format("%s/course-info/%s", Project.config.baseUrl(), courseData.getCourse().getId());
    }

    public static String getJournalUrl(CourseData courseData) {
        return String.format("%s/course-info/%s/journal", Project.config.baseUrl(), courseData.getCourse().getId());
    }

    public static String getEditLessonPath(CourseData courseData, Integer lessonId) {
        return String.format("/course/%s/lesson/%s", courseData.getCourse().getId(), lessonId);
    }

    public static String getPartUrl(CourseData courseData, Integer partId) {
        return String.format("/course/%s/part/%s", courseData.getCourse().getId(), partId);
    }

    public static LessonInPart getLesson(User user, CourseData courseData, String lessonName) {
        return CourseApi.getParts(user, courseData).stream()
                .flatMap(part -> part.getLessonList().stream())
                .filter(lesson -> lesson.getName().equals(lessonName))
                .findFirst()
                .orElse(null);
    }

    public static Part getPart(User user, CourseData courseData, String partName) {
        return CourseApi.getParts(user, courseData).stream()
                .filter(part -> part.getName().equals(partName))
                .findFirst()
                .orElse(null);
    }

    public static List<CourseInstance> getCourseInstancesWithGroups(int numberOfGroups) {
        LocalDateTime currentDateTime = now().truncatedTo(ChronoUnit.SECONDS);
        List<CourseInstance> courseInstances = new ArrayList<>();
        for (int i = 0; i < numberOfGroups * 2; i += 2) {
            courseInstances.add(new CourseInstance(currentDateTime.plusDays(i).toString(), currentDateTime.plusDays(i + 1).toString()));
        }
        return courseInstances;
    }
}
