package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyConfirmationMassage {

    public static void main(String[] args) throws InterruptedException {

        /*
    VerifyContactInformationTest confirmation message
        open chrome browser
        go to http://practice.cybertekschool.com/forgot_password Links to an external site.
        enter any email
        verify that email is displayed in the input box
        click on Retrieve password
        verify that confirmation message says 'Your e-mail's been sent!'
     */

        //open chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");

        // go to http://practice.cybertekschool.com/forgot_password Links to an external site
        driver.get("http://practice.cybertekschool.com/forgot_password");

        // enter any email
        WebElement emailInputBox = driver.findElement(By.name("email"));

        String expectedEmail = "mike@smith.com";

        //sendKeys()-->send keyboard action
        emailInputBox.sendKeys(expectedEmail);

        //somehow we should get text from web elements
        //two main ways to get txt from web elements
        //1.getText() --> it will work %99 and it will return string
        //2.getAttribute("value")  --> second way of getting text especially input boxes


        String actualEmail = emailInputBox.getAttribute("value"); // buraya value dersek value alir ; name dersek name i; id dersek id yi alir icinden
        System.out.println("actualEmail = " + actualEmail); //soutv

        //verify that email is displayed in the input box
        if (expectedEmail.equals(actualEmail)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        //click on Retrieve password
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        Thread.sleep(2000);
        retrievePasswordButton.click();

        Thread.sleep(2000);
        //verify that confirmation message says 'Your e-mail's been sent!'

        WebElement actualConfirmationMessage = driver.findElement(By.name("confirmation_message"));
        //System.out.println("actualConfirmationMessage = " + actualConfirmationMessage); //   [[ChromeDriver: chrome on MAC (34355276be354d737d677e117d315317)] -> name: confirmation_message]
                                                                                            //Boyle bir mesaj gelir. bu; WebElement information, yani referansi --> print edemeyiz
        System.out.println("actualConfirmationMessage = " + actualConfirmationMessage.getText()); //  o yuzden getText() kullanmaliyiz,  you will find your WebElement, then i wana see the getText of It

        //save expected message to variable
        String expectedMessage = "Your e-mail's been sent!";

        //save actual message to variable
        String actualMessage = actualConfirmationMessage.getText();

        if (expectedMessage.equals(actualMessage)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("expectedMessage = " + expectedMessage);
            System.out.println("actualMessage = " + actualMessage);
        }

        //close browser
        driver.quit();
    }

}
