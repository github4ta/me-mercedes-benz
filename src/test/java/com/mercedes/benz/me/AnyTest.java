package com.mercedes.benz.me;

import com.mercedes.benz.me.driver.SeleniumWebDriver;
import com.mercedes.benz.me.pages.BasePage;
import com.mercedes.benz.me.pages.HomePage;
import org.junit.jupiter.api.*;

public class AnyTest {
    @Test
    @DisplayName("Checking for the presence of a search window")
    public void test(){
        boolean actual = new BasePage()
                .openHomePage()
                .clickInputSearch()
                .isPresenceWindowSearch();
        Assertions.assertTrue(actual);
    }
    @AfterEach
    public void quit(){
        SeleniumWebDriver.quitDriver();
    }
}
