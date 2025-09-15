package com.mercedes.benz.me.pages;

import com.mercedes.benz.me.driver.SeleniumWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SearchPage {

    private WebDriver driver;
    private final By PARENT_SELECTOR = By.cssSelector("owc-footer");
    private final By COPYRIGHT_TEXT_MERCEDES_BENZ_USA = By.cssSelector("a.owc-lower-footer-legal__link");

    public SearchPage() {
        driver = SeleniumWebDriver.getDriver();
    }

    public String getTextCopyrightMercedesBenzUsa() {
        return SeleniumWebDriver.actionWithShadowElement(PARENT_SELECTOR, COPYRIGHT_TEXT_MERCEDES_BENZ_USA).getText();
    }

    public SearchPage clickTextCopyrightMercedesBenzUsa() {
        WebElement parentElement = driver.findElement(PARENT_SELECTOR);
        SearchContext context = parentElement.getShadowRoot();
        WebElement element = context.findElement(COPYRIGHT_TEXT_MERCEDES_BENZ_USA);
        element.click();
        return this;
    }
    public SearchPage switchToLastWindow() {
        SeleniumWebDriver.switchToLastWindow();
        return this;
    }
    public String gettingTabAddress() {
        return SeleniumWebDriver.getTabUrl();
    }
}
