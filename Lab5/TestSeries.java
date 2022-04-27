public class TestSeries {

    public static void main(String[] args) {

        Book myBook = new Book(null, "Hamlet", 1600);
        Book myBook2 = new Book(null, "Hamlet", 1600);
        System.out.println(myBook.equals(myBook2));

        Book myBook3 = new Book("Shakespeare", "Hamlet", 1600);




        String a1 = new String("Shakespeare");
        String a2 = new String("Shakespeare");
        String t1 = new String("Hamlet");
        String t2 = new String("Hamlet");

        Book myBook5 = new Book(a1, t1, 1600);
        System.out.println(myBook5.equals(myBook5));
        Book myBook6 = new Book(a2, t2, 1600);
        System.out.println(myBook5.equals(myBook6));
    }
}