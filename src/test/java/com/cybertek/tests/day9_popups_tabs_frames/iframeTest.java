package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class iframeTest {     //if there are multiple HTML s

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
         driver= WebDriverFactory.getDriver("chrome");
        // driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
       driver.get("http://practice.cybertekschool.com/iframe");

       // how to switch frames
       // 1. switch using by name or ID attribute of iframe
       driver.switchTo().frame("mce_0_ifr");

       //clear before sendkeys
        driver.findElement(By.cssSelector("#tinymce")).clear();
        Thread.sleep(1000);
       driver.findElement(By.cssSelector("#tinymce")).sendKeys("Mike Smith");

        //goes back to first frame (main html)
        //goes back to first name, useful when we have switched multiple frames
        driver.switchTo().defaultContent();

        //2.switching with INDEX
        driver.switchTo().frame(0);
        Thread.sleep(1000);

        //clear before sendkeys
        driver.findElement(By.cssSelector("#tinymce")).clear();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("Mike Smith WITH INDEX");

        //second way to switch parent
        driver.switchTo().parentFrame(); // it goes to only one parent up not all the way back to,
                                        //grand parent like driver.switchTo().defaultContent();

        //3.way USING WEBELEMENT
        //locating iframe with any valid locator

        WebElement iframeElement = driver.findElement(By.tagName("iframe"));

        driver.switchTo().frame(iframeElement);

        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("Mike Smith WITH WEBELEMENT");
    }

    //html
            //top
                 //left
                 //middle
                     //firstframe
                             //secondframe
                 //right
            //bottom


        /*
        We can switch one at a time, cannot switch to grandchild directly.
·       We cannot switch to siblings.
·       We can only switch from parent to child, or from child to parent.
         */


    @Test
    public void test2() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/nested_frames");

        //switching to frame top
        Thread.sleep(3000);
        driver.switchTo().frame("frame-top");

        //top has 3 frame under left , middle, and right
        // switch to frame middle
        driver.switchTo().frame("frame-middle");
        System.out.println( driver.findElement(By.id("content")).getText());



        //middle dan right a direk gecemeyiz (siblings arasi) once parent a gidip ordan childa gideriz
        // goes back to top frame
        driver.switchTo().parentFrame();

        //switching right with index
        driver.switchTo().frame(2);

        System.out.println(driver.findElement(By.tagName("body")).getText());

        //go to main htm to switch bottom
        driver.switchTo().defaultContent();

        driver.switchTo().frame(1);
        System.out.println(driver.findElement(By.tagName("body")).getText());

    }




}
