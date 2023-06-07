import Setups.AppiumBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Mobile extends AppiumBase {
//    public AndroidDriver androidDriver;

@Test
    public void InitialSetupTest()
    {
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        androidDriver.findElement(By.xpath(" //android.widget.Button[@content-desc='Next']")).click();
        androidDriver.findElement(By.xpath("//android.view.View[@content-desc='Skip']")).click();
        androidDriver.findElement(By.xpath("//android.widget.Button[@content-desc='I already have an account. Sign in!']")).click();

        WebElement mobile = androidDriver.findElement(By.xpath("//android.widget.EditText[@hint = 'Mobile Number']"));
        mobile.click();
        mobile.sendKeys("9849305261");

//        WebElement xpath= androidDriver.findElement(By.xpath("//android.widget.ImageView[@content-desc='Unable to Login']/android.view.View/android.view.View/android.widget.ImageView"));
//        androidDriver.findElement(By.xpath("//android.widget.ImageView[@content-desc='Unable to Login']/android.view.View/android.view.View/android.widget.ImageView")).sendKeys("9849305261");
    }



    }

