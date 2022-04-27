import java.util.Arrays;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {

        //String thing
        String[] alphabet;
        alphabet = new String[]{"alpha", "bravo", "charlie", "delta","echo"};
        System.out.println(Arrays.toString(alphabet));
        StringUtils.reverse(alphabet);
        System.out.println(Arrays.toString(alphabet));
        StringUtils.reverse(alphabet);
        System.out.println(Arrays.toString(alphabet));
        System.out.println();

        //Token
        Token a,b,c;
        a = new Token ("alpha" ) ;
        b = new Token ("alpha" ) ;
        c = new Token ( 42 ) ;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        System.out.println();

        System.out.println("a.isDtring() is "+a.isString());
        System.out.println("c.isDtring() is "+c.isString());

        System.out.println();

        System.out.println("Token.equals(a,b) is " + Token.equals(a,b));
        System.out.println("Token.equals(b,c) is " + Token.equals(b,c));
        System.out.println("Token.equals(c,null) is " + Token.equals(c,null));

        System.out.println();


        //Magic
        MagicSquare s1,s2;

        int[] values = new int[] {1,8,6,3,5,7,4,9,2};

        s1=new MagicSquare(values);
        values[0]=8;
        values[1]=1;

        s2= new MagicSquare(values);

        System.out.println(s1);
        System.out.println(s1.getSize());
        System.out.println(s1.getConstant());
        System.out.println(s1.isMagic());
        System.out.println(s1.whyNotMagic());

        System.out.println();

        System.out.println(s2);
        System.out.println(s2.getSize());
        System.out.println(s2.getConstant());
        System.out.println(s2.isMagic());
        System.out.println(s2.whyNotMagic());



    }

}
