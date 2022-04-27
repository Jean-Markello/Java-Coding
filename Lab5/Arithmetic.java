public class Arithmetic extends AbstractSeries {

    private int value=0;
    private double resultat=0;

    public double next() {
        value++;
        resultat+=value;
        return resultat;

    }
}