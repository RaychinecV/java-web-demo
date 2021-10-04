package com.raychynets.vasyl.web.models.elements;

import com.github.javafaker.Faker;
import com.raychynets.vasyl.web.services.Factory;

public class TextBoxUserFactory implements Factory<TextBoxUser, TextBoxUserFactory> {
    private Faker faker;

    public TextBoxUserFactory() {
        this.faker = new Faker();
    }

    @Override
    public TextBoxUser create() {
        return TextBoxUser.builder()
                .withFullName(faker.name().fullName())
                .withEmail(faker.internet().safeEmailAddress())
                .withCurrentAddress(faker.address().fullAddress())
                .withPermanentAddress(faker.address().secondaryAddress())
                .build();
    }
}
