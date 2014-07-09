package com.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class UGCUserSignUp {
    private WebDriver driver;
    private Actions actions;
    private static final String baseUrl = "http://www.qa15.d";
    private boolean acceptNextAlert = true;
    private StringBuilder verificationErrors = new StringBuilder();

    private static final int WAIT_SECONDS = 10;
    private static final String FIRST_NAME_VALUE = "Autotest";
    private static final String LAST_NAME_VALUE = "Signup-Email";
    private static final String PASSWORD_VALUE = "123456";

    //TODO: Move into page object and rename as just SIGN_UP
    public static final By START_SIGN_UP = By.cssSelector(".sign-up");
    public static final By SIGN_IN = By.linkText("Sign in");
    public static final By AVATAR = By.cssSelector(".avatar");
    public static final By LOGOUT = By.linkText("Logout");

    //TODO: Move into SignUp page object
    public static final By EMAIL_FIELD = By.name("email");
    public static final By FIRST_NAME_FIELD = By.name("profile.firstName");
    public static final By LAST_NAME_FIELD = By.name("profile.lastName");
    public static final By CREATE_PASSWORD_FIELD = By.name("password");
    public static final By REPEAT_PASSWORD_FIELD = By.name("passwordRetype");
    public static final By DATA_TERMS_FIELD = By.id("data.terms");
    //TODO: Rename as just SIGN_UP after moved into page object
    public static final By COMPLETE_SIGN_UP = By.xpath("//input[@value='Signup']");

    // Tell us more...
    public static final By PAGE_STRAPLINE = By.className("hasStrapline");
    public static final By SKIP_THIS_STEP = By.linkText("Skip this step");
    public static final By FINISH = By.xpath("//input[@value='Finish']");

    // Edit Profile...
    public static final By SAVE_CHANGES = By.xpath("//input[@value='Save changes']");
    public static final By ACCOUNT = By.linkText("Account");

    private String newEmailAddress() {
        return String.format("%s@email.com", getDateTime());
    }

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(WAIT_SECONDS, TimeUnit.SECONDS);
        driver.get(baseUrl + "/london");  // could add "/404" to this as page not found loads quicker.
    }

    @Test
    public void testNewUserCanSignUpByEmail() throws Exception {
        click(START_SIGN_UP);
        // Sign up page...
        String email = newEmailAddress();
        input(EMAIL_FIELD, email);
        input(FIRST_NAME_FIELD, FIRST_NAME_VALUE);
        input(LAST_NAME_FIELD, LAST_NAME_VALUE);
        input(CREATE_PASSWORD_FIELD, PASSWORD_VALUE);
        input(REPEAT_PASSWORD_FIELD, PASSWORD_VALUE);
        click(DATA_TERMS_FIELD);
        click(COMPLETE_SIGN_UP);
        // Tell us more form...
        waitForElement(FINISH);
        assertEquals("Tell us more about yourself", find(PAGE_STRAPLINE).getText());
        click(SKIP_THIS_STEP);
        // Edit profile page...
        waitForElement(SAVE_CHANGES);
        assertTrue(isElementPresent(By.xpath("//h1[text()='Edit profile']")));
        click(ACCOUNT);
        assertEquals(FIRST_NAME_VALUE, find(By.id("firstName")).getAttribute("value"));
        assertEquals(LAST_NAME_VALUE, find(By.id("lastName")).getAttribute("value"));
        assertEquals(email, find(By.id("email")).getAttribute("value"));
        // Logout...
        actions.moveToElement(find(AVATAR)).perform();
        click(LOGOUT);
        // Log back in to ensure new user has been registered correctly...
        click(SIGN_IN);
        input(By.name("username"), email);
        input(CREATE_PASSWORD_FIELD, PASSWORD_VALUE);
//        click(By.xpath("//input[@value='Sign in']"));
        click(SIGN_IN);
        // Logout again...
        waitForElement(AVATAR);
        actions.moveToElement(find(AVATAR)).perform();
        click(LOGOUT);
        assertTrue(isElementPresent(SIGN_IN));
    }

    @Test
    public void testMustAcceptTermsToSignUp() throws Exception {
        click(START_SIGN_UP);
        input(EMAIL_FIELD, newEmailAddress());
        input(FIRST_NAME_FIELD, FIRST_NAME_VALUE);
        input(LAST_NAME_FIELD, LAST_NAME_VALUE);
        input(CREATE_PASSWORD_FIELD, PASSWORD_VALUE);
        input(REPEAT_PASSWORD_FIELD, PASSWORD_VALUE);
        click(COMPLETE_SIGN_UP);
        assertEquals("This field is required", find(By.cssSelector(".error-msg[data-bound-to='data.terms']")).getText());
    }

    @Test
    public void testMustEnterNewPassword() throws Exception {
        click(START_SIGN_UP);
        input(EMAIL_FIELD, newEmailAddress());
        input(FIRST_NAME_FIELD, FIRST_NAME_VALUE);
        input(LAST_NAME_FIELD, LAST_NAME_VALUE);
        click(DATA_TERMS_FIELD);
        click(COMPLETE_SIGN_UP);
        assertEquals("This field is required", find(By.cssSelector(".error-msg[data-bound-to='password']")).getText());
    }

    @Test
    public void testPasswordMustBeOfMinimumLength() throws Exception {
        click(START_SIGN_UP);
        input(EMAIL_FIELD, newEmailAddress());
        input(FIRST_NAME_FIELD, FIRST_NAME_VALUE);
        input(LAST_NAME_FIELD, LAST_NAME_VALUE);
        input(CREATE_PASSWORD_FIELD, PASSWORD_VALUE.substring(0, 4));
        input(REPEAT_PASSWORD_FIELD, PASSWORD_VALUE.substring(0,4));
        click(DATA_TERMS_FIELD);
        click(COMPLETE_SIGN_UP);
        assertEquals("Password does not meet complexity requirements", find(By.cssSelector(".error-msg[data-bound-to='password']")).getText());
    }

    @Test
    public void testRepeatPasswordMustMatchNewPassword() throws Exception {
        click(START_SIGN_UP);
        input(EMAIL_FIELD, newEmailAddress());
        input(FIRST_NAME_FIELD, FIRST_NAME_VALUE);
        input(LAST_NAME_FIELD, LAST_NAME_VALUE);
        input(CREATE_PASSWORD_FIELD, PASSWORD_VALUE);
        input(REPEAT_PASSWORD_FIELD, PASSWORD_VALUE + "mismatch");
        click(DATA_TERMS_FIELD);
        click(COMPLETE_SIGN_UP);
        assertEquals("Passwords do not match", find(By.cssSelector(".error-msg[data-bound-to='passwordRetype']")).getText());
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public void waitForElement(By locator) {
        (new WebDriverWait(driver, WAIT_SECONDS)).
                until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public String getDateTime() {
        return getDateTime("ddMMyyHHmmss");
    }

    public String getDateTime(String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date date = new Date();
        return dateFormat.format(date);
    }

    public WebElement find(By locator) {
        WebElement element = null;
        try {
            element = driver.findElement(locator);
        } catch (NoSuchElementException e) {
            fail("Element '" + locator.toString() + "' could not be found.");
        }
        return element;
    }

    public void input(By locator, String value) {
        WebElement inputElement = find(locator);
        inputElement.clear();
        inputElement.sendKeys(value);
    }

    public void click(By locator) {
        find(locator).click();
    }

     private void waitForPageToLoad() {

        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                    }
                };

        Wait<WebDriver> wait = new WebDriverWait(driver, 30);
        try {
            wait.until(expectation);
        } catch (Throwable error) {
            assertFalse("Timeout waiting for Page Load Request to complete.", true);
        }
    }

    private boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
