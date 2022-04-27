import java.util.Scanner;
import java.util.Arrays;

public class Q6 {
    public static void main(String[] args) {

        double[] notes= new double[10];
        Scanner scanner = new Scanner(System.in);

        for (int i=0; i<10; i++) {
            System.out.println("Entrer une note de cours");
            notes[i]= scanner.nextDouble();
        }

        double average= calculateAverage(notes);
        double median= calculateMedian(notes);
        int numberFailed=calculateNumberFailed(notes);
        int numberPassed=calculateNumberPassed(notes);

        System.out.println("The average is: " + average);
        System.out.println("The median is: " + median);
        System.out.println("The number of student that Failed is: " + numberFailed);
        System.out.println("The number of student that Passed is: " + numberPassed);

    }

    public static double calculateAverage(double[] notes) {
        double average=0;
        for (double i: notes) {
            average+=i;
        }
        return average/notes.length;
    }

    public static double calculateMedian(double[] notes) {
        Arrays.sort(notes);
        if (notes.length%2==0) {
            int median1=(int)notes.length/2-1;
            int median2=(int)notes.length/2;
            double median= (notes[median1]+notes[median2])/2;
            return median;
        }
        else {
            int median=(int)notes.length/2;
            return notes[median];
        }
    }

    public static int calculateNumberFailed(double[] notes) {
        int numberFailed=0;
        for (double i:notes) {
            if (i<50.0) {
                numberFailed++;
            }
        }
        return numberFailed;
    }

    public static int calculateNumberPassed(double[] notes) {
        int numberPassed=0;
        for (double i:notes) {
            if (i>=50.0) {
                numberPassed++;
            }
        }
        return numberPassed;
    }
}
