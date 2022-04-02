package models;

import lombok.Data;

import static enums.localization.CourseBlock.LESSON_NAME;

@Data
public class Lesson {
    private Integer lessonId;
    private String lessonType = "lesson";
    private String name = LESSON_NAME.getValue();
    private String text;
    private String accessType;
    private String accessAt;
    private String accessTimeZone;

    public Lesson() {
    }
}
