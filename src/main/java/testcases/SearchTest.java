package main.java.testcases;

import main.java.pages.LuciannaMainPage;
import org.junit.AfterClass;
import org.testng.annotations.Test;

import static main.java.setup.SeleniumDriver.clearBrowserCache;
import static main.java.setup.SeleniumDriver.getDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by ad on 18.05.2015.
 */
public class SearchTest {

    public static final String TEST = "Test";

    @Test(groups = {"positive"})
    public void searchTest() {
        LuciannaMainPage page = new LuciannaMainPage().open();
        page.mainPageSearch(TEST);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(page.getTitle().getText().contains("TEST"));
        assertEquals(page.getProducts().size(), 2);
    }

    @AfterClass
    public static void tearDown() {
        clearBrowserCache();
        getDriver().quit();
        getDriver().close();

    }
}
