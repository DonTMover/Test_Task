package dontmover.test_task;



import com.sun.source.tree.WhileLoopTree;

import java.sql.*;
import java.util.ArrayList;


public class Main {

    public static boolean hascard = false;
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ArrayList<item> items = new ArrayList<>();
        for (String arg : args){
            String[] str = arg.split("-");
            System.out.println();
            items.add(new item(str[0],str[1]));
        }

//        for (item item : items) {
//            System.out.println("amount: "+item.getAmount());
//            System.out.println("id: "+item.getId());
//        }
//        for (item item : items) {
//            if (item.getId().equalsIgnoreCase("card")){
//                String amount = item.getAmount();
//                ResultSet resultSet = sql.AllQuery("cards");
//                while (resultSet.next()){
//                    String id = String.valueOf(resultSet.getInt("id"));
//                    if (id.equalsIgnoreCase(amount)){
//                        hascard=true;
//                        System.out.println("true card");
//                    }else {
//                        System.out.println("FAKE CARD!!!");
//                        hascard=false;
//                    }
//                }
//
//            }else {
//                System.out.println("false");
//                hascard=false;
//            }
//        }
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        ResultSet resultSet = sql.AllQuery("items");
//        while(resultSet.next()){
//            String id = String.valueOf(resultSet.getInt("id"));
//            for (item item : items) {
//                if (item.getId().equals(id)) {
//                    if (id.equals("card")){
//
//                    }
//
//                    System.out.println("+");
//                } else {
//                    System.out.println("-");
//                }
//
//            }
//            System.out.printf("%s\n",id);
//        }

        ResultSet resultSet = sql.AllQuery("cards");

        String id1 = "";
        while (resultSet.next()){
            for (item item : items) {
                if (item.getId().equals("card")){
                    id1 = item.getAmount();
                }

            }
            String id = String.valueOf(resultSet.getInt("id"));
            if (id.equals(id1)) {
                hascard = true;
                System.out.println("true card!");
            }
        }
        resultSet.close();
        ResultSet resultSet1 = sql.AllQuery("items");
        while (resultSet1.next()){
            for (item item : items) {
                if(item.getId().equalsIgnoreCase(resultSet1.getString("id"))){
                    System.out.println("SADASASD");
                }
                System.out.println(resultSet1.getString("id"));

            }
        }








    }
}