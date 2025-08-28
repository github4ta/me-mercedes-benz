package com.mercedes.benz.me.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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
            driver = new ChromeDriver();
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
}
