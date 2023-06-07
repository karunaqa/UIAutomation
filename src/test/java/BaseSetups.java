import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseSetups {
    WebDriver driver;

    @BeforeClass
    public void initialSetup()
    {
        System.setProperty("webDriver.chrome.driver", "/Users/Dell/Downloads/chromedriver_mac64\\ 2/chromedriver");
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://hub.fonepay.com/");

    }

    @AfterClass
    public void closeActivities() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
