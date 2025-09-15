package com.mercedes.benz.me;


import com.mercedes.benz.me.driver.SeleniumWebDriver;
import com.mercedes.benz.me.pages.BasePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AnyTest {



    @Test
    @DisplayName("Checking that the correct page has opened.")
    public void test3() {

        String actual = new BasePage()
                .openHomePage()
                .scrollSite()
                .clickTextCopyrightMercedesBenzUsa()
                .switchToLastWindow()
                .gettingTabAddress();
        Assertions.assertEquals("https://www.mbusa.com/en/copyright", actual);
    }

    @AfterEach
    public void quit() {
        SeleniumWebDriver.quitDriver();
    }

}
