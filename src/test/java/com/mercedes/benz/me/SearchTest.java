package com.mercedes.benz.me;

import com.mercedes.benz.me.driver.SeleniumWebDriver;
import com.mercedes.benz.me.pages.BasePage;
import jdk.jfr.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SearchTest {
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
    @Description("Clicking on the search icon and checking for the presence of text(Your search term / OnlineCode)")
    public void test2() {
        String actual = new BasePage()
                .openHomePage()
                .clickInputSearch()
                .getShadowText();
        Assertions.assertEquals("Your search term / OnlineCode", actual);
    }

    @AfterEach
    public void driverQuit() {
        SeleniumWebDriver.quitDriver();
    }

    @Test
    public void test3() {
        String actual = new BasePage()
                .openHomePage()
                .clickInputSearch()
                .getSearchBoxText();
        Assertions.assertEquals("Search using vehicle types, models, configuration codes or for ACCESSORIES, other products and information", actual);
    }
}
