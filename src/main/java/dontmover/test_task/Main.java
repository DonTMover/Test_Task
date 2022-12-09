package dontmover.test_task;


public class Main {

    public static void main(String[] args) {
        try{
            System.out.println(AddToDataBase.AddToCards(1,99,"Egor","Penko"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}