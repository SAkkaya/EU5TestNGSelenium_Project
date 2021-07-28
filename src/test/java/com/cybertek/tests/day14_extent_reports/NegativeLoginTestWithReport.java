package com.cybertek.tests.day14_extent_reports;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTestWithReport extends TestBase {

    @Test
    public void wrongPasswordTest(){

        //name of the test
        extentLogger = report.createTest("Wrong Password Test");

        LoginPage loginPage = new LoginPage();

        extentLogger.info("Enter username: user1");
        loginPage.usernameInput.sendKeys("user1");

        extentLogger.info("Enter Password: somepassword ");
        loginPage.passwordInput.sendKeys("somepassword");

        extentLogger.info("click login Button");
        loginPage.loginBtn.click();

        extentLogger.info("VerifyContactInformationTest Page URL");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");

        extentLogger.pass("Wrong Password Test is Passed");  //if Assertion failed , stop my execution and it is gonna not execute this line
                                                            //Assertion specific burasi testin adini yaziyoruz
    }

    @Test
    public  void wrongUsernameTest(){
        //name of the test
        extentLogger = report.createTest("Wrong Username Test");

        LoginPage loginPage = new LoginPage();

        extentLogger.info("Enter username : someusername");
        loginPage.usernameInput.sendKeys("someusername");

        extentLogger.info("Enter password : UserUser123");
        loginPage.passwordInput.sendKeys("UserUser123");

        extentLogger.info("Click Login button");
        loginPage.loginBtn.click();

        extentLogger.info("verify page URL");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");
        extentLogger.pass("PASSED");  // Assertion specific degil; Test specific burasi  , after all tests are passed then we see the PASSED result
    }




}
