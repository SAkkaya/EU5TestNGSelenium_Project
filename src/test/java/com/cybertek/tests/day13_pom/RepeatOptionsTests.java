
package com.cybertek.tests.day13_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatOptionsTests extends TestBase {

    /*VERIFY RADIO BUTTONS
    Open Chrome browser
    Login as driver
    Go to Activities->Calendar Events
    Click on create calendar events
    Click on repeat
    VerifyContactInformationTest that repeat every days is checked
    verify that repeat weekday is not checked
    * */

    @Test
    public void test1(){

        LoginPage loginPage = new LoginPage();

        //Login as driver
        loginPage.loginAsDriver();

        DashboardPage dashboardPage = new DashboardPage();
        //Go to Activities->Calendar Events
        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        //Click on create calendar events
        //wait for loader mask
        calendarEventsPage.waitUntilLoaderScreenDisappear();   // ==> ElementClickInterceptedException  almamak icin
        BrowserUtils.waitForClickablility(calendarEventsPage.createCalendarEvent,5); //==> ElementClickInterceptedException  almamak icin

        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();   // ayri page ler bunlar
        // Click on repeat
        createCalendarEventsPage.repeat.click();

        //VerifyContactInformationTest that repeat every days is checked
        Assert.assertTrue(createCalendarEventsPage.days.isSelected(),"VerifyContactInformationTest repeat days is selected");
        //verify that repeat weekday is not checked
        Assert.assertFalse(createCalendarEventsPage.weekday.isSelected(),"VerifyContactInformationTest weekday is not selected");

    }

      /*
     VERIFY REPEAT OPTIONS
        Open Chrome browser
        Login as driver
        Go to Activities->Calendar Events
        Click on create calendar events button
        Click on repeat checkbox
        VerifyContactInformationTest that repeat options are Daily, Weekly, Monthly,Yearly(in this order)
     */


    @Test
    public void test2(){

        LoginPage loginPage = new LoginPage();

        //Login as driver
        loginPage.loginAsDriver();

        DashboardPage dashboardPage = new DashboardPage();
        //Go to Activities->Calendar Events
        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        //Click on create calendar events
        //wait for loader mask
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForClickablility(calendarEventsPage.createCalendarEvent,5);
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        // Click on repeat
        createCalendarEventsPage.repeat.click();

      //  Select repetsDropdown =new Select(repeatOptions);
        Select repeatsDropdown = createCalendarEventsPage.repeatOptionsList();
        //eger Select olmasi ise findelements   den bulacaktik

        // VerifyContactInformationTest that repeat options are Daily, Weekly, Monthly,Yearly(in this order)
        List<String> expectedList = Arrays.asList("Daily","Weekly","Monthly","Yearly");   //Arrays.asList= > liste olarak add() yapiyiruz tek tek degil

        List<String> actualList = new ArrayList<>();

        List<WebElement> actualOptions = repeatsDropdown.getOptions(); // getOptions()=> WebElement olarak atiyoruz
        for (WebElement option : actualOptions) {
            //get text of each element and add to actual List
            actualList.add(option.getText());
            System.out.println("option = " + option.getText());
        }


        System.out.println(actualList);


        //ready method for getting text of list of web elements
        List<String> actualList2 = BrowserUtils.getElementsText(actualOptions);
        //VerifyContactInformationTest that repeat options are Daily, Weekly, Monthly,Yearly(in this order)
        Assert.assertEquals(actualList,expectedList,"VerifyContactInformationTest Daily weekly monthly yearly");

    }


}

