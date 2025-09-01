package com.mercedes.benz.me;

import com.mercedes.benz.me.driver.SeleniumWebDriver;
import com.mercedes.benz.me.pages.BasePage;
import org.junit.jupiter.api.*;

public class AnyTest {

    @Test
    @DisplayName("get legal notices text")
    public void test() {
        String actual = new BasePage()
                .openHomePage()
                .clickHeaderPrivacyPolicyIcon()
                .getTextLegalNotices();

        Assertions.assertEquals("Legal Notices", actual);
    }

    @Test
    @DisplayName("get text YourMercedesBenzAccount")
    public void test1(){
        String actual = new BasePage()
                .openHomePage()
                .clickPrivateCustomer()
                .getTextYourMercedesBenzAccount();

        Assertions.assertEquals("Your Mercedes-Benz Account", actual);
    }

    @Test
    @DisplayName("get text privacy notice")
    public void test2(){
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
