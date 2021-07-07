package com.cybertek.assignments.shorts_videos;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBoxesPractice {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/checkboxes");

//        Thread.sleep(2000);
//        driver.findElement(By.cssSelector("input[name='checkbox1']")).click();
//        Thread.sleep(2000);
//        driver.findElement(By.cssSelector("input[name='checkbox2']")).click();
//        Thread.sleep(2000);


        // find all elements with tag name input
        //List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        List<WebElement> checkboxes = driver.findElements(By.tagName("input"));
        //loop through this list of elements
        for (WebElement checkbox : checkboxes) {
            Thread.sleep(2000);
            //if checkbox is not selected yet
            if(!checkbox.isSelected()){
                //select it
                checkbox.click();
            }
        }


        driver.quit();






    }


}
