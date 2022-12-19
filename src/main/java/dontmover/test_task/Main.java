package dontmover.test_task;


import java.io.*;
import java.util.ArrayList;


public class Main {


    public static void main(String[] args) throws IOException {
            if (args[0].equalsIgnoreCase("-f")){
                BufferedReader bufferedReader = new BufferedReader(new FileReader(args[1]));
                String str = bufferedReader.readLine();

                String[] str1 = str.split(" ");
                ArrayList<item> items = new ArrayList<>();
                for (String s : str1) {
                    String[] str3 = s.split("-");
                    items.add(new itemBuilderImpl().setId(str3[0]).setAmount(str3[1]).build());
                }
                PrintTheCheck.printTheCheck(items);
            }else{
                    ArrayList<item> items = new ArrayList<>();
                    for (String arg1 : args){
                        String[] str = arg1.split("-");
                        items.add(new itemBuilderImpl().setId(str[0]).setAmount(str[1]).build());
                    }
                    PrintTheCheck.printTheCheck(items);
                }

        }


}