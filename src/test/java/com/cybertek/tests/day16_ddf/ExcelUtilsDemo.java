package com.cybertek.tests.day16_ddf;

import com.cybertek.utilities.ExcelUtil;
import org.testng.annotations.Test;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilsDemo {

    @Test
    public void readExcelFile(){

        //Create an object from ExcelUtil
        //it accepts two argument
        //Argument 1: location of the file(path)
        //Argument 2: sheet that wew want to open(sheetName)

        ExcelUtil qa3short = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx","QA3-short");                //object "qa3short" ==> sheetName from ExcelWorkbook

        //how many rows in the sheet
        System.out.println("qa3short.rowCount() = " + qa3short.rowCount());  //qa3short.rowCount() = 14

        //how many columns in the sheet
        System.out.println("qa3short.columnCount() = " + qa3short.columnCount()); //qa3short.columnCount() = 4

        //get all column names
        System.out.println("qa3short.getColumnsNames() = " + qa3short.getColumnsNames()); //qa3short.getColumnsNames() = [username, password, firstname, lastname]

        //get all data in list of maps
        System.out.println("qa3short.getDataList() = " + qa3short.getDataList());

        List<Map<String, String>> dataList =qa3short.getDataList();
        for (Map<String, String> onerow : dataList){
            System.out.println(onerow);
        }

        //get Nona as a value

        System.out.println("dataList.get(2) = " + dataList.get(2));  //List icinden 3.row u, yani index [2] den MAP i aldik
        System.out.println(dataList.get(2).get("firstname")); //Nona ==> Map icinden get(key) ile values u aldik

        //get Harber
        System.out.println(dataList.get(8).get("lastname"));  // index[0] dan row sayisini sayiyoruz

        //get all data in 2d array
        String[][] dataArray = qa3short.getDataArray();  //get all data from multidimensional array

        //print 2d array
        System.out.println(Arrays.deepToString(dataArray));    //print the information from multidimensional array







    }
}