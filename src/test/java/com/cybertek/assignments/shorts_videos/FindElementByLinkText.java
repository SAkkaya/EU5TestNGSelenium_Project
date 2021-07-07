package com.cybertek.assignments.shorts_videos;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FindElementByLinkText {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
       Thread.sleep(2000);
        driver.quit();

    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/");

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        System.out.println("amounts of links = " + allLinks.size());

        WebElement link = driver.findElement(By.linkText("Autocomplete"));
        link.click();
        Thread.sleep(2000);

        WebElement text = driver.findElement(By.cssSelector("div.example>h3~p"));
        String textValue= text.getText();
        System.out.println("textValue = " + textValue);
        Assert.assertEquals(textValue,"Start typing:", "verify start typing is displayed");

        //partial Text

        driver.navigate().back();
        Thread.sleep(2000);
        WebElement link2 =driver.findElement(By.partialLinkText("Drop"));
        link2.click();
        WebElement link2GetText = driver.findElement(By.cssSelector("h3"));
        System.out.println("link2GetTextValue = " + link2GetText.getText());
        Assert.assertEquals(link2GetText.getText(), "Drag and Drop", "verify Drag and Drop is displeyed");
        Thread.sleep(2000);


    }






}
