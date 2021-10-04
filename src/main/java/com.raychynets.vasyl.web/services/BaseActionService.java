package com.raychynets.vasyl.web.services;

import com.raychynets.vasyl.web.models.BaseElement;

public interface BaseActionService {

    String getText(BaseElement baseElement);

    String getInputValue(BaseElement baseElement);

    void click(BaseElement baseElement);

    void moveOnAndClick(BaseElement baseElement);

    void enterText(BaseElement baseElement, String text);

    void enterText(BaseElement baseElement, String text, boolean clear);

    void selectDropDownOptionByValue(BaseElement baseElement, String value);

    void selectDropDownOptionByText(BaseElement baseElement, String value);

    void checkCheckbox(BaseElement baseElement);

    void uncheckCheckbox(BaseElement baseElement);

    void dragAndDrop(BaseElement from, BaseElement to);

    void doubleClick(BaseElement baseElement);

    void pressEnter();

    void pressTab();
}
