public class Cashier {

    private Queue<Customer> queue;
    private Customer currentCustomer;
    private int customerServed, totalItemServed,totalCustumerWaitTime;

    public Cashier(){
        this.customerServed=0;
        this.totalItemServed=0;
        queue = new ArrayQueue<Customer>();
    }

    public void addCustomer(Customer c) {
        queue.enqueue(c);

    }

    public int getQueueSize() {
        return queue.size();
    }

    public void serveCustomers(int currentTime){
        if(!queue.isEmpty() || currentCustomer!=null){
            if(currentCustomer==null){
                currentCustomer=queue.dequeue();
            }
            currentCustomer.serve();
            if(currentCustomer.getNumberOfItems()==0){
                totalItemServed+=currentCustomer.getNumberOfServedItems();
                totalCustumerWaitTime+=currentTime-currentCustomer.getArrivalTime();
                currentCustomer=null;
                customerServed++;
            }
        }
    }

    public int getTotalCustomerWaitTime(){
        return totalCustumerWaitTime;
    }

    public int getTotalCustomersServed(){
        return customerServed;
    }

    public int getTotalItemsServed(){
        return totalItemServed;
    }

    public String toString(){
        return "The total number of customers served is "+ customerServed +
                "\nThe average number of items per customer was "
                +Math.round((double)totalItemServed/customerServed) +
                "\nThe average waiting time (in seconds) was " +
                (int)Math.round((double)totalCustumerWaitTime/customerServed)+ "\n";
    }
}
