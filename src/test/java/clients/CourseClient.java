package clients;

import api.CourseApi;
import models.User;
import models.courseSettings.CourseData;
import models.lessons.LessonInPart;
import models.lessons.Part;

public class CourseClient {

    public static LessonInPart getLesson(User user, CourseData courseData, String lessonName) {
        return CourseApi.getParts(user, courseData).stream()
                .flatMap(part -> part.getLessonList().stream())
                .filter(lesson -> lesson.getName().equals(lessonName))
                .findFirst()
                .orElse(LessonInPart.defaultData());
    }

    public static Part getPart(User user, CourseData courseData, String partName) {
        return CourseApi.getParts(user, courseData).stream()
                .filter(part -> part.getName().equals(partName))
                .findFirst()
                .orElse(Part.defaultData());
    }
}
