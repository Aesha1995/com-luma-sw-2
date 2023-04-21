package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseurl = "https://magento.softwaretestingboard.com/";
    @Before
    public void openLink()
    {
        openBrowser(baseurl);
    }
    @After
    public void closeLink()
    {
        closeBrowser();
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials()
    {
        driver.findElement(By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]")).click();
        driver.findElement(By.id("email")).sendKeys("aesha112@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("aesha112@gmail");
        driver.findElement(By.xpath("//div[@class='login-container']//button[@type='submit']")).click();
        String expectedMsg = "Welcome";
        WebElement actualText = driver.findElement(By.xpath("//div[@class='panel header']//span[text()='Welcome, Aesha Panchal!']"));
        String actualMsg = actualText.getText().substring(0,7);
        Assert.assertEquals(expectedMsg,actualMsg);
    }
    @Test
    public void verifyTheErrorMessageWithInvalidCredentials()
    {
        driver.findElement(By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]")).click();
        driver.findElement(By.id("email")).sendKeys("aesha112@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("aesha123@gmail");
        driver.findElement(By.xpath("//div[@class='login-container']//button[@type='submit']")).click();
        String expectedMsg = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
        WebElement actualText = driver.findElement(By.xpath("//div[@class='message-error error message']//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
        String actualMsg = actualText.getText();
        Assert.assertEquals("False",expectedMsg,actualMsg);
    }
    @Test
    public void userShouldLogOutSuccessfully()
    {
        driver.findElement(By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]")).click();
        driver.findElement(By.id("email")).sendKeys("aesha112@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("aesha112@gmail");
        driver.findElement(By.xpath("//div[@class='login-container']//button[@type='submit']")).click();
        String expectedMsg = "Welcome";
        WebElement actualText = driver.findElement(By.xpath("//div[@class='panel header']//span[text()='Welcome, Aesha Panchal!']"));
        String actualMsg = actualText.getText().substring(0,7);
        Assert.assertEquals(expectedMsg,actualMsg);
        driver.findElement(By.xpath("//div[@class='panel header']//button[@type='button']")).click();
        driver.findElement(By.xpath("//div[@class='panel header']//div[@class='customer-menu']//a[@href='https://magento.softwaretestingboard.com/customer/account/logout/']")).click();
        String signOutExpectedMsg = "You are signed out";
        WebElement signOutText = driver.findElement(By.xpath("//h1[@class='page-title']//span[@class='base']"));
        String signOutActualMsg = signOutText.getText();
        Assert.assertEquals("False",signOutExpectedMsg,signOutActualMsg);
    }
}
