package models.users;

import lombok.Data;

@Data
public class Tag {
    private String createAt;
    private String id;
    private String isDeleted;
    private String isPublic;
    private String name;
}
