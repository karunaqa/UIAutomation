package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {

       System.setProperty("webDriver.chrome.driver","/Users/Dell/Downloads/chromedriver_mac64\\ 2/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com");
        //String errorText= driver.findElement(By.cssSelector())





    }
}