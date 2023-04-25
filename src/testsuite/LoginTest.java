package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }
    @After
    public void tearDown() {
        closeBroser();
    }
    @Test
    public void verifyuserSholdLoginSuccessfullyWithValidCredentials() {
        //Find username Field and pass the value
        sendTextToElement(By.id("user-name"), "“standard_user”");
        //find Password Field and pass the value
        sendTextToElement(By.id("password"), "“secret_sauce”");
        //Find Login button and click on it
        clickOnElement(By.xpath("//input[@id='login-button']"));
        //Verify the text 'Product'
        String expectedText = "Products";
        String actualMessage = getTextFromElement(By.xpath("//span[contains(text(),'Products')]"));
        Assert.assertEquals("Login failed", expectedText, actualMessage);
    }
        @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
            sendTextToElement(By.id("user-name"), "standard_user");
            sendTextToElement(By.id("password"), "secret_sauce");
            clickOnElement(By.xpath("//input[@id='login-button']"));
            // verify Six items are displayed on page
            List<WebElement> products = driver.findElements(By.xpath("//div[@class='inventory_item_img']"));
            int expectedNoOfItems = 6;
            int actualNoOfItems = products.size();
            Assert.assertEquals("Six products are not displayed" , expectedNoOfItems,actualNoOfItems);
            
        }

    }

