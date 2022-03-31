package models.createLesson;

import lombok.Data;

import static enums.localization.Course.LESSON_NAME;

@Data
public class CreateLesson {
    private Integer coursePartId;
    private String lessonType = "lesson";
    private String name = LESSON_NAME.getValue();

    public CreateLesson(Integer coursePartId, String lessonType, String name) {
        this.coursePartId = coursePartId;
        this.lessonType = lessonType;
        this.name = name;
    }

    public CreateLesson(Integer coursePartId) {
        this.coursePartId = coursePartId;
    }
}
