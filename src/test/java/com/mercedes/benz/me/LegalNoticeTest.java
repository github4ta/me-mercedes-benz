package com.mercedes.benz.me;

import com.mercedes.benz.me.driver.SeleniumWebDriver;
import com.mercedes.benz.me.pages.BasePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LegalNoticeTest {

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
    @DisplayName("get URL address")
    public void test1() {
        String actual = new BasePage()
                .openHomePage()
                .clickHeaderPrivacyPolicyIcon()
                .getUrlAddress();

        Assertions.assertEquals("https://www.mbusa.com/en/legal-notices", actual);

    }

    @Test
    public void ternDawn() {
        SeleniumWebDriver.quitDriver();
    }
}
