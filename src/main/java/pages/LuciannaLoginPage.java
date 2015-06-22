package main.java.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by ad on 18.05.2015.
 */
public class LuciannaLoginPage extends LuciannaPage<LuciannaLoginPage> {

    @FindBy(id = "username")
    WebElement emailField;

    @FindBy(name = "password")
    WebElement passwordField;

    @FindBy(className = "welcome_username")
    WebElement welcomeUser;

    @FindBy(className = "woocommerce-error")
    WebElement woocommerceError;

    @FindBy(name = "login")
    WebElement registerButton;

    @FindBy(css = "img.woocommerce-placeholder.wp-post-image")
    WebElement foundImagesItems;


    @Override
    protected ExpectedCondition getPageLoadCondition() {
        return ExpectedConditions.visibilityOf(emailField);
    }

    @Override
    public String getPageUrl() {
        return "/?page_id=9";
    }

    public void login(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        registerButton.click();

    }

    public WebElement getWelcomeUser() {
        return welcomeUser;
    }

    public WebElement getWoocommerceError() {
        return woocommerceError;
    }


}
