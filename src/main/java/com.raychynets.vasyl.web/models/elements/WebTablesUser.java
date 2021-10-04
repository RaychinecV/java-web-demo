package com.raychynets.vasyl.web.models.elements;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Builder(setterPrefix = "with")
@Accessors(chain = true)
public class WebTablesUser {
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private int salary;
    private String department;
}
