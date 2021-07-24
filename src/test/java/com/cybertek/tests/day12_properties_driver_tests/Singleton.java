package com.cybertek.tests.day12_properties_driver_tests;

public class Singleton {

    //singleton class will have private constructor
    //it means other classes cannot create object of this class

    private Singleton(){}  //private constructor  , i want to create only one driver

    private static String str;

    public static String getInstance(){
        //if str has no value, initialize it and return it

        if (str==null){
            System.out.println("str is null. Assigning value it");
            str="somevalue";         // private static String str; ==> static value oldugu icin  asagida bu atadigi value  i tutacak
        }else {
            // if it has value just return it
            System.out.println("it has value, just returning it");
        }

        return str;

    }



}
