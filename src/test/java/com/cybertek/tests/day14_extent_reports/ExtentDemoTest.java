package com.cybertek.tests.day14_extent_reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.BeforeMethod;

public class ExtentDemoTest {

    //this class is used for starting and building reports
    ExtentReports report;
    //this class is used create HTML report file
    ExtentHtmlReporter htmlReporter;
    //this will define a test, enables adding logs, authors, test steps
    ExtentTest extentLogger;

    @BeforeMethod  // we are not extendingBaseClass here , just separate class
    public void setUp(){
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

        //

    }

    


}
