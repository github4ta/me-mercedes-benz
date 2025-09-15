package com.mercedes.benz.me;

import com.mercedes.benz.me.pages.BasePage;
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
}
