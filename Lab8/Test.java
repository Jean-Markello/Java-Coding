public class Test {
    public static void main(String[] args) {

        Cashier cashier = new Cashier();
        Customer customer1 = new Customer(5);
        Customer customer2 = new Customer(10);
        cashier.addCustomer(customer1);
        cashier.addCustomer(customer2);

        int items1 = customer1.getNumberOfItems();
        int items2 = customer2.getNumberOfItems();

        for (int i = 0; i < items1; i++) {
            cashier.serveCustomers(10);
        }
        System.out.println("jhh "+items2);

        for (int i = 0; i < items2; i++) {
            cashier.serveCustomers(15);
        }


        System.out.println("Total customers served after 2 customers"+ 2 + " "+cashier.getTotalCustomersServed());

        }
}
