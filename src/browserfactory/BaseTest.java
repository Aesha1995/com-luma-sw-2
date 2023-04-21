package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    //public String baseUrl="https://demo.nopcommerce.com/";
    public WebDriver driver;

    public void openBrowser(String baseUrl)
    {
        //browser setup code
        driver = new ChromeDriver(); // set up the Chrome browser
        driver.get(baseUrl); // open the url
        driver.manage().window().maximize(); // maximize the window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); // giving the implicit wait

    }

    public void closeBrowser()
    {
        //closing the browser code
        driver.close();
    }
}
