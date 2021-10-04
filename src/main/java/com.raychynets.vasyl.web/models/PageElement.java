package com.raychynets.vasyl.web.models;

import lombok.Setter;
import lombok.experimental.Accessors;
import org.openqa.selenium.By;

import java.util.function.Consumer;

import static java.util.Objects.requireNonNull;

@Setter
@Accessors(chain = true)
public class PageElement implements BaseElement {

    private String name;
    private By locator;
    private boolean hasScroll;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public By getLocator() {
        return locator;
    }

    @Override
    public boolean hasScroll() {
        return hasScroll;
    }

    public PageElement(final Consumer<PageElement> builder) {
        requireNonNull(builder).accept(this);
    }
}

