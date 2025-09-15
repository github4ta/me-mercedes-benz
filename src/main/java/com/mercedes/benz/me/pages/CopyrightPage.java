package com.mercedes.benz.me.pages;

import com.mercedes.benz.me.driver.SeleniumWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CopyrightPage {

    private final By PARENT_SELECTOR = By.cssSelector("owc-footer");
    private final By PRIVACY_NOTICE = By.cssSelector("li.owc-lower-footer-legal__item");
    private final By COPYRIGHT_TEXT_MERCEDES_BENZ_USA = By.cssSelector("a.owc-lower-footer-legal__link");

    private WebDriver driver;

    public CopyrightPage() {
        driver = SeleniumWebDriver.getDriver();
    }


    public String getTextPrivacyNotice() {
        WebElement parentElement = driver.findElement(PARENT_SELECTOR);
        SearchContext context = parentElement.getShadowRoot();
        return context.findElement(PRIVACY_NOTICE).getText();
    }
    public CopyrightPage scrool(){
        SeleniumWebDriver.scrollPageDown();
        return new SearchPage();
    }
}
