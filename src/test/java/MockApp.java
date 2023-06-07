import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.net.MalformedURLException;

//public class MockApp
//{
//    public AndroidDriver androidDriver;
//    @BeforeSuite
//    public void setUpAppium() throws MalformedURLException, InterruptedException {
//        File apkFile = new File("src/test/java/resources/mock.apk");
//        UiAutomator2Options options = new UiAutomator2Options().autoGrantPermissions().setDeviceName("TestDevice").setApp(apkFile.getAbsolutePath());
//        androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
//        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//}
