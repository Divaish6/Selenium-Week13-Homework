package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class GearTest extends Utility {

    @Before
    public void setUp() {
        openBrowser();
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppinCart() throws InterruptedException {
        //Mouse Hover on Gear Menu
        mouseHoverOnElement(By.xpath("//a[@id='ui-id-6']"));
        Thread.sleep(500);
        //Click on Bags
        mouseHoverAndClickOnElement(By.xpath("//span[contains(text(),'Bags')]"));
        Thread.sleep(500);
        //Click on Product Name ‘Overnight Duffle’
        clickOnElement(By.xpath("//a[contains(text(),'Overnight Duffle')]"));
        Thread.sleep(500);
        //Verify the product name ‘Overnight Duffle’
        //verifyText(By.id("//span[contains(text(),'Overnight Duffle')]"), "Overnight Duffle");
        //Thread.sleep(500);
        //Change Qty 3
        driver.findElement(By.xpath("//input[@id='qty']")).clear();
        Thread.sleep(200);
        sendTextToElement(By.xpath("//input[@id='qty']"), "3");
        Thread.sleep(500);
        //Click on ‘Add to Cart’ Button.
        clickOnElement(By.xpath("//span[contains(text(),'Add to Cart')]"));
        Thread.sleep(500);
        //Verify the text‘You added Overnight Duffle to your shopping cart.’
        verifyText(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"),
                "You added Overnight Duffle to your shopping cart.");
        Thread.sleep(500);
        //Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        Thread.sleep(500);
        //Verify the Qty is ‘3’
       // verifyText(By.linkText("Qty"), "3");
        //Verify the product price ‘$135.00’
       // verifyText(By.id("//tbody/tr[1]/td[4]/span[1]/span[1]/span[1]"), "$135.00");
        //Change Qty to ‘5’
        driver.findElement(By.cssSelector("td[class='col qty'] input[class*='input-text qty']")).clear();
        sendTextToElement(By.cssSelector("td[class='col qty'] input[class*='input-text qty']"), "5");
        //Click on ‘Update Shopping Cart’ button
        clickOnElement(By.xpath("//span[text()='Update Shopping Cart']"));
        //Verify the product price ‘$225.00’
        verifyText(By.xpath("//span[@class='cart-price']//span[@class='price'][text()='$225.00']"), "$225.00");

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
