package org.example;

public class Logger {

    //private constructor
    private Logger(){
        System.out.println("Constructor of Logger called...");
    }

    //public method to return logger instance
    public static Logger create_instance(){
        if(logger_object==null) {
            return new Logger();
        }
        return logger_object;
    }

    //toy method for logging
    public void log(String msg){
        System.out.println("Logging : " + msg);
    }

    //private static instance
    private static Logger logger_object;

}
