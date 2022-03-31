package models.lessons;

import lombok.Data;

import java.util.List;

@Data
public class Part {
    private Integer id;
    private String name;
    private List<LessonInPart> lessonList;
}
