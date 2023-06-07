package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import javax.swing.*;

public class Locator {
    public static void main(String[] args) {
        System.setProperty("webDriver.chrome.driver", "/Users/Dell/Downloads/chromedriver_mac64\\ 2/chromedriver");

        /* most of the windows browser does not support the chrome */
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--remote-allow.origins=*");

        WebDriver driver = new ChromeDriver();
        driver.get("https://esewa.com.np/#/home");
//        try {
//            System.out.println(driver.switchTo().alert().getText());
//            driver.switchTo().alert().accept();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
        /* Array to Arraylist */
        String[] searchStrings = {"100 Ma 100 Offer", "6- Agrawal Securities", "MSecurity"};
        List<String> list = Arrays.asList(searchStrings);

        List<WebElement> allElements = driver.findElements(By.xpath("//div[@class='owl-item active']"));
        int count = 0;
        for (int i = 0; i < allElements.size(); i++) {
            WebElement ele = allElements.get(1);
            String text = ele.getText();


            //if (text.contains("100 Ma 100 Offer"))
            if (list.contains(text)) {
                System.out.println(i + "-position");
                System.out.println(text);
                //Assert.assertEquals(i+1,2);
                //driver.findElements(By.xpath("//div[@class='owl-item active']//button[contains(text(),'View Details')]")).get(i).click();
                //ele.findElements(By.xpath("//button[contains(text(),'View Details')]")).get(i).click();
                //ele.findElement(By.xpath("//*[@id=\"showCaseTemplate\"]/div/div/div/div/section/div[1]/div/data-owl-carousel/div[1]/div/div[2]/figure/button")).click();
                //ele.findElement(By.xpath("./figure/button")).click();
                driver.findElement(By.xpath("//a[@class='pull-right']")).click();
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Actions action = new Actions(driver);
                action.click();
                action.moveToElement(driver.findElement(By.xpath("//a[@class='pull-right']"))).click().build().perform();

                count += 1;


//                List<WebElement> childElements= ele.findElements(By.xpath("./child::*"));
//                for (i=0; i<childElements.size(); i++)
//                {
//                    String childText = childElements.get(i).getText();
//                    System.out.println(childText);
//                    String attributes = childElements.get(i).getAttribute("class");
//                    System.out.println(attributes);
//                    Assert.assertTrue(attributes.contains("ng-scope"));
//                }
                //break;
                //  }
                System.out.println(i);
                if (count == list.size()) {
                    break;
                }

            }

//driver.quit();

        }
    }
}

