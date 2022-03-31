package models.lessons;

import lombok.Data;

@Data
public class LessonInPart {
    private Integer id;
    private CoursePart coursePart;
    private String lessonType;
    private String name;
}
