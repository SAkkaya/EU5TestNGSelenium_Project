package com.cybertek.assignments.homework_day10;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCase7UploadFIle {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
       // driver.quit();
    }

    @Test
    public void test7_01(){

//        Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");
//        Step 2. And click on “File Upload".
        driver.findElement(By.linkText("File Upload")).click();

//        Step 3. Upload any file with .txt extension from your
//        computer.

            //locating choose file button
        WebElement chooseFile = driver.findElement(By.id("file-upload"));

            //sending file with sendKeys method
        chooseFile.sendKeys("/Users/sadik/Desktop/txt file to upload selenium.txt");

//        Step 4. Click “Upload” button.

        driver.findElement(By.id("file-submit")).click();

//        Step 5. Verify that subject is: “File Uploaded!”

       String actualSubject = driver.findElement(By.cssSelector("div h3")).getText();
       String expectedSubject= "File Uploaded!";

        Assert.assertEquals(actualSubject,expectedSubject, "Verify that subject is: “File Uploaded!");

//        Step 6. Verify that uploaded file name is displayed.

        boolean isFileDislayed = driver.findElement(By.id("uploaded-files")).isDisplayed();

        Assert.assertTrue(isFileDislayed, "Verify that uploaded file name is displayed");

/*      Note: use element.sendKeys(“/file/path”) with
        specifying path to the file for uploading. Run this
        method against “Choose File” button. */
    }


    @Test
    public void test7_02(){

//        Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");
//        Step 2. And click on “File Upload".
        driver.findElement(By.linkText("File Upload")).click();

//        Step 3. Upload any file with .txt extension from your
//        computer.

        //locating choose file button
        WebElement chooseFile = driver.findElement(By.id("file-upload"));

        //sending file with sendKeys method
        String projectPath = System.getProperty("user.dir");
        System.out.println("System.getProperty(\"user.dir\") = " + System.getProperty("user.dir")); //       //==local uzantisi==>     /Users/sadik/EU5TestNGSelenium

        String filePath = "src/test/resources/secondfile.txt";           //resources dolderin daki secondfile.txt uzerine gel =>( right click() + OPTION   ==> / copy path/ path from content root )
        String fullPath= projectPath + "/" + filePath;

        chooseFile.sendKeys(fullPath);

//        Step 4. Click “Upload” button.

        driver.findElement(By.id("file-submit")).click();

//        Step 5. Verify that subject is: “File Uploaded!”

        String actualSubject = driver.findElement(By.cssSelector("div h3")).getText();
        String expectedSubject= "File Uploaded!";

        Assert.assertEquals(actualSubject,expectedSubject, "Verify that subject is: “File Uploaded!");

//        Step 6. Verify that uploaded file name is displayed.

        boolean isFileDislayed = driver.findElement(By.id("uploaded-files")).isDisplayed();

        Assert.assertTrue(isFileDislayed, "Verify that uploaded file name is displayed");

/*      Note: use element.sendKeys(“/file/path”) with
        specifying path to the file for uploading. Run this
        method against “Choose File” button. */
    }

}