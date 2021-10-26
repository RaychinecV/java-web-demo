package com.raychynets.vasyl.web.models.elements;

import com.github.javafaker.Faker;
import com.raychynets.vasyl.web.services.Factory;

public class TextBoxUserFactory implements Factory<TextBoxUser, TextBoxUserFactory> {
    private Faker faker;
    private TextBoxUser user;

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

    public TextBoxUserFactory builder() {
        user = new TextBoxUser();
        return this;
    }

    public TextBoxUserFactory withFullName() {
        user.setFullName(faker.name().fullName());
        return this;
    }

    public TextBoxUserFactory withEmail() {
        user.setEmail(faker.internet().safeEmailAddress());
        return this;
    }

    public TextBoxUserFactory withCurrentAddress() {
        user.setEmail(faker.address().fullAddress());
        return this;
    }

    public TextBoxUserFactory withPermanentAddress() {
        user.setPermanentAddress(faker.address().secondaryAddress());
        return this;
    }

    public TextBoxUser build() {
        return user;
    }
}
