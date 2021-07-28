package com.cybertek.assignments.hw_day15_contactInfo;

import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyContactInformationTest extends TestBase {

    /**
     * open the chrome
     * go to qa1.vytrack
     * login as a sales manager
     * navigate to customers ->contacts
     * click on email mbrackstone9@example.com
     * verify that full name is Mariam Brackstone
     * verify that email is mbrackstone9@example.com
     * verify that phone number is +18982323434
     */


    @Test
    public void name(){
//     open the chrome
//     go to qa1.vytrack
//     login as a sales manager

        //name of the test
        extentLogger = report.createTest("Customer Contact Details Test");

        LoginPage loginPage = new LoginPage();

        extentLogger.info("login as SalesManager");
        loginPage.loginAsSalesManager();

        extentLogger.info("navigate to customers' contacts");
        new DashboardPage().navigateToModule("Customers", "Contacts");

        extentLogger.info(" click on email mbrackstone9@example.com");

        ContactsPages contactsPage = new ContactsPages();
        contactsPage.waitUntilLoaderScreenDisappear();
        contactsPage.getEmail("mbrackstone9@example.com").click(); //sadece burdaki emaili degistirerek dinamik olarak bilgileri kontrol edebilecegim


        extentLogger.info("verify that email is mbrackstone9@example.com");
        ContactInformationPage mariamBrackstone = new ContactInformationPage();
        String actualEmail = mariamBrackstone.email.getText();
        Assert.assertEquals(actualEmail, "mbrackstone9@example.com", "verify that email is mbrackstone9@example.com" );
        extentLogger.pass("Email PASSED");

        extentLogger.info("verify that full name is Mariam Brackstone");
        String actualUsername =mariamBrackstone.username.getText();
        Assert.assertEquals(actualUsername,"Mariam Brackstone","verify that full name is Mariam Brackstone" );
        extentLogger.pass("UserName PASSED");

        extentLogger.info("verify that phone number is +18982323434");
        String actualPhone =mariamBrackstone.phone.getText();
        Assert.assertEquals(actualPhone,"+189823234340","verify that phone number is +18982323434" );
        extentLogger.pass("phone PASSED");

        extentLogger.pass("TEST PASSED");

    }



}
