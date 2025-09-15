package com.mercedes.benz.me;

import com.mercedes.benz.me.driver.SeleniumWebDriver;
import com.mercedes.benz.me.pages.BasePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CopyrightTest{
    @Test
    @DisplayName("Checking for text on the main page (©2025 Mercedes-Benz USA, LLC. All rights reserved)")
    public void test1() {
        String actual = new BasePage()
                .openHomePage()
                .scrollSite()
                .getTextCopyrightMercedesBenzUsa();
        Assertions.assertEquals("©2025 Mercedes-Benz USA, LLC. All rights reserved.", actual);
    }
    @Test
    @DisplayName("get text privacy notice")
    public void test2() {
        String actual = new BasePage()
                .openHomePage()
                .scrollSite()
                .getTextPrivacyNotice();

        Assertions.assertEquals("Privacy Notice", actual);
    }
    @AfterEach
    public void driverQuit(){
        SeleniumWebDriver.quitDriver();
    }
}
