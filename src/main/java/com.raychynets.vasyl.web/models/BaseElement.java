package com.raychynets.vasyl.web.models;

import org.openqa.selenium.By;

public interface BaseElement {
    String getName();

    By getLocator();

    boolean hasScroll();
}
