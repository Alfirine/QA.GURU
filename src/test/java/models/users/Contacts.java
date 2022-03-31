package models.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Contacts {
    private List<String> additionalFieldsValues;
    private String company;
    private String createAt;
    private String updateAt;
    private String email;
    private Integer id;
    private String updateUserId;
    private boolean isDeleted;
    private String name;
    private String position;
    private String secondName;
    private List<Tag> tags;
    private String phoneMain;
}
