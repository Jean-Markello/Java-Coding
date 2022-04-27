public class Rational {

    private int numerator;
    private int denominator;

    // constructors

    public Rational(int numerator) {
        this.numerator=numerator;
        denominator=1;
    }

    public Rational(int numerator, int denominator) {
        this.numerator=numerator;
        this.denominator=denominator;
        reduce();
    }

    // getters

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    // instance methods

    public Rational plus(Rational other) {
        int new_denominator= denominator* other.denominator;
        int numerator1= numerator* other.denominator;
        int numerator2= other.numerator*denominator;
        int new_numerator = numerator1 + numerator2;

        return new Rational(new_numerator, new_denominator);
    }

    public static Rational plus(Rational a, Rational b) {
        int new_denominator= a.denominator* b.denominator;
        int numerator1= a.numerator* b.denominator;
        int numerator2= b.numerator*a.denominator;
        int new_numerator = numerator1 + numerator2;
        return new Rational(new_numerator, new_denominator);
    }

    // Transforms this number into its reduced form

    private void reduce() {
        int multiple_commun=gcd(this.numerator,this.denominator);
        this.numerator=this.numerator/multiple_commun;
        this.denominator=this.denominator/multiple_commun;

    }

    // Euclid's algorithm for calculating the greatest common divisor
    private static int gcd(int a, int b) {
        // Note that the loop below, as-is, will time out on negative inputs.
        // The gcd should always be a positive number.
        // Add code here to pre-process the inputs so this doesn't happen.
        boolean sign = false;

        if (a<0){
            a = a * -1;
            sign=true;
        }
        if (b<0){
            b=b*-1;
            sign=true;
        }

        while (a != b)
            if (a > b)
                a = a - b;
            else
                b = b - a;

        if (sign==true){
            a = a * -1;
        }

        return a;
    }

    public int compareTo(Rational other) {
        if (((double)this.numerator/(double)this.denominator) < ((double)other.numerator/(double)other.denominator)) {
            return -1;
        } else if (((double)this.numerator/(double)this.denominator) > ((double)other.numerator/(double)other.denominator)) {
            return 1;
        } else if(((double)this.numerator/(double)this.denominator) == ((double)other.numerator/(double)other.denominator)) {
            return  0;
        } return 0;
    }

    public boolean equals(Rational other) {
        if ((numerator/denominator)==(other.numerator/ other.denominator)){
            return true;
        }else {
            return false;
        }
    }

    public String toString() {
        String result;
        if (denominator == 1) {
            result= Integer.toString(numerator);
        } else {
            result= numerator+"/"+denominator;
        }
        return result;
    }

}