package models;

import api.LoginApi;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@JsonInclude(NON_NULL)
public class User {
    @JsonProperty("name")
    private String firstName;
    @JsonProperty("secondName")
    private String lastName;
    private String chatName;
    @JsonProperty("organization")
    private String company;
    private String position;
    private String about;
    private String companySize;
    private String email;
    private String password;
    private String phone;
    private String webinarFrequency;
    private String participantsRegistration;
    private String sessionId;
    private String locale;
    private String project;
    private boolean confirmEmail;
    private String emailName;
    private Integer Id;

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return user.getFirstName().equals(firstName) && user.getLastName().equals(lastName)
                && user.getChatName().equals(chatName) && user.getCompany().equals(company)
                && user.getPosition().equals(position) && user.getPhone().equals(phone)
                && user.getAbout().equals(about);
    }

    @JsonIgnore
    public String getSessionId() {
        if (sessionId == null) {
            sessionId = LoginApi.getSessionId(this);
        }
        return sessionId;
    }

    @JsonIgnore
    public String getFullName() {
        return this.getFirstName() + " " + this.getLastName();
    }
}
