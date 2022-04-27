public class MyClass {

    private static void printName(Compiler c) {
        System.out.println(c.name);
    }


    public static void main(String args[]) {
        int x=10;
        int y=25;
        Compiler c1 = null;
        Compiler c2 = null;
        c1 = new Compiler();
        System.out.println ("Sum of x+y = " + c1.name);
        printName (c2);
        int z=x+y;
        System.out.println("Sum of x+y = " + z);
    }
}