package models.login;

import lombok.Data;

import java.util.List;

@Data
public class Login {
    private Integer id;
    private Boolean isDeleted;
    private String createAt;
    private Integer updateUserId;
    private String updateAt;
    private String nickname;
    private String type;
    private String sessionId;
    private String regDate;
    private String email;
    private String status;
    private Boolean isSubmitted;
    private Boolean isAutoRecord;
    private Boolean isSubscriber;
    private Boolean isEnterprise;
    private Boolean isNpsEnabled;
    private Object data;
    private Boolean hadCoursesEver;
    private Boolean hadWebinarTrialEver;
    private Boolean hadPaidTariffEver;
    private Boolean hasRecentEvents;
    private Boolean hasRecentRecords;
    private Boolean hasRealMeetings;
    private Object properties;
    private List<Memberships> memberships;
    private Object activeProlongation;
    private String lastVisitedDate;
    private String lastVisitedDateMobile;
    private String name;
    private String secondName;
    private String phone;
    private String organization;
    private String locale;
    private String defaultEventType;
    private FeatureFlags featureFlags;
    private String firstEventDate;
}
