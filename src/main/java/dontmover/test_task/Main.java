package dontmover.test_task;



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

        for (item item : items) {
            System.out.println("amount: "+item.getAmount());
            System.out.println("id: "+item.getId());
        }
        for (item item : items) {
            if (item.getId().equalsIgnoreCase("card")){
                System.out.println("true");
                hascard = true;
            }else {
                hascard=false;
            }
        }
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        ResultSet resultSet = sql.AllQuery("items");
        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            System.out.printf("%d %s\n",id,name);
        }








    }
}