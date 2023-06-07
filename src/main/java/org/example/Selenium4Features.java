import org.openqa.selenium.*;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Selenium4Features extends BaseSetups{


    @Test
    public void relativeLocatorExample(){
        driver.findElement(By.xpath("//a[text()='Domestic Flights']")).click();
        WebElement selectFrom = driver.findElement(By.xpath("//p-dropdown[@formcontrolname='sectorFrom']"));
        WebElement label = driver.findElement(with(By.tagName("label")).below(selectFrom));
        System.out.println(label.getText());
    }

    @Test
    public  void switchWindows(){
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://saucelabs.com/resources/blog/selenium-4-relative-locators");
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.cricbuzz.com/cricket-match/live-scores");
       String parent = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        Iterator iterator= allWindows.iterator();
        while(iterator.hasNext()) {
            String nextWindow = (String) iterator.next();
            driver.switchTo().window(nextWindow);
            if(driver.getTitle().equals("title")){
                break;
            }
        }

    }

    @Test
    public  void sizeExample() throws IOException {
        WebElement searchBox = driver.findElement(By.cssSelector("div[class='form-group bc-form-group']"));
        Dimension dim = searchBox.getSize();
        System.out.println(dim.getHeight()+ ": " +dim.getWidth());
        File SrcFile= searchBox.getScreenshotAs(OutputType.FILE);
//        File DestFile=new File("Downloads\\newFile.png");
        File dest = new File(System.getProperty("user.dir") +    "/screenshots/elementLogo.png");
//Copy file at destination
        FileUtils.copyFile(SrcFile, dest);
    }


}
