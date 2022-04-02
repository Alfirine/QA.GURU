package models.courseResponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import static enums.localization.CourseBlock.PART_NAME;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CoursePart {
    private Integer id;
    private String name = PART_NAME.getValue();

    public CoursePart() {
    }
}
