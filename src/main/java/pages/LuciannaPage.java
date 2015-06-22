package main.java.pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;

import static main.java.setup.SeleniumDriver.getDriver;

/**
 * Created by ad on 18.05.2015.
 */
public abstract class LuciannaPage <T> {
    private static final String BASE_URL = "http://luciana.integro.kiev.ua/";
    private static final int LOAD_TIMEOUT = 30;
    private static final int REFRESH_RATE = 2;

    public T openPage(Class<T> clazz) {
        T page = PageFactory.initElements(getDriver(), clazz);
        getDriver().get(BASE_URL + getPageUrl());
        ExpectedCondition pageLoadCondition = ((LuciannaPage) page).getPageLoadCondition();
        waitForPageToLoad(pageLoadCondition);
        return page;
    }

    private void waitForPageToLoad(ExpectedCondition pageLoadCondition) {
        Wait wait = new FluentWait(getDriver())
                .withTimeout(LOAD_TIMEOUT, TimeUnit.SECONDS)
                .pollingEvery(REFRESH_RATE, TimeUnit.SECONDS);

        wait.until(pageLoadCondition);
    }

    protected abstract ExpectedCondition getPageLoadCondition();

    public abstract String getPageUrl();
}
