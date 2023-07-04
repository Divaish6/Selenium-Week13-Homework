package myaccounts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

/**
 * Create the class MyAccountsTest
 * 1.1 create method with name "selectMyAccountOptions" it has one parameter name
 * "option" of type string
 * 1.2 This method should click on the options whatever name is passed as parameter.
 * (Hint: Handle List of Element and Select options)
 */

public class MyAccountsTest extends Utility {

    @Before
    public void setup() {

        openBrowser();
    }

    public void selectMyAccountOptions(String options)  {
        List<WebElement> option = driver.findElements(By.xpath("//nav[@id='top']"));
        clickOnElement(By.linkText(options));

    }


    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() throws InterruptedException {
        //1.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        Thread.sleep(700);
        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");
        Thread.sleep(700);
        //1.3 Verify the text “Register Account”.
        verifyText(By.xpath("//h1[contains(text(),'Register Account')]"), "Register Account");
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() throws InterruptedException {
        //2.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        Thread.sleep(700);
        //2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountOptions("Login");
        Thread.sleep(700);
        //2.3 Verify the text “Returning Customer”.
        verifyText(By.xpath("//h2[contains(text(),'Returning Customer')]"), "Returning Customer");
        Thread.sleep(700);
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
        //3.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        Thread.sleep(700);
        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");
        Thread.sleep(700);
        //3.3 Enter First Name
        sendTextToElement(By.xpath("//input[@id='input-firstname']"), "Diuesh");
        Thread.sleep(700);
        //3.4 Enter Last Name
        sendTextToElement(By.xpath("//input[@id='input-lastname']"), "Ramesj");
        Thread.sleep(700);
        //3.5 Enter Email
        sendTextToElement(By.xpath("//input[@id='input-email']"), "Dijkkesh@gmail.com");
        Thread.sleep(700);
        //3.6 Enter Telephone
        sendTextToElement(By.xpath("//input[@id='input-telephone']"), "0987654432");
        Thread.sleep(700);
        //3.7 Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"), "123Diuesh");
        Thread.sleep(700);
        //3.8 Enter Password Confirm
        sendTextToElement(By.xpath("//input[@id='input-confirm']"), "123Diuesh");
        Thread.sleep(700);
        //3.9 Select Subscribe Yes radio button
        clickOnElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/fieldset[3]/div[1]/div[1]/label[1]/input[1]"));
        Thread.sleep(700);
        //3.10 Click on Privacy Policy check box
        clickOnElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]"));
        Thread.sleep(700);
        //3.11 Click on Continue button
        clickOnElement(By.xpath("//input[@value ='Continue']"));
        Thread.sleep(700);
        //3.12 Verify the message “Your Account Has Been Created!”
        verifyText(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"), "Your Account Has Been Created!");
        Thread.sleep(700);
        //3.13 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        Thread.sleep(700);
        //3.14 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        Thread.sleep(700);
        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout");
        Thread.sleep(700);
        //3.16 Verify the text “Account Logout”
        verifyText(By.xpath("//h1[contains(text(),'Account Logout')]"), "Account Logout");
        Thread.sleep(700);
        //3.17 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        Thread.sleep(700);
    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException {
        //4.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        Thread.sleep(700);
        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountOptions("Login");
        Thread.sleep(700);
        //4.3 Enter Email address
        sendTextToElement(By.xpath("//input[@id='input-email']"), "Diyesh@gmail.com");
        Thread.sleep(700);
        //4.4 Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"), "123Diuesh");
        Thread.sleep(700);
        //4.6 Click on Login button
        clickOnElement(By.xpath("//input[@value='Login']"));
        Thread.sleep(700);
        //4.7 Verify text “My Account”
        verifyText(By.xpath("//h2[contains(text(),'My Account')]"), "My Account");
        Thread.sleep(700);
        //4.8 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        Thread.sleep(700);
        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout");
        Thread.sleep(700);
        //4.10 Verify the text “Account Logout”
        verifyText(By.xpath("//h1[contains(text(),'Account Logout')]"), "Account Logout");
        Thread.sleep(700);
        //4.11 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        Thread.sleep(700);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
