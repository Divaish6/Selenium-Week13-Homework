package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {

    @Before
    public void setup() {
        openBrowser();
    }

    public void selectMenu(String menu) {
        clickOnElement(By.linkText(menu));
    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() throws InterruptedException {
        //Mouse hover on “Desktops” Tab and click
        mouseHoverOnElement(By.linkText("Desktops"));
        //call selectMenu method and pass the menu = “Show All Desktops”
        selectMenu("Show AllDesktops");
        Thread.sleep(700);
        // Verify the text ‘Desktops’
        verifyText(By.xpath("//h2[contains(text(),'Desktops')]"),"Desktops");
        Thread.sleep(700);

    }
    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() throws InterruptedException {
        //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        mouseHoverOnElement(By.linkText("Laptops & Notebooks"));
        //2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        selectMenu("Show AllLaptops & Notebooks");
        Thread.sleep(700);
        //2.3 Verify the text ‘Laptops & Notebooks’
        verifyText(By.linkText("Laptops & Notebooks"),"Laptops & Notebooks");
        Thread.sleep(700);

    }
    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() throws InterruptedException {
        //3.1 Mouse hover on “Components” Tab and click
        mouseHoverOnElement(By.linkText("Components"));
        Thread.sleep(700);
        //3.2 call selectMenu method and pass the menu = “Show All Components”
        selectMenu("Show AllComponents");
        Thread.sleep(700);
        //3.3 Verify the text ‘Components’
        verifyText(By.xpath("//h2[contains(text(),'Components')]"),"Components");
        Thread.sleep(700);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}