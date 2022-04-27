import java.util.Stack;

public class StringUtils {
    public static void reverse(String[] a){

        //Declarations des variables
        Stack<String> s;
        s=new Stack<String>();

        //On copie String[] a dans s
        for(int i=0; i<a.length; i++){
            s.push(a[i]);
        }

        //On copie Stack s dans a en commançant par la dernière valeur
        for(int g=0; g<a.length; g++){
            a[g]=s.pop();
        }
    }
}
