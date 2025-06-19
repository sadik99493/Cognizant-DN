package org.example;

public class Main {
    public static void main(String[] args) {
        //creating logger objects
        Logger a = Logger.create_instance();
        Logger b = Logger.create_instance();

        //using the objects
        a.log("using logger object 1");
        b.log("using logger object 2");

        //creating tester object
        Testing tester  = new Testing();

        //testing singleton behavior
        if(tester.test_single(a,b)){
            System.out.println("The 2 objects are same....Singleton pattern satisfied");
        }
        else{
            System.out.println("The 2 objects are different...Singleton pattern violated");
        }

    }
}