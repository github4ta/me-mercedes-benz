package com.mercedes.benz.me.pages;

import com.mercedes.benz.me.driver.SeleniumWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LegalNoticesPage {


    private final By LEGAL_NOTICES_TEXT = By.xpath("//h1[@class='title-hero__title'] ");

    private final WebDriver driver;

    public LegalNoticesPage() {
        driver = SeleniumWebDriver.getDriver();
    }

    public String getTextLegalNotices() {
        return driver.findElement(LEGAL_NOTICES_TEXT).getText();
    }
}
