package models.lessons;

import lombok.Data;

@Data
public class LessonInPart {
    private Integer id;
    private CoursePart coursePart;
    private String lessonType;
    private String name;

    public static LessonInPart defaultData() {
        LessonInPart lessonInPart = new LessonInPart();
        lessonInPart.setId(0);
        CoursePart coursePart = new CoursePart();
        coursePart.setId(0);
        lessonInPart.setCoursePart(coursePart);
        lessonInPart.setLessonType("0");
        lessonInPart.setName("0");
        return lessonInPart;
    }
}
