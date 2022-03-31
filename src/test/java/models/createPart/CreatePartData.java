package models.createPart;

import lombok.Data;

@Data
public class CreatePartData {
    private String name;

    public CreatePartData(String name) {
        this.name = name;
    }
}
