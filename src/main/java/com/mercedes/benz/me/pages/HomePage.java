package com.mercedes.benz.me.pages;

import com.mercedes.benz.me.driver.SeleniumWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class HomePage {

    private final By HEADER_INTEGRATION_ITEM_FSS_SEARCH_INPUT = By.xpath("//a[@data-test-id='header-integration-item-fss-search-input']");
    private final By PARENT_SELECTOR = By.cssSelector("owc-footer");
    private final By COPYRIGHT_TEXT_MERCEDES_BENZ_USA = By.cssSelector("a.owc-lower-footer-legal__link");
    private final By TERMS_OF_USE = By.cssSelector("li.owc-lower-footer-legal__item");
    private final By HEADER_PRIVACY_POLICY_ICON = By.cssSelector("a[data-test-id='header-privacy-policy']");
    private final By PRIVATE_CUSTOMER = By.cssSelector("div.hp-header-ssr-user-menu__sublabel");
    private final By PRIVACY_NOTICE = By.cssSelector("li.owc-lower-footer-legal__item");
    private final By SEARCH_WINDOW = By.id("fss-search-input");
    private final WebDriver driver;

    public HomePage() {
        driver = SeleniumWebDriver.getDriver();
    }

    public HomePage clickInputSearch() {
        driver.findElement(HEADER_INTEGRATION_ITEM_FSS_SEARCH_INPUT).click();
        return this;
    }

    public HomePage clickCopyright() {
        WebElement parentElement = driver.findElement(PARENT_SELECTOR);
        SearchContext context = parentElement.getShadowRoot();
        WebElement element = context.findElement(COPYRIGHT_TEXT_MERCEDES_BENZ_USA);
        element.click();
        return (HomePage) element;
    }

    public HomePage clickTermsOfUse() {
        WebElement parentElement = driver.findElement(PARENT_SELECTOR);
        SearchContext context = parentElement.getShadowRoot();
        WebElement element = context.findElement(TERMS_OF_USE);
        element.click();
        return (HomePage) element;
    }

    public String getTextCopyrightMercedesBenzUsa(){
        return SeleniumWebDriver.actionWithShadowElement(PARENT_SELECTOR,COPYRIGHT_TEXT_MERCEDES_BENZ_USA).getText();
    }

    public String getTextTermsOfUse() {
        WebElement parentElement = driver.findElement(PARENT_SELECTOR);
        SearchContext context = parentElement.getShadowRoot();
        return context.findElement(TERMS_OF_USE).getText();
    }


    public HomePage clickHeaderPrivacyPolicyIcon() {
        SeleniumWebDriver.clickElement(HEADER_PRIVACY_POLICY_ICON);
        return this;
    }

    public HomePage clickPrivateCustomer() {
        SeleniumWebDriver.clickElement(PRIVATE_CUSTOMER);
        return this;
    }

    public HomePage clickPrivacyNotice() {
        SeleniumWebDriver.actionWithShadowElement(PARENT_SELECTOR, PRIVACY_NOTICE).click();
        return this;
    }

    public HomePage getPrivacyNoticeText() {
        SeleniumWebDriver.actionWithShadowElement(PARENT_SELECTOR, PRIVACY_NOTICE).getText();
        return this;
    }

    public boolean isPresenceWindowSearch() {
        return !driver.findElements(SEARCH_WINDOW).isEmpty();
    }
    public HomePage scrollSite(){
        Actions action = new Actions(driver);
        action.scrollByAmount(0, 1000).perform();
        return this;
    }
}
