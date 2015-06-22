package main.java.testcases;

import main.java.pages.LuciannaLoginPage;
import main.java.pages.LuciannaMainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/**
 * Created by ad on 18.05.2015.
 */
public class SampleTest1 {
    public static final String EMAIL = "www@www.www";
    public static final String PASSWORD = "123456789";

    @Test
    public void searchCorrectValue() throws Exception {
        LuciannaLoginPage loginPage = new LuciannaMainPage().open().goToLoginPage();
        loginPage.login(EMAIL, PASSWORD);
        LuciannaMainPage MainPage = new LuciannaMainPage().openPage(LuciannaMainPage.class);
        MainPage.typeValueInSearch("Бра");



//   assertTrue(driver.findElement((By.cssSelector("img.woocommerce-placeholder.wp-post-image"))).isDisplayed());
//        assertTrue(driver.findElement((By.xpath("(//img[@alt='Placeholder'])[2]"))).isDisplayed());
//        assertTrue(driver.findElement((By.xpath("(//img[@alt='Placeholder'])[3]"))).isDisplayed());
//        assertTrue(driver.findElement((By.xpath("(//img[@alt='Placeholder'])[4]"))).isDisplayed());
//        assertTrue(driver.findElement((By.xpath("(//img[@alt='Placeholder'])[5]"))).isDisplayed());


    }

    @Test
    public void testRegistration() {
        System.out.println("Registration");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://luciana.integro.kiev.ua/");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            driver.quit();
        }

    }

    @Test(dependsOnMethods = {"testRegistration"})
    public void testLogin() {
        System.out.println("Login to lucianna");
    }

    @Test(dependsOnMethods = {"testLogin"})
    public void testChangePassword() {
        System.out.println("Change password");
    }

    @Test
    public void testSomeAssert() {
        System.out.println("Change password");
    }
}
