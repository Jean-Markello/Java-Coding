public class Q3_SquareArray{

    public static int[] createArray(int size) {
        int[] tablearray = new int[size];
        for (int i=0; i<size; i++) {
            tablearray[i]= (int)Math.pow(i,2);
        }
        return tablearray;
    }

    public static void main(String[] args){
        int size =13;
        int [] table=createArray(size);

        for (int i=0; i<=(table.length-1); i++) {
            System.out.println("The square of " + i +" is: "+table[i]);
        }
    }
}