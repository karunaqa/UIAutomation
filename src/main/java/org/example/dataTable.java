package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class dataTable {
    List<WebElement> rowheader;
    List<WebElement> columnfare;
    List<WebElement> rowdata;
    int indexofFare = 0;

    public dataTable(WebElement table) {

        rowheader = table.findElements(By.xpath("(//table //thead //tr //th)"));
        rowdata = table.findElements(By.xpath("(//table //tbody //tr )"));

    }

    public void tableheader(WebElement table) {
        /*Table List */

//        Identify rows of table

//        for (int i = 0; i < rowheader.size(); i++) {
//            WebElement rows = rowheader.get(i);
//            String rowheading = rows.getText().trim();
//            System.out.println(rowheading);
//            if (rowheading.equals("FARE")) {
//                indexofFare = i + 1;
//                System.out.println(indexofFare);
//            }
//
//        }
    }

//        List<String> col = rowheader.stream().map(header -> header.getText().trim()).collect(Collectors.toList());
//        List<WebElement> headername = table.findElements(By.xpath(String.format("//table //tbody //tr //td[%s]", col.indexOf("FARE") + 1)));
//            System.out.println(headername);
//               for (WebElement colname : headername) {
//            System.out.println(colname.getText());
//      }


//    public void faredata(WebElement table, String head) {
//        List<String> col = rowheader.stream().map(header -> header.getText().trim()).collect(Collectors.toList());
//        //System.out.println(col);
////        List<WebElement> headername = table.findElements(By.xpath(String.format("//table //tbody //tr //td[%s]/child::span/div[1]", col.indexOf(head) + 1)));
//        columnfare = table.findElements(By.xpath(String.format("//table //tbody //tr //td[%s]/child::span/div[1]", col.indexOf("FARE") + 1)));
//        for (int i = 0; i < columnfare.size(); i++) {
//            WebElement cols = columnfare.get(i);
//            String column = cols.getText().trim();
//            System.out.println(column);
//
//        }
//    }


//    public void sorted() {
//        List<String> allfare = columnfare.stream().map(item -> item.getText()).sorted().collect(Collectors.toList());
//        allfare.forEach(System.out::println);
//
//    }
//
//    public void descend()
//    {
//        List<String> des = columnfare.stream().map(item -> item.getText()).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
//        des.forEach(System.out::println);
//    }

//    public void firstdata()
//    {
//        List<String> firstdata = columnfare.stream().map(item -> item.getText()).collect(Collectors.toList());
//        System.out.println("first fare value " + firstdata.stream().findFirst().get());
//    }

    /* last column data */
//    public void lastdata()
//    {
//        List<String> lastdata = columnfare.stream().map(item -> item.getText()).collect(Collectors.toList());
//        System.out.println("last value " + lastdata.stream().reduce((first,last)-> last ).get());
//    }
//  /* first row */
//    public void firstrow()
//    {
//        List<String> firstrow = rowheader.stream().map(item -> item.getText()).collect(Collectors.toList());
//        System.out.println("first row " + firstrow.stream().findFirst().get());
//    }

    /* first row data */
//    public void firstrowdata()
//    {
//        List<String> rowsdata = rowdata.stream().map(header -> header.getText().trim()).collect(Collectors.toList());
////        System.out.println(rowsdata);
//
////       List<String> firstrowdata = rowdata.stream().map(item -> item.getText()).collect(Collectors.toList());
//        System.out.println("first row data " + rowsdata.stream().findFirst().get());
//    }


    public void lastrowdata()
    {
        List<String> lastrowdata = rowdata.stream().map(item -> item.getText()).collect(Collectors.toList());
//        System.out.println(lastrowdata);
        System.out.println("first row data " + lastrowdata.stream().reduce((first,last)-> last ).get());
    }
}



