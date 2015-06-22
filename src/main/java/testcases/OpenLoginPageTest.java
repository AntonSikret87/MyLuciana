package main.java.testcases;

import main.java.pages.LuciannaLoginPage;
import main.java.pages.LuciannaMainPage;
import org.junit.AfterClass;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static main.java.setup.SeleniumDriver.clearBrowserCache;
import static main.java.setup.SeleniumDriver.getDriver;
import static org.testng.Assert.assertTrue;

/**
 * Created by ad on 18.05.2015.
 */
public class OpenLoginPageTest {

    public static final String EMAIL = "www@www.www";
    public static final String NAME = "www";
    public static final String PASSWORD = "123456789";
    public static final String INCORRECT_PASSWORD = "111";
    public static final String LOGIN = "ANTON KA";


    @Test(groups = {"positive"})
    public void loginWithCorrectCredentials() {
        LuciannaLoginPage loginPage = new LuciannaMainPage().open().goToLoginPage();
        loginPage.login(EMAIL, PASSWORD);
        //LucianaHelper.getScreenshot(getDriver());
        assertTrue(loginPage.getWelcomeUser().getText().contains(LOGIN));
    }

    @AfterMethod
    public static void clearCache() {
        clearBrowserCache();
    }

    @Test(groups = {"negative"})
    public void loginWithInCorrectCredentials() {

        LuciannaLoginPage loginPage = new LuciannaMainPage().open().goToLoginPage();
        loginPage.login(EMAIL, INCORRECT_PASSWORD);
        ExpectedConditions.textToBePresentInElement(loginPage.getWoocommerceError(), LOGIN.toLowerCase());
       // LucianaHelper.getScreenshot(getDriver());
        assertTrue(loginPage.getWoocommerceError().getText().contains(NAME.toLowerCase()));

    }

    @AfterClass
    public static void tearDown() {
        clearBrowserCache();
        getDriver().quit();
        getDriver().close();
    }
}
