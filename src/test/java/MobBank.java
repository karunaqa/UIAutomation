import Setups.AppiumBase;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.List;

public class MobBank extends AppiumBase{

    @Test
    public  void  laxmiBankFeedBack() throws InterruptedException {
        Thread.sleep(5000);
        androidDriver.findElement(By.id("com.laxmibank.mobilemoney.uat:id/lg_app_tac_agree_checkbox")).click();
        androidDriver.findElement(By.id("com.laxmibank.mobilemoney.uat:id/lg_app_tac_accept")).click();
        androidDriver.findElement(AppiumBy.accessibilityId("More")).click();
        androidDriver.findElements(AppiumBy.id("com.laxmibank.mobilemoney.uat:id/cvMenu")).get(3).click();
//        WebElement validationMessage= androidDriver.findElement(AppiumBy.id("com.laxmibank.mobilemoney.uat:id/textinput_error"));
//        Assert.assertTrue(validationMessage.isDisplayed());


        WebElement mobileTextBox= androidDriver.findElement(AppiumBy.xpath("//android.widget.EditText[@focused='true']"));

//        mobileTextBox.sendKeys("98137");
        enterText(mobileTextBox,"7788989");
        enterText(mobileTextBox,"");
        mobileTextBox.clear();
        WebElement validationMessage= androidDriver.findElement(AppiumBy.id("com.laxmibank.mobilemoney.uat:id/textinput_error"));
        Assert.assertTrue(validationMessage.isDisplayed());
        System.out.println(validationMessage.getText());

        enterText(mobileTextBox,"9813798508");
        androidDriver.pressKey(new KeyEvent(AndroidKey.ENTER));
        androidDriver.hideKeyboard();
        enterText(androidDriver.findElement(By.id("com.laxmibank.mobilemoney.uat:id/textinput_placeholder")) ,"Roshan Shah");
        androidDriver.pressKey(new KeyEvent(AndroidKey.ENTER));
        androidDriver.hideKeyboard();
        enterText(androidDriver.findElement(By.id("com.laxmibank.mobilemoney.uat:id/textinput_placeholder")) ,"roshanshah.011@gmail.com");
        androidDriver.pressKey(new KeyEvent(AndroidKey.ENTER));
        androidDriver.hideKeyboard();
        androidDriver.findElement(AppiumBy.className("android.widget.Spinner")).click();
        androidDriver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Banking Facility']")).click();
        androidDriver.pressKey(new KeyEvent(AndroidKey.TAB));
        List<WebElement> editTextBoxes= androidDriver.findElements(AppiumBy.xpath("//android.widget.EditText"));
        for (WebElement ele:editTextBoxes) {
            if(ele.getAttribute("long-clickable").equalsIgnoreCase("true")){
//                ele.sendKeys("description");
                enterText(ele,"description");
                break;
            }
        }
        androidDriver.pressKey(new KeyEvent(AndroidKey.ENTER));
        androidDriver.hideKeyboard();
        WebElement issueDateTextBox = getTextBoxNextToLabel("Issue Date");
        issueDateTextBox.sendKeys("2023-05-09");
        Assert.assertTrue(issueDateTextBox.getAttribute("text").equals("2023-05-09"));
        WebElement issueTimeTextBox = getTextBoxNextToLabel("Issue Date");
        issueTimeTextBox.sendKeys("04:08");
        Assert.assertTrue(issueTimeTextBox.getAttribute("text").equals("04:08"));
        Thread.sleep(5000);

        //android.widget.EditText
    }


    private WebElement getTextBoxNextToLabel(String label){
        return  androidDriver.findElement(By.xpath("//android.widget.TextView[@text='"+label+"']/following-sibling::android.widget.LinearLayout[1] //android.widget.EditText"));
    }

    private void enterText(WebElement ele,String text){
        Actions action = new Actions(androidDriver);
        action.click(ele).sendKeys(text).build().perform();
    }
}
