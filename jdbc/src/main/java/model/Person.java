package model;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Value
@Builder
public class Person {
    long id;
    String fullName;
    LocalDate dateOfBirth;
    Gender gender;
}
