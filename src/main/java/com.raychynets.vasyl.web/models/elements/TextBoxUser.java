package com.raychynets.vasyl.web.models.elements;

import lombok.Builder;
import lombok.Data;

@Builder(setterPrefix = "with")
@Data
public class TextBoxUser {
    private String fullName;
    private String email;
    private String currentAddress;
    private String permanentAddress;
}
