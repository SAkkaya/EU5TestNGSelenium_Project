package com.cybertek.tests.day10_file_upload;

import org.testng.annotations.Test;

public class FilePathExample {

    @Test
    public void test() {

        // textfile.txt nin local uzantisi  ==> ( right click()/ copy path/ absolute path )
        //    /Users/sadik/EU5TestNGSelenium/src/test/resources/textfile.txt

       // System.out.println(System.getProperty("os.name"));  //Mac OS X

       // System.out.println(System.getProperty("user.dir"));  //==local uzantisi==>     /Users/sadik/EU5TestNGSelenium

        String projectPath = System.getProperty("user.dir");

       // textfile.txt  uzerine gelip --> ( right click()/ copy path/ path from content root )
        String filePath = "src/test/resources/textfile.txt"; // bunun basinda /  koymamiz gerekiyor

        String fullPath= projectPath + "/" + filePath;

        System.out.println("fullPath = " + fullPath);

    }


}
