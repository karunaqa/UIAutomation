import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.io.File;

import org.openqa.selenium.android.library.AndroidWebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class androidTest {

    @Test
    public static void main (String[] args) throws MalformedURLException {
        //create capabilities
//        File appDir = new File("src");
//        File app = new File (appDir, "Flutter.apk ");
//        DesiredCapabilities cap = new DesiredCapabilities();
//        cap.setCapability("deviceName", "TestDevice");
//         cap.setCapability("platformName", "Android");
//        cap.setCapability("automationName", "uiautomator2");


        //run appium server automatically
//        AppiumServiceBuilder service = new AppiumServiceBuilder().withAppiumJS();
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("TestDevice");
        options.setApp( System.getProperty("user.dir")+"\\src\\test\\java\\flutter.apk");


        //create object for AndroidDriver
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.quit();






    }
}
