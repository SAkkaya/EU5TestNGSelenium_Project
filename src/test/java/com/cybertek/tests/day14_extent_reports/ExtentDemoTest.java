package com.cybertek.tests.day14_extent_reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtentDemoTest {

    //this class is used for starting and building reports
    ExtentReports report;
    //this class is used create HTML report file
    ExtentHtmlReporter htmlReporter;
    //this will define a test, enables adding logs, authors, test steps
    ExtentTest extentLogger;

    @BeforeMethod  // we are not extendingBaseClass here , just separate class
    public void setUp(){  // this part is static for copy pasting for all test cases
         //initialize the class
        report = new ExtentReports();

        //create a report path
        String projectPath = System.getProperty("user.dir");
        String path = projectPath + "/test-output/report.html";  // report.html isimli report file i olusturacak kendisi,  => /test-output   bu da path i olacak

        //initialize the html reporter with the report path
        htmlReporter = new ExtentHtmlReporter(path); // creating an object from Constructor and passing my path in it, i will save my report file in path( projectPath + "/test-output/report.html)

        //attach the html report to report object
        report.attachReporter(htmlReporter);  // creating connection my main object report to html report-file

        //title in report
        htmlReporter.config().setReportName("Vytrack Smoke Test");

        //set environment information
        report.setSystemInfo("Environment", "QA");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS",System.getProperty("os.name"));


    }

    @Test
    public void test1(){  // here is the dynamic part
        //give name to current test
        extentLogger= report.createTest("TC123 Login as Driver Test");

        //test steps
        extentLogger.info("Open Chrome Browser");

        extentLogger.info("Go to this URL");

        extentLogger.info("Enter driver username password");

        extentLogger.info("Click Login");

        extentLogger.info("Verify logged in");

        //pass() --> marks the test case as passed
        extentLogger.pass("TC123 is passed");

    }

    @AfterMethod
    public void teardown(){
        //this is when the report is actually created
        report.flush();

    }

    


}
