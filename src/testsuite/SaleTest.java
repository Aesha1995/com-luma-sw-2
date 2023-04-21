package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SaleTest extends BaseTest {
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
    public void verifyTheTotalItemsDisplayedOnTheWomensJacketsPage()
    {
       driver.findElement(By.id("ui-id-8")).click();
       driver.findElement(By.xpath("//ul[@class='items']//a[@href='https://magento.softwaretestingboard.com/women/tops-women/jackets-women.html']")).click();
       String expectedMsg = "Jackets";
       WebElement actualText = driver.findElement(By.xpath("//span[@class='base']"));
       String actualMsg = actualText.getText();
       Assert.assertEquals(expectedMsg,actualMsg);
       List<WebElement> count = driver.findElements(By.xpath("//strong[@class='product name product-item-name']"));
       System.out.println("Total number of product per page is : "+count.size());
       for (WebElement total : count )
       {
           System.out.println(total.getText());
       }
       int expectedNum = 12;
       int actualNum = count.size();
       Assert.assertEquals("false",expectedNum,actualNum);
    }
}
