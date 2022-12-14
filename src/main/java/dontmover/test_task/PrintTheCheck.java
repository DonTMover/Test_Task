package dontmover.test_task;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PrintTheCheck {
    public static boolean hasCard = false;

    public static String str1 = null;

    public static void printTheCheck(ArrayList<item> arrayList){

        try {

            int price = 0;
            ResultSet resultSet1 = sql.AllQuery("cards");
            ArrayList<String> buy = new ArrayList<>();
            ArrayList<Integer> buyAmount = new ArrayList<>();
            ResultSet resultSet = sql.AllQuery("items");


                while (resultSet.next()) {
                    for (item item : arrayList) {
                        if (!item.getId().equalsIgnoreCase("card")){
                            if(Integer.parseInt(item.getId())==resultSet.getInt("id")) {
                                var str = resultSet.getString("name");
                                buy.add(str);
                                buyAmount.add(Integer.parseInt(item.getAmount()));


                            }
                        }else{
                            String str = item.getAmount();//WE have card number and need check on dataBase;
                            str1 = str;

                            while(resultSet1.next()){
                                if (str.equalsIgnoreCase(resultSet1.getString("id"))){
                                    hasCard = true;
                                    System.out.println("Card true!");
                                }
                            }
                        }


                    }
//                    ArrayList<Integer> priceFromDB = new ArrayList<>();//Price from sql
                    Map<Integer,Integer> pricesWitchID = new HashMap<>();
                    ArrayList<Integer> priceOf = new ArrayList<>();
                    ArrayList<Integer> priceIfHave = new ArrayList<>();
                    int discound = 0;
                    if (hasCard){
                        while(resultSet.next()){
                            pricesWitchID.put(resultSet.getInt("id"),resultSet.getInt("price"));
                        }
                        for (item item : arrayList) {

                            price = price + pricesWitchID.get(item.getId());
                        }
                        System.out.println(price + " Price witchout discound ");
                        while(resultSet1.next()){
                            if (str1.equalsIgnoreCase(resultSet1.getString("id"))){
                                discound = resultSet1.getInt("discound");
                            }
                            price = price - (price *(discound/100));

                        }
                        System.out.println(price);
                    }else{
                        while(resultSet.next()){
                            pricesWitchID.put(resultSet.getInt("id"),resultSet.getInt("price"));
                        }
                        for (item item : arrayList) {
                            price = price + pricesWitchID.get(item.getId());
                        }
                        System.out.println(price + " Price");
                    }
//                    if (hasCard){
//                        while(resultSet.next()){
//                            price1.add(resultSet.getInt("price"));
//                        }
//                        for (item item : arrayList) {
//                            priceOf.add(Integer.parseInt(item.getId()));
//                        }
//                        for (Integer integer : price1) {
//                            for (Integer pric : price1) {
//                                for (Integer integer2 : priceOf) {
//                                    if (){
//
//                                    }
//                                }
//                            }
//                        }
//                        System.out.println(price);
//                        while(resultSet1.next()){
//                            if (str1.equalsIgnoreCase(resultSet1.getString("id"))){
//                                discound = resultSet1.getInt("discound");
//                            }
//                            price = price - (price *(discound/100));
//                            System.out.println(price);
//                        }
//
//                    }else{
//                        while(resultSet.next()){
//                            price1.add(resultSet.getInt("price"));
//                        }
//                        for (Integer integer : price1) {
//
//                        }
//
//                    }
                }



        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }


    }
}
