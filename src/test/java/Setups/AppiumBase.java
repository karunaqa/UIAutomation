package Setups;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AppiumBase {
     public AndroidDriver androidDriver;
     ConfigHelper cH= new ConfigHelper();
    AppiumDriverLocalService service;
    @BeforeSuite
    public void setUpAppiumTest() throws MalformedURLException, InterruptedException {
        File apkFile = new File("src/test/Resources/mock.apk");
//        String AppuimJSPath= cH.getProperty("APPIUM_MAINJS_PATH");
//        cH.setProperty("NEW_PROP","VALUE");
//        System.out.println(AppuimJSPath);
//        System.out.println(cH.getProperty("NEW_PROP"));

//        AppiumServiceBuilder builder = new AppiumServiceBuilder();
//        builder.withAppiumJS(new File("C:\\Users\\User\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")) .withIPAddress("127.0.0.1").usingPort(4723);
////        service= new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\User\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
////                .withIPAddress("127.0.0.1").usingPort(4723).build();
//        service= AppiumDriverLocalService.buildService(builder);
//        service.start();
//
//        Thread.sleep(5000);

        UiAutomator2Options options = new UiAutomator2Options()
                .autoGrantPermissions()
                .setDeviceName("Test27")
                .setApp(apkFile.getAbsolutePath());
        androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Global.setAndroidDriver(androidDriver);
    }

    @AfterSuite
    public void stopServices(){
//        service.stop();
    }
}
