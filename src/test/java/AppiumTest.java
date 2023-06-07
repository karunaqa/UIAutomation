import Setups.AppiumBase;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AppiumTest extends AppiumBase {

//    AndroidDriver androidDriver;
//    AppiumServiceBuilder service;
//
//    @BeforeSuite
//    public void setUpAppiumTest() throws MalformedURLException {
//        File apkFile = new File("/Users/Dell/IdeaProjects/selenium framework/src/test/Resources/Demoapp.apk");
////        service = new AppiumServiceBuilder().withAppiumJS(new File("usr/local/lib/node_modules/appium")).withIPAddress("127.0.0.1").usingPort(4723).build();
////        service.start();
//        UiAutomator2Options options = new UiAutomator2Options().autoGrantPermissions().setDeviceName("TestDevice").setApp(apkFile.getAbsolutePath());
//        androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
//        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//    }

    @Test
    public void newTest() throws InterruptedException {
        androidDriver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Text\")")).click();
        androidDriver.findElement(AppiumBy.androidUIAutomator ("new UiSelector().text(\"Linkify\")")).click();
        String text =androidDriver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.hmh.api:id/text2\")")).getText();
        System.out.println(text);
    }

    @Test
    public void test2(){
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
        androidDriver.findElement(By.xpath("(//android.widget.TextView[@text='Buttons'])[1]")).click();
        androidDriver.findElement(By.id("com.example.android.apis:id/button_small")).click();

    }
//    @AfterSuite
//    public void stopServices()
//    {
//        service.stop();
//    }


//    @Test
//    public void longPressTest() throws InterruptedException {
//        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
//        androidDriver.findElement(By.xpath("(//android.widget.TextView[@text='Expandable Lists'])")).click();
//        androidDriver.findElement(By.xpath("(//android.widget.TextView[@text='1. Custom Adapter'])")).click();
//        WebElement popeleNames= androidDriver.findElement(By.xpath("(//android.widget.TextView[@text='People Names'])"));
//
//        longPress(popeleNames,1000);
//
//        Assert.assertTrue(androidDriver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Sample menu']")).isDisplayed());
//    }
//
//    @Test
//    public void scrollTest(){
//        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
////       scrollTillText("ScrollBars");
//        scrollTillEnd("down");
//    }


}

//android.widget.TextView[@resource-id='android:id/text1']
