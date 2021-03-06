package com.cybertek.tests.day10_file_upload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class FileUploadTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/upload");

        //locating choose file button
        WebElement chooseFile = driver.findElement(By.name("file"));
        //sending file with sendKeys method
        chooseFile.sendKeys("/Users/sadik/Desktop/file.txt");
        //clicking upload button
        driver.findElement(By.id("file-submit")).click();

        //getting the file name from browser
        String actualFileName = driver.findElement(By.id("uploaded-files")).getText();
        //verify file name is upload txt file
        Assert.assertEquals(actualFileName,"file.txt");

    }

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/upload");

        //locating choose file button
        WebElement chooseFile = driver.findElement(By.name("file"));
        //sending file with sendKeys method
        String projectPath = System.getProperty("user.dir");
        String filePath = "src/test/resources/textfile.txt";  //Resources altinda textfile.txt ye gel sag click copy path
        String fullPath= projectPath + "/" + filePath;
        //chooseFile.sendKeys("/Users/sadik/Desktop/file.txt");  //Bu desktop daki file idi bunun yerine dinamik yaptik asagida
        chooseFile.sendKeys(fullPath);

        //clicking upload button
        driver.findElement(By.id("file-submit")).click();

        //getting the file name from browser
        String actualFileName = driver.findElement(By.id("uploaded-files")).getText();
        //verify file name is upload textfile.txt
        Assert.assertEquals(actualFileName,"textfile.txt");

    }
    // textfile.txt nin local uzantisi  ==> ( right click()/ copy path/ absolute path )
//    /Users/sadik/EU5TestNGSelenium/src/test/resources/textfile.txt

    @Ignore
    @Test
    public void test3() {
        System.out.println(System.getProperty("os.name"));  //Mac OS X
    }





}
