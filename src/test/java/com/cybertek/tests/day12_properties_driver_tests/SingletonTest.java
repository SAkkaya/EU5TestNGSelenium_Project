package com.cybertek.tests.day12_properties_driver_tests;

import com.cybertek.utilities.Driver;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SingletonTest {

   // @Test
    public void test1(){

     //   Singleton singleton = new Singleton(); // private Constructor private object yaratmayiz baska class da

        String s1 = Singleton.getInstance();
        String s2 = Singleton.getInstance();

        System.out.println("s1 = " + s1); // s1 i static olan variable a ilk atadigi icin , asagida bu value u  koruyacak
        System.out.println("s2 = " + s2);  // private static String str; ==> static value oldugu icin  asagida bu atadigi value  i tutacak

    }

    @Test   // test2() ve test3() ayni driver ile iki farkli browser acacak ==> Singleton methodu ile
    //Driver.closeDriver(); yani driver i null yapmadigimiz surece ayni driver i kullanacak , eger null yaparsak farkli driver acacak, yapmazsak yeni driver i null yapana yani close yapana kadar kullanacak

    public void test2() throws InterruptedException {
        WebDriver driver = Driver.get();    //   bunun yerine asagidaki gibi kislatabiliriz
        Thread.sleep(2000);
         driver.get("https://www.google.com");

   //     Driver.get().get("https://www.google.com");  //Driver.get()==> get object from here directly ==> JAVA method
                                                            //get("https://www.google.com") ==> SELENIUM method


    //    Driver.closeDriver();  // static method oldugu icim Class(Driver) ad ile cagirdik, Singleton prensible pointing the same object untill you pointing a null, to create a new object ( driver)


    }

    @Test
    public void test3(){

        Driver.get().get("https://www.amazon.com");
    }




}
