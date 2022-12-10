package dontmover.test_task;

public class item {
    private static int amount;
//    private static String name;
    private static int id;
    public static int getId(){
        return id;
    }
//    public static String getName(){
//        return name;
//    }
    public void setId(int id){
        this.id = id;
    }
//    public void setName(String name){
//        this.name = name;
//    }
    public static int getAmount(){
        return amount;
    }
    public void setAmount(int amount){
        this.amount = amount;
    }

}
