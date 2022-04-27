public class Q3_ArrayInsertionDemo {

    public static int[] insertIntoArray(int[] beforeArray, int indexToInsert, int valueToInsert){

        int b=0;
        int[] afterArray = new int[beforeArray.length+1];
        for (int i=0; i<(beforeArray.length); i++) {
            if (i==indexToInsert){
                afterArray[i]=valueToInsert;
                b++;
                afterArray[b]=beforeArray[i];
            }
            else{
                afterArray[b]=beforeArray[i];
            }
            b++;
        }
        return afterArray;
    }

    public static void main(String[] args){
        int[] beforeArray = new int[]{1,5,4,7,9, 6};
        int[] afterArray = insertIntoArray(beforeArray, 3, 15);
        System.out.println("Array avant l'insertion:");
        for (int i: beforeArray){
            System.out.println(i);
        }

        System.out.println("Array après l'insertion de "+ 15 +" à position " +3 +":");
        for (int a:afterArray) {
            System.out.println(a);
        }

    }
}
