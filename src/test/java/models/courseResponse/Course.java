package models.courseResponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import static enums.CourseTrajectory.CLOSE;
import static enums.Periodicity.ENDLESS;
import static enums.localization.CourseBlock.COURSE_NAME;
import static helpers.TimeGenerateHelper.getCurrentTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Course {
    private String visibilityStatus = "all";
    private String description;
    private String trajectory = CLOSE.toApi();
    private String passingScore = "0.00";
    private String certSetting;
    private String urlAlias;
    private String periodicity = ENDLESS.toApi();
    private Integer access;
    private String background;
    private User user;
    private Organization organization;
    private String locale;
    private Integer id;
    private String status;
    private String name = COURSE_NAME.getValue();
    private Boolean autoCert = false;
    private Boolean isAdaptation;
    private Boolean isNeedSsoAuth;
    private String startAt = getCurrentTime();
    private String ssoUrl;

    public Course(String name, String startAt, String periodicity, String trajectory, String passingScore, String visibilityStatus, Boolean autoCert) {
        this.name = name;
        this.startAt = startAt;
        this.periodicity = periodicity;
        this.trajectory = trajectory;
        this.passingScore = passingScore;
        this.visibilityStatus = visibilityStatus;
        this.autoCert = autoCert;
    }

    public Course() {
    }
}
