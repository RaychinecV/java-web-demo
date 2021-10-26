package com.raychynets.vasyl.web.models.elements;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TextBoxUser {
    private String fullName;
    private String email;
    private String currentAddress;
    private String permanentAddress;
}
