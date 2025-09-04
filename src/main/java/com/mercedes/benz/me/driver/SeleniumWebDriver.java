package com.mercedes.benz.me.driver;

import com.mercedes.benz.me.pages.HomePage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SeleniumWebDriver {

    private static WebDriver driver;

    private SeleniumWebDriver() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36");
            options.addArguments("--disable-notifications");
            options.addArguments("--incognito");
            options.addArguments("--disable-infobars");
            options.addArguments("profile.default_content_setting_values.password_manager_enabled=0");
            options.addArguments("profile.default_content_setting_values.autofill_enabled=0");
            options.addArguments("--disable-popup-blocking");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }

        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static void clickElement(By element) {
        driver.findElement(element).click();
    }

    public static WebElement actionWithShadowElement(By parentSelector, By shadowElementSelector) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement shadowHost = wait.until(ExpectedConditions.presenceOfElementLocated(parentSelector));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        SearchContext shadowRoot = (SearchContext) js.executeScript("return arguments[0].shadowRoot", shadowHost);
        assert shadowRoot != null;
        return shadowRoot.findElement(shadowElementSelector);
    }

    public void scrollSite() {
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0, 900).perform();
    }

    public void switchToLastWindow() {
        List<String> windowHandlesList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandlesList.getLast());
    }

    public String getTabUrl() {
        return driver.getCurrentUrl();
    }
}
