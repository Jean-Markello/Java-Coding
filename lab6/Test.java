public class Test {

    public static void myFunction(int n) throws MyException {
        try {
            if (n!=1) throw new MyException();
        } catch (MyException e) {
            System.out.println("myFunction.catch("+n+")");
            throw e;
        } finally {
            System.out.println("myFunction.finally("+n+")");
        }
    }

    public static void main(String args[]) {
        int n = 2;
        try {
            myFunction(n);
        } catch (MyException e) {
            System.out.println("main.catch(" + n + ")");
        } finally {
            System.out.println("main.finally(" + n + ")");
        }
    }
}
