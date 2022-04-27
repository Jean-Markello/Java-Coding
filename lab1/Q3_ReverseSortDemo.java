public class Q3_ReverseSortDemo {
    public static void main(String[] args){
        char[] unorderedLetters;
        unorderedLetters = new char[]{'b', 'm', 'z', 'a', 'u'};
        reverseSort(unorderedLetters);
        for (int i = 0 ; i < unorderedLetters.length; i++ )
            System.out.print(unorderedLetters[i]);
    }

    //method that sorts a char array into its reverse alphabetical order
    public static void reverseSort(char[] values){
        for (int i=0; i < values.length; i++) {
            for (int j=i; j<values.length; j++) {
                if (values[j]>values[i]) {
                    char temp = values[i];
                    values[i] = values[j];
                    values[j] = temp;
                }
            }
        }

        for (int a: values) {
            System.out.println(a);
        }

    }
}
