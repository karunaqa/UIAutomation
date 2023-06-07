package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class Date {
    private WebDriver driver;

    @BeforeClass
    public void setupMethod() {
//        System.out.println("This is called before Class");
        System.setProperty("webDriver.chrome.driver", "/Users/Dell/Downloads/chromedriver_mac64\\ 2/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

//    @BeforeMethod()
//    public void beforeMethod() {
//        System.out.println("This is called before method");
//    }


    @Test()
    public void searchFlights() throws InterruptedException {
        String from = "JANAKPUR";
        String to = "KATHMANDU";

        SoftAssert sA = new SoftAssert();


        driver.get("https://hub.fonepay.com/");
        System.out.println("This is searchFlights  test case");
        driver.findElement(By.xpath("//a[text()='Domestic Flights']")).click();
        WebElement arrivalDatePicker = driver.findElement(By.xpath("//div[@class='select select__datepicker']/input[@formcontrolname='arrivalDate']"));
        if (arrivalDatePicker.isEnabled()) {
            driver.findElement(By.xpath("//span[text()='One Way']")).click();
        }
        Thread.sleep(2000);
        WebElement dropDown = driver.findElement(By.xpath("//p-dropdown[@formcontrolname='sectorFrom']/div[contains(@class,'ui-dropdown')]/label"));
        dropDown.click();

//        Actions a = new Actions(driver);
//        a.moveToElement(dropdown)
        driver.findElement(By.xpath("//p-dropdown[@formcontrolname='sectorFrom'] //input[@placeholder='Search Location']")).sendKeys("JAN");
        List<WebElement> allDropDownListItems = driver.findElements(By.xpath("//li[contains(@class,'ui-dropdown-item')]"));
        boolean didFound = clickIFItemPresent(allDropDownListItems, from);
        sA.assertTrue(didFound, "From location was not found in dropdown list.");


        WebElement dropDownTo = driver.findElement(By.xpath("//p-dropdown[@formcontrolname='sectorTo']/div[contains(@class,'ui-dropdown')]/label"));
        dropDownTo.click();
        driver.findElement(By.xpath("//p-dropdown[@formcontrolname='sectorTo'] //input[@placeholder='Search Location']")).sendKeys("KAT");
        allDropDownListItems = driver.findElements(By.xpath("//li[contains(@class,'ui-dropdown-item')]"));
        didFound = clickIFItemPresent(allDropDownListItems, to);
        sA.assertTrue(didFound, "To location was not found in dropdown list.");


        WebElement datePicker = driver.findElement(By.xpath("//div[@class='select select__datepicker']/input[@formcontrolname='departureDate']"));
        selectDateFromDatePicker(datePicker, "24", "May", "2023", sA);
        Thread.sleep(3000);

        sA.assertAll();
    }

//    @Test(priority = 1)
//    public void anotherTest(){
//        System.out.println("This is anotherTest  test case");
//        driver.get("https://google.com/");
//    }

//    @AfterMethod
//    public void exampleForAfterMethod() {
//        System.out.println("This is called after method");
//    }

//    @AfterClass
//    public void exampleForAfterClass() throws InterruptedException {
//        System.out.println("This is called after class");
//        Thread.sleep(3000);
//        driver.quit();
//    }

    public boolean clickIFItemPresent(List<WebElement> listItems, String searchText) {
        boolean found = false;
        for (WebElement ele : listItems) {
            if (ele.getText().trim().equals(searchText)) {
                found = true;
                ele.click();
                break;
            }
        }
        return found;
    }

    public void selectDateFromDatePicker(WebElement datePicker, String day, String month, String year, SoftAssert sA) {
        datePicker.click();
        driver.findElement(By.xpath("//div[@class='bs-datepicker-head'] //button[@class='next']/preceding-sibling::button[1]")).click();
        boolean found = false;
        boolean goBack = false;
        do {
            List<WebElement> elementsForYear = driver.findElements(By.cssSelector("td[role='gridcell'] span"));

            List<String> listOfYeas = elementsForYear.stream().map(ele -> ele.getText().trim()).collect(Collectors.toList());
            for (String yr : listOfYeas) {
               // System.out.println(yr);
            }
            if (listOfYeas.contains(year)) {
                elementsForYear.get(listOfYeas.indexOf(year)).click();
                found = true;
            } else if (parseInt(listOfYeas.get(0)) > parseInt(year))
                driver.findElement(By.xpath("//div[@class='bs-datepicker-head'] //button[@class='previous']")).click();
            else
                driver.findElement(By.xpath("//div[@class='bs-datepicker-head'] //button[@class='next']")).click();

//            if(parseInt(elementsForYear.get(0).getText()) > parseInt(year))
//                goBack=true;
//            else if (parseInt(elementsForYear.get(elementsForYear.size()-1).getText()) < parseInt(year)) {
//                goBack=false;
//            }
//            else{
//                //the year is displayed, find and click
//                for (WebElement ele : elementsForYear) {
//                    if (ele.getText().trim().equals(year)) {
//                        found = true;
//                        ele.click();
//                        break;
//                    }
//                }
//            }
//            if(!found){
//                if(goBack){
//                    //click back arrow
//                    driver.findElement(By.xpath("//div[@class='bs-datepicker-head'] //button[@class='previous']")).click();
//                }
//                else{
//                    //click next arrow
//                    driver.findElement(By.xpath("//div[@class='bs-datepicker-head'] //button[@class='next']")).click();
//                }
//            }
        } while (!found);

        driver.findElement(By.xpath("//td[@role='gridcell']/span[text()='" + month + "']")).click();
        List<WebElement> allDays = driver.findElements(By.xpath("//td[@role='gridcell']/span"));

        List<WebElement> filterdedDays = allDays.stream().filter(dayElement -> !dayElement.getAttribute("class").contains("is-other-month")).collect(Collectors.toList());
        filterdedDays.stream().forEach(d -> System.out.println(d.getText()));

        for (WebElement ele : filterdedDays) {
            if (ele.getText().equals(day)) {
                ele.click();
                break;
            }
        }
        sA.assertEquals(driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-airline-search/div/div[2]/div[3]/form/div/div[1]/div[3]/div[1]/div/input")).getAttribute("value"), "2023/05/24");

//        Select objSelect = new Select(driver.findElement(By.xpath("//select[@class='form-control ng-pristine ng-valid ng-touched']")));
        Select objSelect = new Select(driver.findElement(By.xpath("//select[@formcontrolname='noOfAdult']")));
        objSelect.selectByIndex(4);


        Select child = new Select(driver.findElement(By.xpath("//select[@formcontrolname='noOfChild']")));
        child.selectByIndex(2);
        driver.findElement(By.xpath("//div//button[@name='button']")).click();

        /* Global wait */
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000)); /* Selenium feature */
//
//        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15)); /* Explicit second for certain place*/
//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".ui-column-title")));

        sA.assertAll();

        WebElement table = driver.findElement(By.xpath("//table"));
        dataTable table1 = new dataTable(table);
        table1.tableheader(table);
//        table1.faredata(table,"FARE");
//        table1.descend();
//        table1.firstdata();
//        table1.lastdata();
//        table1.firstrow();
//        table1.lastrow();
//        table1.firstrowdata();
        table1.lastrowdata();

//        /*Table List */
//        int indexofFare =0;
//        //Identify rows of table
//        List<WebElement> rowheader = driver.findElements(By.xpath("(//table //thead //tr //th)"));
//        for(int i=0; i<rowheader.size(); i++)
//        {
//            WebElement rows = rowheader.get(i);
//            String rowheading = rows.getText().trim();
//            System.out.println(rowheading);
//            if(rowheading.equals("FARE"))
//            {
//              indexofFare = i+ 1;
////                System.out.println(indexofFare);
//            }
//
//        }
//
//        List<WebElement> columnfare = driver.findElements(By.xpath("//table //tbody //tr //td["+indexofFare+"]/child::span/div[1]"));
//        for(int i=0; i<columnfare.size(); i++) {
//            WebElement cols = columnfare.get(i);
//            String column = cols.getText().trim();
//            System.out.println(column);
//        }
//    }
//    }
    }
}



