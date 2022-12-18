package dontmover.test_task;

public class item {
    private  String amount;
    private  String id;
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }
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
