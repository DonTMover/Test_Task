package dontmover.test_task;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PrintTheCheck {
    public static boolean hasCard = false;

    public static Integer str1 = 0;

    public static void printTheCheck(ArrayList<item> arrayList) throws IOException {
        File file = new File("result.txt");
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(file);
        try {
            float price = 0;
            ResultSet resultSet1 = sql.AllQuery("cards");
            ResultSet resultSet = sql.AllQuery("items");
                while (resultSet.next()) {
                    for (item item : arrayList) {
                        if (!item.getId().equalsIgnoreCase("card")){
                            if(Integer.parseInt(item.getId())==resultSet.getInt("id")) {
                                var str = resultSet.getString("name");
                            }
                        }else{
                            String str = item.getAmount();//WE have card number and need check on dataBase;
                            str1 = Integer.parseInt(str);

                            while(resultSet1.next()){
                                if (str.equalsIgnoreCase(resultSet1.getString("id"))){
                                    hasCard = true;
                                }
                            }
                        }


                    }


                    //Тест обычного statment

                        for (item item : arrayList) {
                            String sqlwherequery = "SELECT * FROM items WHERE id = ";
                            if (!item.getId().equalsIgnoreCase("card")){
                                sqlwherequery = sqlwherequery+item.getId();
                                Connection connection = sql.GetConnection();
                                Statement statement = connection.createStatement();
                                ResultSet resultSet2 = statement.executeQuery(sqlwherequery);
                                //ResultSet resultWitchAllContextInItemsWhereID = sql.whereQuery("id","items",item.getId()); // результсет который содержит всю инфу по объекту которую мы узнаем по id
                                if (resultSet2.next()){
                                    String name = resultSet2.getString("name");
                                    int priceTemp = resultSet2.getInt("price");
                                    System.out.printf("Amount:%d Name:%s Price:%d\n",Integer.parseInt(item.getAmount()),name,priceTemp);

                                    fileWriter.write("Amount:"+item.getAmount()+" Name:"+name+" Price:"+priceTemp+"\n");
                                }
                            }
                        }
                    Map<Integer,Integer> pricesWitchID = new HashMap<>();
                    ResultSet resultSet4 = sql.whereQuery("id","cards",String.valueOf(str1));

                    float discound = 0;
                    if (hasCard){
                        while(resultSet.next()){
                            pricesWitchID.put(resultSet.getInt("id"),resultSet.getInt("price"));
                        }
                        for (item item : arrayList) {
                            if (item.getId().equalsIgnoreCase("card")){
                                //Так и надо
                            }else{
                                price += pricesWitchID.get(Integer.parseInt(item.getId())) * Integer.parseInt(item.getAmount());
                            }

                        }
                        if (resultSet4.next()){
                            discound = resultSet4.getInt("discound");
                            price =price - (price *(discound/100));
                        }
                        System.out.println("Total Price: " + price);
                        fileWriter.write("Total Price: " + price);
                        resultSet4.close();

                    }else{
                        while(resultSet.next()){
                            pricesWitchID.put(resultSet.getInt("id"),resultSet.getInt("price"));
                        }
                        for (item item : arrayList) {
                            price = price + pricesWitchID.get(Integer.parseInt(item.getId())) * Integer.parseInt(item.getAmount());
                        }
                        System.out.println("Total Price: " + price);
                        fileWriter.write("Total Price: " + price);
                    }

                }
                resultSet.close();
                resultSet1.close();
                fileWriter.flush();
                fileWriter.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }


    }
}
