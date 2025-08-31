package com.mercedes.benz.me;

import com.mercedes.benz.me.driver.SeleniumWebDriver;
import com.mercedes.benz.me.pages.BasePage;
import com.mercedes.benz.me.pages.HomePage;
import org.junit.jupiter.api.*;


import static com.mercedes.benz.me.driver.SeleniumWebDriver.getDriver;


public class AnyTest {

    @Test
    @DisplayName("Checking for the presence of a search window")
    public void test() {
        boolean actual = new BasePage()
                .openHomePage()
                .clickInputSearch()
                .isPresenceWindowSearch();
        Assertions.assertTrue(actual);
    }

    @Test
    @DisplayName("Checking for text on the main page (©2025 Mercedes-Benz USA, LLC. All rights reserved)")
    public void test2() {
        String actual = new BasePage()
                .openHomePage()
                .scrollSite()
                .getTextCopyrightMercedesBenzUsa();
        Assertions.assertEquals("©2025 Mercedes-Benz USA, LLC. All rights reserved.", actual);
    }

    @Test
    @DisplayName("Checking that the correct page has opened.")
    public void test3() {

        String actual = new BasePage()
                .openHomePage()
                .scrollSite()
                .clickTextCopyrightMercedesBenzUsa()
                .gettingTabAddress();
        Assertions.assertEquals("https://www.mbusa.com/en/copyright", actual);
    }

    @AfterEach
    public void quit() {
        SeleniumWebDriver.quitDriver();
    }
}
