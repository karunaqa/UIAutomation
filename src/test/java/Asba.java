//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Asba {
    WebDriver driver;

    public Asba() {
    }

    @BeforeClass
    public void browser() {
        System.setProperty("webDriver.chrome.driver", "/Users/Dell/Downloads/chromedriver_mac64\\ 2/chromedriver");
        driver = new ChromeDriver();
        this.driver.get("https://asba.f1soft.com.np");
        this.driver.manage().window().maximize();
    }

    @Test
    public void login() {
        int i = 0;
        String[] username = new String[]{"admin", "test"};
        String[] password = new String[]{"admin", "test"};
        this.driver.findElement(By.id("username")).sendKeys(username[i]);
        this.driver.findElement(By.id("password")).sendKeys(password[i]);
        this.driver.findElement(By.id("login")).click();
        ++i;
    }

    public void admin() throws InterruptedException {
        Thread.sleep(5000L);
        this.driver.findElement(By.id("Admin")).click();
        Thread.sleep(10000L);
    }

    @Test(
            priority = 1
    )
    public void createAdmin() throws InterruptedException {

        this.driver.findElement(By.id("createAdmin")).click();
        this.driver.findElement(By.id("firstName")).sendKeys("karuna");
        this.driver.findElement(By.id("middleName")).sendKeys(new CharSequence[]{""});
        this.driver.findElement(By.id("lastName")).sendKeys(new CharSequence[]{"Singh"});
        this.driver.findElement(By.id("userName")).sendKeys(new CharSequence[]{"karuna"});
        this.driver.findElement(By.xpath("//label/input[@value='Female']/parent::label")).click();
        this.driver.findElement(By.id("continueFirst")).click();
        this.driver.findElement(By.id("email")).sendKeys(new CharSequence[]{"karuna@gmail.com"});
        this.driver.findElement(By.id("mobileNumber")).sendKeys(new CharSequence[]{"9849305261"});
        this.driver.findElement(By.id("address")).sendKeys(new CharSequence[]{"ason"});
        this.driver.findElement(By.id("continueSecond")).click();
        this.driver.findElement(By.xpath("//label/input[@value='EMAIL']/parent::label")).click();
        this.driver.findElement(By.id("continueThird")).click();
        this.driver.findElement(By.xpath("//label/input[@value='CENTRAL']/parent::label")).click();
        this.driver.findElement(By.id("continueFourth")).click();
        this.driver.findElement(By.id("casbaUsername")).sendKeys(new CharSequence[]{"test"});
    }
}
