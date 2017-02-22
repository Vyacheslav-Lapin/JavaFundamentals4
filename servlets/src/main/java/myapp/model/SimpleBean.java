package myapp.model;

import lombok.Data;

import java.util.Date;

@Data
public class SimpleBean {
    private String name;
    private String surname;
    private Date date;
}
