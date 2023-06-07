package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Asba {
    WebDriver driver;

    @BeforeClass
    public void browser(){
        System.setProperty("webDriver.chrome.driver", "/Users/Dell/Downloads/chromedriver_mac64\\ 2/chromedriver");

        /* most of the windows browser does not support the chrome */
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--remote-allow.origins=*");
       driver = new ChromeDriver();

        driver.get("https://asba.f1soft.com.np");
        driver.manage().window().maximize();
    }
//    public static void main(String[] args) throws InterruptedException {
//        System.setProperty("webDriver.chrome.driver", "/Users/Dell/Downloads/chromedriver_mac64\\ 2/chromedriver");
//
//        /* most of the windows browser does not support the chrome */
//        //ChromeOptions options = new ChromeOptions();
//        //options.addArguments("--remote-allow.origins=*");
//
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://asba.f1soft.com.np");
//        driver.manage().window().maximize();

        @Test
        public void login() {
            /* List of admin name */
            int i = 0;
            String[] username = {"admin","test"};

            /* List of password */
            String[] password = {"admin","test"};
            /* Login */
            driver.findElement(By.id("username")).sendKeys(username[i]);
            driver.findElement(By.id("password")).sendKeys(password[i]);
            driver.findElement(By.id("login")).click();
            i = i + 1;
        }

        /* Invalid username or password */
//      String msg = "Invalid username or password";
//       Assert.assertEquals("Invalid username or password",msg);
//       System.out.println("passed");

       public void admin() throws InterruptedException {

           /* Admin Module */
           Thread.sleep(5000);
           driver.findElement(By.id("Admin")).click();
           Thread.sleep(10000);
     }

        @Test(priority = 1)
        public void createAdmin() throws InterruptedException {
            /* Create an Admin */
            admin();
            driver.findElement(By.id("createAdmin")).click();
            driver.findElement(By.id("firstName")).sendKeys("karuna");
            driver.findElement(By.id("middleName")).sendKeys("");
            driver.findElement(By.id("lastName")).sendKeys("Singh");
            driver.findElement(By.id("userName")).sendKeys("karuna");
            driver.findElement(By.xpath("//label/input[@value='Female']/parent::label")).click();
            driver.findElement(By.id("continueFirst")).click();

            driver.findElement(By.id("email")).sendKeys("karuna@gmail.com");
            driver.findElement(By.id("mobileNumber")).sendKeys("9849305261");
            driver.findElement(By.id("address")).sendKeys("ason");
            driver.findElement(By.id("continueSecond")).click();

            driver.findElement(By.xpath("//label/input[@value='EMAIL']/parent::label")).click();
            driver.findElement(By.id("continueThird")).click();

            driver.findElement(By.xpath("//label/input[@value='CENTRAL']/parent::label")).click();
            driver.findElement(By.id("continueFourth")).click();
            driver.findElement(By.id("casbaUsername")).sendKeys("test");
        }


//        driver.quit();
    }

