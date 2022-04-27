import java.util.Random;

public class Customer {

    private int arrivalTime, numberOfItems,intialNumberOfItems;
    public static final int MAX_NUMBER_ITEMS =23;

    public Customer(int arrivalTime){
        this.arrivalTime = arrivalTime;
        Random generator=new Random();
        numberOfItems=generator.nextInt(MAX_NUMBER_ITEMS-1)+1;
        intialNumberOfItems=numberOfItems;

    }

    public int getArrivalTime(){
        return arrivalTime;
    }

    public int getNumberOfItems(){
        return numberOfItems;
    }

    public int getNumberOfServedItems(){
        return intialNumberOfItems-numberOfItems;
    }

    public void serve(){
        numberOfItems--;
    }

}
