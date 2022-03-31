package models.courseResponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseInstance {
    private Integer id;
    private Integer cost = 0;
    private String status;
    private String createAt;
    private String startAt;
    private String endAt;
    private Course course;
    private Integer countStudents;
    private Integer countPaidStudents;
    private Boolean isStarted;

    public CourseInstance(Integer cost, String startAt, String endAt) {
        this.cost = cost;
        this.startAt = startAt;
        this.endAt = endAt;
    }

    public CourseInstance(String startAt, String endAt) {
        this.startAt = startAt;
        this.endAt = endAt;
    }

    public CourseInstance(String startAt) {
        this.startAt = startAt;
    }

    public CourseInstance() {
    }
}
