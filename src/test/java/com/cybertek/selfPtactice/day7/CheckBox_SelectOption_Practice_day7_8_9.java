package com.cybertek.selfPtactice.day7;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class CheckBox_SelectOption_Practice_day7_8_9 {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
    }

    @AfterClass
    public void TearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void checkBox() throws InterruptedException {
      //  driver.get("http://practice.cybertekschool.com/checkboxes");
        driver.findElement(By.linkText("Checkboxes")).click();
        Thread.sleep(1000);
        WebElement checkBox2= driver.findElement(By.id("box2"));
        WebElement checkBox1 =  driver.findElement(By.cssSelector("#box1"));
        Assert.assertTrue( checkBox2.isSelected(), "verify checkBox2 is selected");
        Assert.assertFalse(checkBox1.isSelected(), "verify checkBox1 is NOT selected");

        checkBox2.click();
        checkBox1.click();
        Assert.assertTrue( checkBox1.isSelected(), "verify checkBox1 is selected");
        Assert.assertFalse(checkBox2.isSelected(), "verify checkBox2 is NOT selected");
    }

    @Test
    public void getAttribute(){

     //   driver.get("http://practice.cybertekschool.com/radio_buttons");
        driver.findElement(By.partialLinkText("Radio")).click();

        WebElement blueButton = driver.findElement(By.id("blue"));
        String nameAttribute = blueButton.getAttribute("name");
        System.out.println("nameAttribute = " + nameAttribute);
        String typeAttribute = blueButton.getAttribute("type");
        System.out.println("typeAttribute = " + typeAttribute);
        String idAttribute = blueButton.getAttribute("id");
        System.out.println("idAttribute = " + idAttribute);
        String valueAttribute = blueButton.getAttribute("value");
        System.out.println("valueAttribute = " + valueAttribute);

    }

    @Test
    public void innerOuterHTML(){

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

            System.out.println("driverCurrentUrl = " + driver.getCurrentUrl());
            WebElement button2 = driver.findElement(By.name("button2"));
            System.out.println("button2.getAttribute(\"outerHTML\") = " + button2.getAttribute("outerHTML"));
            System.out.println("button2.getAttribute(\"innerHTML\") = " + button2.getAttribute("innerHTML"));
    }


    @Test
    public void isEnabled() throws InterruptedException {
          //  driver.get("http://practice.cybertekschool.com/radio_buttons");
            driver.findElement(By.linkText("Radio Buttons")).click();
            WebElement greenButton= driver.findElement(By.cssSelector("#green"));
            boolean enabled = greenButton.isEnabled();
            Assert.assertFalse(enabled,"verify that green button is not enabled");
            Thread.sleep(2000);
            greenButton.click();
            Assert.assertFalse(greenButton.isEnabled(),"verify that green button is not enabled");

    }

    @Test
    public void dynamicElement() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        WebElement inputBox = driver.findElement(By.cssSelector("input[type='text']"));
        boolean enabled = inputBox.isEnabled();
        System.out.println("inputBox is enable = " + enabled);
        Assert.assertFalse(enabled, "verify inputBox is not enabled");

       // inputBox.sendKeys("ali");

        WebElement enableButton= driver.findElement(By.xpath("//button[@onclick='swapInput()']"));
        System.out.println("enableButton.getAttribute(\"innerHTML\") = " + enableButton.getAttribute("innerHTML"));
        enableButton.click();
        Thread.sleep(2000);
        WebElement disableButton= driver.findElement(By.xpath("//button[@onclick='swapInput()']"));
        Thread.sleep(2000);
        System.out.println("disableButton.getAttribute(\"innerHTML\") = " + disableButton.getAttribute("innerHTML"));

    }

    @Test
    public void dynamicLoading() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_loading");
        driver.findElement(By.partialLinkText("Example 1")).click();

        WebElement usernameInput= driver.findElement(By.id("username"));
        System.out.println("usernameInput.isDisplayed() = " + usernameInput.isDisplayed());
        Assert.assertFalse(usernameInput.isDisplayed(), "verify username is not displayed on the screen");

        driver.findElement(By.cssSelector("#start>button")).click();
        Thread.sleep(6000);
        System.out.println("usernameInput.isDisplayed() = " + usernameInput.isDisplayed());
        Assert.assertTrue(usernameInput.isDisplayed(), "verify username is displayed on the screen");
        usernameInput.sendKeys("MikeSmith");
        String usernameInputAttribute = usernameInput.getAttribute("value");

        Assert.assertEquals(usernameInputAttribute,"MikeSmith", "verify actual and expected output is same");

    }

    @Test
    public void ListOfElements(){

        driver.get("http://practice.cybertekschool.com/multiple_buttons");
       // ArrayList<WebElement> elementList = (ArrayList<WebElement>) driver.findElements(By.cssSelector(".btn.btn-primary")); //size () ve get() methodlari Arraylist in methodu interface ==>List
       List<WebElement> elementList = driver.findElements(By.cssSelector(".btn.btn-primary"));
        System.out.println("elementList.size() = " + elementList.size());
        System.out.println("elementList.get(0).getText() = " + elementList.get(0).getText());
        Assert.assertTrue(elementList.size()==6, "verify element size ==6");

        for (WebElement button:elementList) {
            System.out.println("button.getText() = " + button.getText());
            Assert.assertTrue(button.isDisplayed(), "verify buttons are displayed");
        }
       //click second button
         elementList.get(1).click();
    }

    @Test
    public void unableToLocate(){
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        for (WebElement button:buttons) {
            Assert.assertTrue(buttons.size()==6);
        }
        List<WebElement> nonExistingTagElement = driver.findElements(By.tagName("naja"));
        for (WebElement button:nonExistingTagElement) {
            Assert.assertTrue(buttons.size()!=6);
        }

    }

    @Test
    public void dropDown(){
        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement dropDownElement = driver.findElement(By.id("dropdownMenuLink"));

        dropDownElement.click();

        List<WebElement> elements = driver.findElements(By.className("dropdown-item"));
        System.out.println("elements.size() = " + elements.size());

        for (WebElement element: elements) {
            System.out.println("element.getText() = " + element.getText());
        }
        elements.get(2).click();

    }

    @Test
    public void selectDropDown(){

        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement state = driver.findElement(By.id("state"));

        Select stateDropDown = new Select(state);
        //verify that first selection is Select a state
        Assert.assertEquals(stateDropDown.getFirstSelectedOption().getText(), "Select a State");

        stateDropDown.selectByVisibleText("Kentucky");
        String expectedOption = "Kentucky";
        String actualOption = stateDropDown.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedOption,actualOption, "verify selected selection");

        stateDropDown.selectByIndex(51);
        expectedOption="Wyoming";
        actualOption=stateDropDown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption,"verify selected option");

        stateDropDown.selectByValue("WA");
        expectedOption="Washington";
        actualOption=stateDropDown.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedOption,actualOption,"verify selected option");


    }


    @Test
    public void multipleWindow(){
        driver.get("http://practice.cybertekschool.com/windows");
        System.out.println("Title before new window = " + driver.getTitle());

        String windowHandle = driver.getWindowHandle();

        driver.findElement(By.linkText("Click Here")).click();

        System.out.println("title after new window without switch = " + driver.getTitle());

        //System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());
                             //driver.getWindowHandle() = CDwindow-F0016853EC0CD13D11F2F169F3FFC173

        System.out.println(driver.getWindowHandle());

        String currentWindowHandle = driver.getWindowHandle();

        Set<String> windowHandles = driver.getWindowHandles();

        for (String handle : windowHandles) {
//            System.out.println(driver.getWindowHandle());
//            driver.switchTo().window(handle);
            if(!handle.equals(currentWindowHandle)){
                driver.switchTo().window(handle);
            }
        }

        System.out.println("Title after switch new window:"+driver.getTitle());

    }








}
