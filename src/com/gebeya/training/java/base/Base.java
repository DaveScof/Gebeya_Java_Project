package com.gebeya.training.java.base;

/**
 * Created by mativo on 22/11/2016.
 */
public class Base {

    /**
     * Print a message
     * @param c The class from which it was run, acts as the title of the
     * @param log The message to print
     */
    public static void println(Class c, String log){
        System.out.println("-----------------------");
        System.out.println(c.getName()+":"+log);
        System.out.println("-----------------------");
    }

    /**
     * Print a message
     * @param log The message to print
     */
    public void println(String log){
        System.out.println("-----------------------");
        System.out.println(getClass().getName()+":"+log);
        System.out.println("-----------------------");
    }

    /**
     * Print message
     * @param c The title of the log message
     * @param log The message to print
     */
    public static void println(String c, String log){
        System.out.println("-----------------------");
        System.out.println(c+":"+log);
        System.out.println("-----------------------");
    }

}
