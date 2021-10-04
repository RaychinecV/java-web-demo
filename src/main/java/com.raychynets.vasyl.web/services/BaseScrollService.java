package com.raychynets.vasyl.web.services;

import com.raychynets.vasyl.web.models.BaseElement;
import org.openqa.selenium.By;

public interface BaseScrollService {

    void scrollToElement(BaseElement element, boolean isIntoView);

    void scrollToElement(By by, boolean isIntoView);
}
