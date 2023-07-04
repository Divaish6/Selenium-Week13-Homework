package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

/**
 * 1. create class "TopMenuTest"
 * 1.1 create method with name "selectMenu" it has one parameter name "menu" of type
 * string
 * 1.2 This method should click on the menu whatever name is passed as parameter.
 * 1.3. create the @Test method name verifyPageNavigation.use selectMenu method to
 * select the Menu and click on it and verify the page navigation.
 */

public class TopMenuTest extends Utility {

    String baseUrl ="https://demo.nopcommerce.com/";

    @Before
    public void SetUp(){

        openBrowser(baseUrl);
    }

    public void selectMenu(String menu){


        //This method should click on the menu whatever name is passed as parameter.
        clickOnElement(By.linkText(menu));
    }

    @Test
    public void verifyPageNavigation()
    {
      selectMenu("Computers");
        String expectedNavigation ="https://demo.nopcommerce.com/computers";
        String actualNavigation = driver.getCurrentUrl();
        Assert.assertEquals("Not Page navigation",expectedNavigation,actualNavigation);
    }
    @After
    public void tearDown() {
        closeBrowser();
    }


}
