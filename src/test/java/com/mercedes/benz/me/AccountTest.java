package com.mercedes.benz.me;

import com.mercedes.benz.me.driver.SeleniumWebDriver;
import com.mercedes.benz.me.pages.BasePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AccountTest {


    @Test
    @DisplayName("get text YourMercedesBenzAccount")
    public void test1() {
        String actual = new BasePage()
                .openHomePage()
                .clickPrivateCustomer()
                .getTextYourMercedesBenzAccount();

        Assertions.assertEquals("Your Mercedes-Benz Account", actual);
    }

    @AfterEach
    public void ternDawn() {
        SeleniumWebDriver.quitDriver();
    }
}
