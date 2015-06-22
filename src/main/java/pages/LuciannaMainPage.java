package main.java.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/**
 * Created by ad on 18.05.2015.
 */
public class LuciannaMainPage extends LuciannaPage<LuciannaMainPage> {

    @FindBy(id="search_mini")
    WebElement searchField;
    @FindBy(css="#mini-search-submit")
    WebElement searchButton;
    @FindBy(css = ".product-title.page-title")
    WebElement title;
    @FindBy(css = ".product-thumbnail.group")
    List<WebElement> products;
    @FindBy(id="search_mini")
    WebElement searchBar;
    @FindBy(id="mini-search-submit")
    WebElement SearchBTN;


    @Override
    protected ExpectedCondition getPageLoadCondition() {
        return ExpectedConditions.titleContains("Products");
    }

    @Override
    public String getPageUrl() {
        return "";
    }

    public LuciannaLoginPage goToLoginPage() {
        return new LuciannaLoginPage().openPage(LuciannaLoginPage.class);
    }

    public LuciannaMainPage open() {
        return new LuciannaMainPage().openPage(LuciannaMainPage.class);
    }

    public void mainPageSearch(String text){
        searchField.sendKeys(text);
        searchField.sendKeys(Keys.RETURN);
    }

    public WebElement getTitle() {
        return title;
    }

    public List<WebElement> getProducts() {
        return products;
    }

    public void typeValueInSearch(String _SearchValue) {
        searchBar.clear();
        searchBar.sendKeys(_SearchValue);
        SearchBTN.click();
    }
}
