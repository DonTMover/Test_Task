package dontmover.test_task;

public class item {
    boolean promotional;
    String amount;
    String id;
    int price;
    String name;
}
interface itemBuilder{
    itemBuilder setAmount(String amount);
    itemBuilder setId(String id);
    itemBuilder setPromotional(boolean promotional);
    itemBuilder setPrice(int price);
    itemBuilder setName(String name);
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
    public itemBuilder setPrice(int price) {
        item.price = price;
        return this;
    }

    @Override
    public itemBuilder setName(String name) {
        item.name = name;
        return this;
    }

    @Override
    public item build() {
        return item;
    }
}
