package dontmover.test_task;

public class item {
    private  String amount;
//    private static String name;
    private  String id;
    public String getId(){
        return id;
    }
//    public static String getName(){
//        return name;
//    }
    public void setId(String id){
        this.id = id;
    }
//    public void setName(String name){
//        this.name = name;
//    }
    public String getAmount(){
        return amount;
    }
    public void setAmount(String amount){
        this.amount = amount;
    }
    public item(String id,String amount){
        setAmount(amount);
        setId(id);
    }

}
