package computer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TestSuite extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void SetUp() {

        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() throws InterruptedException {
        //Click on Computer Menu.
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']/li/a[text()='Computers ']"));
        //Click on Desktop
        clickOnElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));
        //Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: Z to A");
        //verify the ordering is priced high to low
        verifyText(By.xpath("//select[@id='products-orderby']/option[text()='Name: Z to A']"), "Name: Z to A");
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //Click on Computer Menu.
        Thread.sleep(1000);
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']/li/a[text()='Computers ']"));
        //Click on Desktop
        Thread.sleep(1000);
        clickOnElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));
        //Select Sort By position "Name: A to Z"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: A to Z");
        //Click on "Add To Cart"
        Thread.sleep(1000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]"));
        //Verify the Text "Build your own computer"
        verifyText(By.xpath("//div[@class='product-name']/h1"), "Build your own computer");
        Thread.sleep(1000);
        //Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByVisibleTextFromDropDown(By.xpath("//select[@name='product_attribute_1']"), "2.2 GHz Intel Pentium Dual-Core E2200");
        //Select "8GB [+$60.00]" using Select class.
        selectByVisibleTextFromDropDown(By.xpath("//select[@name='product_attribute_2']"), "8GB [+$60.00]");
        //Select HDD radio "400 GB [+$100.00]"
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@id='product_attribute_3_7']"));
        //Select OS radio "Vista Premium [+$60.00]"
        Thread.sleep(1000);
        clickOnElement(By.xpath("//label[text()='Vista Premium [+$60.00]']"));
        //Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@id='product_attribute_5_12']"));
        //Verify the price "$1,475.00"
        verifyText(By.xpath("//span[text()='$1,475.00']"), "$1,475.00");
        //Click on "ADD TO CARD" Button.
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1'] "));
        //Verify the Message "The product has been added to your shopping cart" on Top green Bar
        verifyText(By.xpath("//div[@class='bar-notification success']/p"), "The product has been added to your shopping cart");
        //After that close the bar clicking on the cross button.
        Thread.sleep(1000);
        clickOnElement(By.xpath("//div[@class='bar-notification success']/span"));
        //Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverOnElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));
        //Verify the message "Shopping cart"
        verifyText(By.xpath("//h1[contains(text(),'Shopping cart')]"), "Shopping cart");
        Thread.sleep(1000);
        //Change the Qty to "2" and Click on "Update shopping cart"
        driver.findElement(By.xpath("//input[@class='qty-input']")).clear();
        sendTextToElement(By.xpath("//input[@class='qty-input']"), "2");
        clickOnElement(By.xpath("//button[@class='button-2 update-cart-button']"));
        //Verify the Total"$2,950.00"
        verifyText(By.xpath("//td[@class='subtotal']/span[text()='$2,950.00']"), "$2,950.00");
        Thread.sleep(1000);
        //click on checkbox “I agree with the terms of service”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@name='termsofservice']"));
        //Click on “CHECKOUT”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@name='checkout']"));
        //Verify the Text “Welcome, Please Sign In!”
        Thread.sleep(1000);
        verifyText(By.xpath("//div[@class='page-title']/h1"), "Welcome, Please Sign In!");
        //Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[@class='button-1 checkout-as-guest-button']"));
        //Fill the all mandatory field
        sendTextToElement(By.id("BillingNewAddress_FirstName"), "Xyz");
        sendTextToElement(By.id("BillingNewAddress_LastName"), "Patel");
        sendTextToElement(By.id("BillingNewAddress_Email"), "abcxyz@gmail.com");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "United Kingdom");
        sendTextToElement(By.id("BillingNewAddress_City"), "London");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "129 Main Road");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "NW10AD");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "01234567890");
        //Click on “CONTINUE”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//div[@id='billing-buttons-container']/button[@class='button-1 new-address-next-step-button']"));
        //Click on Radio Button “Next Day Air($0.00)”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@value='Next Day Air___Shipping.FixedByWeightByTotal']"));
        //Click on “CONTINUE”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        //Select Radio Button “Credit Card”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
        //Select “Master card” From Select credit card dropdown
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"), "Master card");
        //Fill all the details
        sendTextToElement(By.id("CardholderName"), "MR NO ONE");
        sendTextToElement(By.id("CardNumber"), "5100 0000 0000 0511");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "01");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2026");
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "123");
        //Click on “CONTINUE”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        //Verify “Payment Method” is “Credit Card”
        verifyText(By.xpath("//li[@class='payment-method']/span[@class='value']"), "Credit Card");
        //Verify “Shipping Method” is “Next Day Air”
        verifyText(By.xpath("//li[@class='shipping-method']/span[@class='value']"), "Next Day Air");
        //Verify Total is “$2,950.00”
        verifyText(By.xpath("//span[@class='product-subtotal']"), "$2,950.00");
        //Click on “CONFIRM”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@class='button-1 confirm-order-next-step-button']"));
        //Verify the Text “Thank You”
        verifyText(By.xpath("//h1[contains(text(),'Thank you')]"), "Thank you");
        //Verify the message “Your order has been successfully processed!”
        verifyText(By.xpath("//div[@class='section order-completed']/div[@class='title']/strong"), "Your order has been successfully processed!");
        //Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 order-completed-continue-button']"));
        //Verify the text “Welcome to our store”
        verifyText(By.xpath("//div[@class='topic-block-title']/h2"), "Welcome to our store");
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}



