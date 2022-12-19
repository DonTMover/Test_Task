package dontmover.test_task;

public class item {
    boolean promotional;
    String amount;
    String id;
//    public String getId(){
//        return id;
//    }
//    public void setId(String id){
//        this.id = id;
//    }
//    public String getAmount(){
//        return amount;
//    }
//    public void setAmount(String amount){
//        this.amount = amount;
//    }
//    public item(String id,String amount){
//        setAmount(amount);
//        setId(id);
//    }

}
interface itemBuilder{
    itemBuilder setAmount(String amount);
    itemBuilder setId(String id);
    itemBuilder setPromotional(boolean promotional);
    item build();

}
class itemBuilderImpl implements itemBuilder{
    item item = new item();
    @Override
    public itemBuilder setAmount(String amount) {
        item.amount = amount;
        return this;
    }

    @Override
    public itemBuilder setId(String id) {
        item.id = id;
        return this;
    }

    @Override
    public itemBuilder setPromotional(boolean promotional) {
        item.promotional = promotional;
        return this;
    }

    @Override
    public item build() {
        return item;
    }
}
