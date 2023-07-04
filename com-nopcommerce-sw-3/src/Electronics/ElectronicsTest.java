package Electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class ElectronicsTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void SetUp() {

        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() throws InterruptedException {
        //1.1 Mouse Hover on “Electronics” Tab
        mouseHoverOnElement(By.xpath("//ul[@class='top-menu notmobile']/li/a[text()='Electronics ']"));
        Thread.sleep(700);
        //1.2Mouse Hover on “Cell phones” and click
        mouseHoverAndClickOnElement(By.xpath("//ul[@class='top-menu notmobile']/li/ul[@class='sublist first-level']/li/a[text()='Cell phones ']"));
        Thread.sleep(700);
        //1.3Verify the text “Cell phones”
        verifyText(By.xpath("//h1[normalize-space()='Cell phones']"),"Cell phones");
        Thread.sleep(700);
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        //2.1Mouse Hover on “Electronics” Tab
        mouseHoverOnElement(By.xpath("//ul[@class='top-menu notmobile']/li/a[text()='Electronics ']"));
        Thread.sleep(700);
        //2.2Mouse Hover on “Cell phones” and click
        mouseHoverAndClickOnElement(By.xpath("//body[1]/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        Thread.sleep(700);
        //2.3Verify the text “Cell phones”
        verifyText(By.xpath("//h1[normalize-space()='Cell phones']"),"Cell phones");
        Thread.sleep(700);
        //2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));
        Thread.sleep(700);
        //2.5 Click on product name “Nokia Lumia 1020” link
        clickOnElement(By.partialLinkText("Lumia"));
        Thread.sleep(700);
        //2.6 Verify the text “Nokia Lumia 1020”
        verifyText(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"),"Nokia Lumia 1020");
        Thread.sleep(700);
        //2.7 Verify the price “$349.00”
        verifyText(By.xpath("//span[@id='price-value-20']"),"$349.00");
        Thread.sleep(700);
        //2.8 Change quantity to 2
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).clear();
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"),"2");
        Thread.sleep(700);
        //2.9 Click on “ADD TO CART” tab
        clickOnElement(By.xpath("//button[@class='button-1 add-to-cart-button']"));
        Thread.sleep(700);
        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        verifyText(By.xpath("//div[@class='bar-notification success']/p"),"The product has been added to your shopping cart");
        Thread.sleep(700);
        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//div[@class='bar-notification success']/span"));
        Thread.sleep(700);
        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverOnElement(By.xpath("//span[@class='cart-label']"));
        clickOnElement(By.xpath("//button[@class='button-1 cart-button']"));
        Thread.sleep(700);
        //2.12 Verify the message "Shopping cart"
        verifyText(By.xpath("//div[@class='page-title']/h1"),"Shopping cart");
        Thread.sleep(700);
        //2.13 Verify the quantity is 2
        WebElement text = driver.findElement(By.xpath("//input[@class='qty-input']"));
        String expectedText1 = "2";
        String actualText2 = text.getAttribute("value");
        Assert.assertEquals("not equal", expectedText1, actualText2);
        Thread.sleep(700);
        //2.14 Verify the Total $698.00
        verifyText(By.xpath("//tbody/tr[1]/td[6]/span[1]"),"$698.00");
        Thread.sleep(700);
        //2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        Thread.sleep(700);
        //2.16 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        Thread.sleep(700);
        //2.17 Verify the Text “Welcome, Please Sign In!”
        verifyText(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"),"Welcome, Please Sign In!");
        Thread.sleep(700);
        //2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));
        Thread.sleep(700);
        //2.19 Verify the text “Register”
        verifyText(By.xpath("//button[contains(text(),'Register')]"),"REGISTER");
        //2.20 Fill the mandatory fields
        Thread.sleep(1000);
        //Enter First Name
        sendTextToElement(By.id("FirstName"), "Divyesh");
        //Enter Last Name
        sendTextToElement(By.id("LastName"), "Ramesh");
        //Enter Date
        sendTextToElement(By.xpath("//select[@name='DateOfBirthDay']"), "25");
        //Enter Month
        sendTextToElement(By.xpath("//select[@name='DateOfBirthMonth']"), "November");
        //Enter Year
        sendTextToElement(By.xpath("//select[@name='DateOfBirthYear']"), "1994");
        //Enter Email
        sendTextToElement(By.id("Email"), "diyeish123@gmail.com");
        //Enter Password
        sendTextToElement(By.id("Password"), "Xyz123");
        //Enter Confirm password
        sendTextToElement(By.id("ConfirmPassword"), "Xyz123");
        //2.21 Click on “REGISTER” Button
        Thread.sleep(1000);
        clickOnElement(By.id("register-button"));
        //2.22 Verify the message “Your registration completed”
        Thread.sleep(1000);
        verifyText(By.xpath("//div[contains(text(),'Your registration completed')]"),"Your registration completed");
        //2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        //2.24 Verify the text “Shopping cart”
        verifyText(By.xpath("//h1[contains(text(),'Shopping cart')]"),"Shopping cart");
        //2.25 click on checkbox “I agree with the terms of service”
        Thread.sleep(1000);
       clickOnElement(By.xpath("//input[@id='termsofservice']"));
        //2.26 Click on “CHECKOUT”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@id='checkout']"));
        //2.27 Fill the Mandatory fields
        Thread.sleep(1000);
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "United Kingdom");
        Thread.sleep(1000);
        //selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_StateProvinceId']"), "London");
        //Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "London");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"), "1234 Raleigh St.");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "Ha0 4hg");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "07456345678");
        //2.28 Click on “CONTINUE”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));
        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@id='shippingoption_2']"));
        //2.30 Click on “CONTINUE”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        //2.31 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));
        //2.32 Select “Visa” From Select credit card dropdown
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"), "Visa");
        //2.33 Fill all the details
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Mr D Lima");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "5555555555554444");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "05");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2025");
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "123");
        Thread.sleep(700);
        //2.34 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        Thread.sleep(700);
        //2.35 Verify “Payment Method” is “Credit Card”
        verifyText(By.xpath("//span[contains(text(),'Credit Card')]"),"Credit Card");
        Thread.sleep(700);
        //2.36 Verify “Shipping Method” is “2nd Day Air”
        verifyText(By.xpath("//li[@class='shipping-method']/span[@class='value']"),"2nd Day Air");
        Thread.sleep(700);
        //2.37 Verify Total is “$698.00”
        verifyText(By.xpath("//tbody/tr[1]/td[6]/span[1]"),"$698.00");
        Thread.sleep(700);
        //2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
        Thread.sleep(700);
        //2.39 Verify the Text “Thank You”
        verifyText(By.xpath("//h1[text()='Thank you']"),"Thank you");
        Thread.sleep(700);
        //2.40 Verify the message “Your order has been successfully processed!”
        verifyText(By.xpath("//strong[text()='Your order has been successfully processed!']"),"Your order has been successfully processed!");
        Thread.sleep(700);
        //2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 order-completed-continue-button']"));
        Thread.sleep(700);
        //2.42 Verify the text “Welcome to our store”
        verifyText(By.xpath("//h2[text()='Welcome to our store']"),"Welcome to our store");
        Thread.sleep(700);
        //2.43 Click on “Logout” link
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));
        Thread.sleep(700);
        //2.44 Verify the URL is “https://demo.nopcommerce.com/”
        String expectedMessage17 = "https://demo.nopcommerce.com/";
        String actualMessage17 = driver.getCurrentUrl();
        //Validate actual and Expected message
        Assert.assertEquals("Not match Url",expectedMessage17, actualMessage17);
        Thread.sleep(700);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
