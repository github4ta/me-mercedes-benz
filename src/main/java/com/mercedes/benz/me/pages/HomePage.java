package com.mercedes.benz.me.pages;

import com.mercedes.benz.me.driver.SeleniumWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {

    private final By HEADER_PRIVACY_POLICY_ICON = By.xpath("//a[@data-test-id='header-privacy-policy']");
    private final By HEADER_INTEGRATION_ITEM_FSS_SEARCH_INPUT = By.xpath("//a[@data-test-id='header-integration-item-fss-search-input']");
    private final By PARENT_SELECTOR = By.cssSelector("owc-footer");
    private final By COPYRIGHT = By.cssSelector("li.owc-lower-footer-legal__license");
    private final By TERMS_OF_USE = By.cssSelector("li.owc-lower-footer-legal__item");
    private final By PRIVACY_NOTICE = By.cssSelector("li.owc-lower-footer-legal__item");
    private final By PRIVATE_CUSTOMER = By.xpath("(//div[@class='hp-icon-img wb-icon'])[4]");
    private final By PARENT_SELECTOR_PRIVATE_CUSTOMER = By.cssSelector("iam-user-menu-v3");
    private final By TEXT_YOUR_MERCEDES_BENZ_ACCOUNT = By.cssSelector("wb7-heading[data-test-id=user-menu-title]");

    private final WebDriver driver;

    public HomePage() {
        driver = SeleniumWebDriver.getDriver();
    }

    public HomePage clickInputSearch() {
        driver.findElement(HEADER_INTEGRATION_ITEM_FSS_SEARCH_INPUT).click();
        return this;
    }

    public HomePage clickCopyright() {
        WebElement parentElement = driver.findElement(PARENT_SELECTOR);
        SearchContext context = parentElement.getShadowRoot();
        WebElement element = context.findElement(COPYRIGHT);
        element.click();
        return this;
    }

    public HomePage clickTermsOfUse() {
        WebElement parentElement = driver.findElement(PARENT_SELECTOR);
        SearchContext context = parentElement.getShadowRoot();
        WebElement element = context.findElement(TERMS_OF_USE);
        element.click();
        return this;
    }

    public String getTextCopyright() {
        WebElement parentElement = driver.findElement(PARENT_SELECTOR);
        SearchContext context = parentElement.getShadowRoot();
        return context.findElement(COPYRIGHT).getText();
    }

    public String getTextTermsOfUse() {
        WebElement parentElement = driver.findElement(PARENT_SELECTOR);
        SearchContext context = parentElement.getShadowRoot();
        return context.findElement(TERMS_OF_USE).getText();
    }

    public String getTextPrivacyNotice() {
        WebElement parentElement = driver.findElement(PARENT_SELECTOR);
        SearchContext context = parentElement.getShadowRoot();
        return context.findElement(PRIVACY_NOTICE).getText();
    }

    public HomePage clickPrivateCustomer() {
        driver.findElement(PRIVATE_CUSTOMER).click();
        return this;
    }

    public String getTextYourMercedesBenzAccount() {
        WebElement parentElement = driver.findElement(PARENT_SELECTOR_PRIVATE_CUSTOMER);
        SearchContext context = parentElement.getShadowRoot();
        return context.findElement(TEXT_YOUR_MERCEDES_BENZ_ACCOUNT).getText();

    }

    public LegalNoticesPage clickHeaderPrivacyPolicyIcon() {
        driver.findElement(HEADER_PRIVACY_POLICY_ICON).click();
        return new LegalNoticesPage();
    }

    public HomePage scrollSite() {
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0, 900).perform();
        return this;
    }
}
