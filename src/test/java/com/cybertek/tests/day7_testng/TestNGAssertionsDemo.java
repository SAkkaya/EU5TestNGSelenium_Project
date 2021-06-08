package com.cybertek.tests.day7_testng;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {

   @BeforeMethod
   public void setUp(){
       System.out.println("Open Browser");
   }

    @Test
    public void test1(){

        System.out.println("First Assertion");  // if 1.Test Fail, it will not proceed the next follow up tests
        Assert.assertEquals("title", "title");

        System.out.println("Second Assertion");
        Assert.assertEquals("url", "url");

    }

    @Test
    public void test2(){
       Assert.assertEquals("test2", "test2");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("Close Browser");
    }


}
