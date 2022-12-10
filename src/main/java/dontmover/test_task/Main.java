package dontmover.test_task;


import java.sql.*;
import java.util.Arrays;
import java.util.Objects;

public class Main {
    public static boolean hascard = false;
    public static void main(String[] args) {

        for (String arg : args){
            for (String s : arg.split("-")) {
                System.out.println(s);
            }
        }

    }
}