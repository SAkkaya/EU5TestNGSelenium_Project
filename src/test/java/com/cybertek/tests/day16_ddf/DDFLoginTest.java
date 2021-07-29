package com.cybertek.tests.day16_ddf;

import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFLoginTest extends TestBase {

    @DataProvider
    public Object[][] userData(){

        ExcelUtil qa3short = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx","QA3-short");
        // QA3-short ==> QA uc environment i aldigimiz icin configuration.properties de environmenti degistir
        String [][] dataArray = qa3short.getDataArrayWithoutFirstRow();

        return dataArray;
    }

    @Test(dataProvider = "userData")
    public  void test1(String username, String password, String firstName, String lastName){

        extentLogger = report.createTest("Test" + firstName + " " + lastName);
        LoginPage loginPage = new LoginPage();

        loginPage.login(username, password);

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();

        String actualFullName = dashboardPage.getUserName();

        String expectedFullName =  firstName + " "+ lastName;  // methodun local varuabline girilen

        Assert.assertEquals(actualFullName,expectedFullName, "Verify fullname");

        extentLogger.pass("PASSED");

    }


    /*
    DATA PROVIDER ILE TEST I Run edince
    Her seferinde yeni before ve after method acacak, yeni driver objesi olusturacak her nekadar Singleton olsa da ,
    cunku her bir TEst biribirinden bagisiz run olacak birisi fail olursa orda durmayacak diger testleri kosmaya devam edecek
    raporda butun hepsini fail/pass diye gosterecek


    Eger configuration.properties de brpwser= chrome-headless yapasak,  after method dada quit() den onceki Thread.sleep i comment e alirsak cok daha hizli olur
     */



}
