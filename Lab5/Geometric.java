public class Geometric extends AbstractSeries {

    private int value=0;
    private double resultat=0;

    public double next() {
        resultat+=1/Math.pow(2,value);
        value++;
        return resultat;

    }
}