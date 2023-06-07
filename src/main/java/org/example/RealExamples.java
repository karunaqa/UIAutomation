//package org.example;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.testng.annotations.*;
//
//import java.time.Duration;
//
//public class RealExamples {
//    private WebDriver driver;
//
//    @BeforeClass
//    public void setupMethod() {
//        System.setProperty("webDriver.chrome.driver", "/Users/Dell/Downloads/chromedriver_mac64\\ 2/chromedriver");
//
//        /* most of the windows browser does not support the chrome */
//        //ChromeOptions options = new ChromeOptions();
//        //options.addArguments("--remote-allow.origins=*");
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//    }
//    @BeforeMethod
//    public void beforeMethod()
//    {
//       System.out.println("This is before method");
//    }
//    @Test
//    public void searchFlights()
//    {
//        driver.get("https://hub.fonepay.com/");
//        driver.findElement(By.xpath("//a[text()='Domestic Flights']")).click();
//       WebElement arrivalDatePicker =  driver.findElement(By.xpath("//div[@class='select select_datepicker']/input[@formcontrolname='arrivalDate']"));
//       if(arrivalDatePicker.isEnabled())
//       {
//
//        driver.findElement(By.xpath("//span[text()='One Way']")).click();
//        }
//       Thread.sleep(2000);
//        driver.findElement(By.xpath("//p-dropdown[@formcontrolname='sectorform]/div[contains(@class,'ui-dropdown')]/label")).click();

//        Actions a = new Actions(driver);
//        a.moveToElement();
//        driver.findElement(By.xpath(""))

//    @Test(priority = 1)
//    public void secondTest(){
//        driver.get("https://www.google.com/");
//    }
//    @AfterMethod
//    public void afterMethod()
//    {
//        System.out.println("This is called after method");
//    }

//    @AfterClass
//    public void afterclass()
//    {
//        System.out.println("This is called after class");
//    }
//}