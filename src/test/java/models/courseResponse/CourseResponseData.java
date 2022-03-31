package models.courseResponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import models.Lesson;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseResponseData {
    private CourseInstance courseInstance;
    private CoursePart coursePart;
    private Lesson lesson;
}
