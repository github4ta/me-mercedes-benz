package com.mercedes.benz.me.pages;

import com.mercedes.benz.me.driver.SeleniumWebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private final String BASE_URL = "https://www.me.mercedes-benz.com/";
    private final By HEADER_PRIVACY_POLICY_ICON = By.cssSelector("a[data-test-id='header-privacy-policy']");
    private final By PRIVATE_CUSTOMER = By.cssSelector("div.hp-header-ssr-user-menu__sublabel");
    private final By PARENT_SELECTOR = By.cssSelector("owc-footer");
    private final By PRIVACY_NOTICE = By.cssSelector("li.owc-lower-footer-legal__item");

    private final WebDriver driver;

    public HomePage() {
        driver = SeleniumWebDriver.getDriver();
    }

    public HomePage open() {
        driver.get(BASE_URL);
        return this;
    }


    public HomePage clickPrivacyPolicy() {
        SeleniumWebDriver.clickElement(HEADER_PRIVACY_POLICY_ICON);
        return this;
    }

    public HomePage clickPrivateCustomer(){
        SeleniumWebDriver.clickElement(PRIVATE_CUSTOMER);
        return this;
    }
    public HomePage clickPrivacyNotice(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement shadowHost = wait.until(ExpectedConditions.presenceOfElementLocated(PARENT_SELECTOR));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        SearchContext shadowRoot = (SearchContext) js.executeScript("return arguments[0].shadowRoot", shadowHost);
        assert shadowRoot != null;
        WebElement link = shadowRoot.findElement(PRIVACY_NOTICE);
        wait.until(ExpectedConditions.elementToBeClickable(link));
        link.click();
        return this;
    }
    public HomePage getPrivacyNoticeText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement shadowHost = wait.until(ExpectedConditions.presenceOfElementLocated(PARENT_SELECTOR));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        SearchContext shadowRoot = (SearchContext) js.executeScript("return arguments[0].shadowRoot", shadowHost);
        assert shadowRoot != null;
        WebElement link = shadowRoot.findElement(PRIVACY_NOTICE);
        wait.until(ExpectedConditions.visibilityOf(link));
        link.getText();
        return this;
    }
}
