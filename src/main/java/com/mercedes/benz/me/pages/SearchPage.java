package com.mercedes.benz.me.pages;

import com.mercedes.benz.me.driver.SeleniumWebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class SearchPage extends CopyrightPage {

    private WebDriver driver;
    private final By SHADOW_HOST_SELECTOR = By.cssSelector("owc-footer");
    private final By COPYRIGHT_TEXT_MERCEDES_BENZ_USA = By.cssSelector("a.owc-lower-footer-legal__link");
    private static final By SHADOW_HOST_SELECTOR_FROM_SEARCH = By.cssSelector("fss-search-input");
    private static final By ONLINE_CODE_TEXT = By.cssSelector("span.search-input__label");
    private final By SEARCH_WINDOW = By.id("fss-search-input");
    private final By SEARCH_BOX_TEXT = By.cssSelector("wb7-control-hint.wb-padding-bottom-3xs.wb-control-hint.hydrated");

    public SearchPage() {
        driver = SeleniumWebDriver.getDriver();
    }


    public SearchPage clickTextCopyrightMercedesBenzUsa() {
        WebElement parentElement = driver.findElement(SHADOW_HOST_SELECTOR);
        SearchContext context = parentElement.getShadowRoot();
        WebElement element = context.findElement(COPYRIGHT_TEXT_MERCEDES_BENZ_USA);
        element.click();
        return this;
    }

    public SearchPage switchToLastWindow() {
        SeleniumWebDriver.switchToLastWindow();
        return this;
    }

    public String gettingTabAddress() {
        return SeleniumWebDriver.getTabUrl();
    }

    public boolean isPresenceWindowSearch() {
        return !driver.findElements(SEARCH_WINDOW).isEmpty();
    }

    public String getTextOnlineCode() {
        return SeleniumWebDriver.actionWithShadowElement(SHADOW_HOST_SELECTOR_FROM_SEARCH, ONLINE_CODE_TEXT).getText();
    }


    public String getSearchBoxText() {
        return SeleniumWebDriver.actionWithShadowElement(SEARCH_WINDOW, SEARCH_BOX_TEXT).getText();
    }

    public static String getShadowText() {
        WebDriver driver = SeleniumWebDriver.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement shadowHost = wait.until(ExpectedConditions.presenceOfElementLocated(SHADOW_HOST_SELECTOR_FROM_SEARCH));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        SearchContext shadowRoot = (SearchContext) js.executeScript("return arguments[0].shadowRoot", shadowHost);

        if (shadowRoot == null) {
            throw new NoSuchElementException("Shadow Root не найден для элемента: " + SHADOW_HOST_SELECTOR_FROM_SEARCH);
        }

        String elementCheck = (String) js.executeScript(
                "return arguments[0].querySelector('" + ONLINE_CODE_TEXT.toString().replace("By.cssSelector: ", "") + "') !== null",
                shadowRoot
        );
        if (!Boolean.parseBoolean(elementCheck)) {
            System.out.println("Элемент с селектором " + ONLINE_CODE_TEXT + " не найден в Shadow DOM");
            return "";
        }

        String text = (String) js.executeScript(
                "return arguments[0].querySelector('" + ONLINE_CODE_TEXT.toString().replace("By.cssSelector: ", "") + "').innerText",
                shadowRoot
        );
        return text != null ? text.trim() : "";
    }
}

