package models.createCourse;

import lombok.Data;

@Data
public class Reminder {
    private Integer id;
    private String title;
    private String template;
    private String timeIntervalType;
    private String type;
    private Integer offset;
    private Boolean isActive;
    private String sentDate;

    public Reminder(String title, String template, String timeIntervalType, String type, Integer offset, Boolean isActive, String sentDate) {
        this.title = title;
        this.template = template;
        this.timeIntervalType = timeIntervalType;
        this.type = type;
        this.offset = offset;
        this.isActive = isActive;
        this.sentDate = sentDate;
    }

    public Reminder() {
    }
}