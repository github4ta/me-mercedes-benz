package com.mercedes.benz.me.pages;

import com.mercedes.benz.me.driver.SeleniumWebDriver;
import org.openqa.selenium.WebDriver;

public class BasePage {

    private final String BASE_URL = "https://www.me.mercedes-benz.com/";

    private WebDriver driver;

    public BasePage() {
        driver = SeleniumWebDriver.getDriver();
    }

    public void openHomePage() {
        driver.get(BASE_URL);
    }
}
