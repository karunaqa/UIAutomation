package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class DropDown {

    List<WebElement> dropdownItems;



    public  DropDown(WebElement dropdownElement){
        dropdownElement.click();
        dropdownItems= dropdownElement.findElements(By.xpath(".//li/span"));
    }
    public void selectByIndex(Integer index){
        dropdownItems.get(index).click();
    }
    public void selectByValue(String value){
        for(WebElement dropdownItem: dropdownItems){
            if(dropdownItem.getText().trim().equals(value))
            {
                dropdownItem.click();
                break;
            }
        }
    }
    public List<String > getAllOptions(){
        List<String> options = dropdownItems.stream().map(s->s.getText()).collect(Collectors.toList());
        return options;
    }
}
