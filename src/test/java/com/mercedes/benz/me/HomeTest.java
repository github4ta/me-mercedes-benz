package com.mercedes.benz.me;

import com.mercedes.benz.me.driver.SeleniumWebDriver;
import com.mercedes.benz.me.pages.BasePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HomeTest {

    @Test
    @DisplayName("get text privacy notice")
    public void test2() {
        String actual = new BasePage()
                .openHomePage()
                .scrollSite()
                .getTextPrivacyNotice();

        Assertions.assertEquals("Privacy Notice", actual);
    }

    @Test
    public void ternDawn() {
        SeleniumWebDriver.quitDriver();
    }
}
