package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://magento.softwaretestingboard.com/";
    @Before
    public void openLink()
    {
        openBrowser(baseUrl);
    }
    @After
    public void closeLink()
    {
        closeBrowser();
    }
    @Test
    public void verifyThatSignInPageDisplay()
    {
        driver.findElement(By.xpath("//div[@class= 'panel header']//a[@href='https://magento.softwaretestingboard.com/customer/account/create/']")).click();
        String expectedMsg = "Create New Customer Account";
        WebElement actualText = driver.findElement(By.xpath("//span[@data-ui-id='page-title-wrapper']"));
        String actualMsg = actualText.getText();
        Assert.assertEquals(expectedMsg,actualMsg);
    }
    @Test
    public void userShouldRegisterAccountSuccessfully()
    {
        driver.findElement(By.xpath("//div[@class= 'panel header']//a[@href='https://magento.softwaretestingboard.com/customer/account/create/']")).click();
        driver.findElement(By.id("firstname")).sendKeys("Aesha");
        driver.findElement(By.id("lastname")).sendKeys("Panchal");
        driver.findElement(By.id("is_subscribed")).click();
        driver.findElement(By.id("email_address")).sendKeys("aesha112@gmail.com");
        driver.findElement(By.id("password")).sendKeys("aesha112@gmail");
        driver.findElement(By.id("password-confirmation")).sendKeys("aesha112@gmail");
        driver.findElement(By.xpath("//button[@title = 'Create an Account']")).click();
        String expectedMsg = "Thank you for registering with Main Website Store.";
        WebElement actualText = driver.findElement(By.xpath("//div[@class='message-success success message']//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
        String actualMsg = actualText.getText();
        Assert.assertEquals(expectedMsg,actualMsg);
        driver.findElement(By.xpath("//div[@class='panel header']//span[@class ='customer-name']")).click();
        driver.findElement( By.xpath("//div[@class='panel wrapper']//div[@class='customer-menu']//a[@href='https://magento.softwaretestingboard.com/customer/account/logout/']")).click();
        String signOutExpectedMsg = "You are signed out";
        WebElement signOutActualText = driver.findElement(By.xpath("//span[@class='base']"));
        String signOutActualMsg = signOutActualText.getText();
        Assert.assertEquals(signOutExpectedMsg,signOutActualMsg);
    }
}
