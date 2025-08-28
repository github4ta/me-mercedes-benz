package com.mercedes.benz.me.pages;

import com.mercedes.benz.me.driver.SeleniumWebDriver;
import org.openqa.selenium.*;

public class HomePage {

    private final By HEADER_PRIVACY_POLICY_ICON = By.cssSelector("a[data-test-id='header-privacy-policy']");
    private final By PRIVATE_CUSTOMER = By.cssSelector("div.hp-header-ssr-user-menu__sublabel");
    private final By PARENT_SELECTOR = By.cssSelector("owc-footer");
    private final By PRIVACY_NOTICE = By.cssSelector("li.owc-lower-footer-legal__item");

    private final WebDriver driver;

    public HomePage() {
        driver = SeleniumWebDriver.getDriver();
    }


    public HomePage clickPrivacyPolicy() {
        SeleniumWebDriver.clickElement(HEADER_PRIVACY_POLICY_ICON);
        return this;
    }

    public HomePage clickPrivateCustomer() {
        SeleniumWebDriver.clickElement(PRIVATE_CUSTOMER);
        return this;
    }

    public HomePage clickPrivacyNotice() {
        SeleniumWebDriver.actionWithShadowElement(PARENT_SELECTOR,PRIVACY_NOTICE).click();
        return this;
    }

    public HomePage getPrivacyNoticeText() {
        SeleniumWebDriver.actionWithShadowElement(PARENT_SELECTOR,PRIVACY_NOTICE).getText();
        return this;
    }
}
