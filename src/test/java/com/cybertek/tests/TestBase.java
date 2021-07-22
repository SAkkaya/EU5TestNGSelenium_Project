package com.cybertek.tests;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {

    protected WebDriver driver; //protected=> (public de olurdu, subchild public mor evisible olmasi gereken subchild) Login Test den erisimesi icin default yetmez o yuzden protected yaptik (ingeritence -extends olan class dan erisilmesi icin)
    protected Actions actions;
    protected WebDriverWait wait;

    @BeforeMethod
    public void SetUp(){
        driver = Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);  //implicit wait de HTML codeunda aradigimiz htmel  locate inin gorunmesini bekliyoruz
                                                                                    // NosuchElement exception verir
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, 10); // aradigimiz sey htm de var locate edebilmisiz ama saafanin yuklemnmesini bekliyoruz aradigimiz seyi sayfada laoding edilmesii
                                                                                    //TimeOUT exception veriri
        driver.get(ConfigurationReader.get("url"));

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        Driver.closeDriver();
    }

}
