package models.lessons;

import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
public class Part {
    private Integer id;
    private String name;
    private List<LessonInPart> lessonList;

    public static Part defaultData() {
        Part part = new Part();
        part.setId(0);
        part.setName("0");
        part.setLessonList(Collections.emptyList());
        return part;
    }
}
