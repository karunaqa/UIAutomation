import Setups.AppiumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Elements extends AppiumBase {

    public void ElementPath(WebElement path, String keys)
    {
        path.click();
        path.sendKeys(keys);
    }
}
