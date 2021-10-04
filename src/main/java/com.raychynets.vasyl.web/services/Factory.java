package com.raychynets.vasyl.web.services;

public interface Factory<T, R extends Factory<T, R>> {
    T create();
}
