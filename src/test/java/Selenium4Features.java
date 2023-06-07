import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Selenium4Features extends BaseSetups{

    @Test
    public void relativeLocatorExample()
    {
        driver.findElement(By.xpath("//a[text()='Domestic Flights']")).click();
        WebElement selectFrom = driver.findElement(By.xpath("//p-dropdown[@formcontrolname='sectorFrom']"));
        WebElement label = driver.findElement(with(By.tagName("label")).above(selectFrom));
        System.out.println(label.getText());

    }

    @Test
    public void switchWindows()
    {
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.google.com");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.linkend.com");
        String parent = driver.getWindowHandle(); /* current window */
        String title = "Fonepay Merchant Hub";
        Set<String> allWindows = driver.getWindowHandles();

        Iterator iterator = allWindows.iterator();
        while (iterator.hasNext())
        {
            String nextWindow = (String) iterator.next();
            driver.switchTo().window(nextWindow);
            if (driver.getTitle().equals(title)){
                System.out.println(driver.getCurrentUrl());
                break;
            }
        }

        driver.switchTo().window(parent);
        System.out.println(parent);
    }

    @Test
    public void sizeExample() throws IOException {
        WebElement searchbox = driver.findElement(By.cssSelector("//div[class='form-group bc-form-group' ]"));
        Dimension dim = searchbox.getSize();
        System.out.println(dim.getHeight()+ ":" + dim.getWidth());
        File SrFile = searchbox.getScreenshotAs(OutputType.FILE);
        File dest = new File(System.getProperty("/Users/Dell/Downloads/Screenshot"));
        FileUtils.copyFile(SrFile,dest);

    }

}
