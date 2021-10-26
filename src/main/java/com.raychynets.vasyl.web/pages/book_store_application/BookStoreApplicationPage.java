package com.raychynets.vasyl.web.pages.book_store_application;

import com.raychynets.vasyl.web.pages.BaseModulePage;
import org.openqa.selenium.WebDriver;

public class BookStoreApplicationPage extends BaseModulePage {

    public BookStoreApplicationPage(WebDriver driver) {
        super(driver);
        expectedTitle = "Book Store";
    }

}
