package com.raychynets.vasyl.web.models.elements;

import com.github.javafaker.Faker;
import com.raychynets.vasyl.web.services.Factory;

import java.util.Random;

public class WebTablesUserFactory implements Factory<WebTablesUser, WebTablesUserFactory> {
    private Faker faker;

    public WebTablesUserFactory() {
        this.faker = new Faker();
    }

    @Override
    public WebTablesUser create() {
        return WebTablesUser.builder()
                .withFirstName(faker.name().firstName())
                .withLastName(faker.name().lastName())
                .withEmail(faker.internet().safeEmailAddress())
                .withAge(new Random().ints(18, 70).findFirst().getAsInt())
                .withSalary(new Random().ints(5000, 30000).findFirst().getAsInt())
                .withDepartment(faker.job().position())
                .build();
    }
}
