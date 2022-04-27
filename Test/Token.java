public class Token {

    //Déclaration de 3 variables d'instances
    private String first;
    private int second;
    private Object v_sauvegardé;

    //Constructeur pour une entrée String()
    public Token(String value) {
        this.first = value;
        this.v_sauvegardé=first;
    }

    //Constructeur pour une entrée int()
    public Token(int value){
        this.second = value;
        this.v_sauvegardé=second;
    }

    //Vérifie le type de l'objet sauvegardé
    public boolean isString(){
        if(v_sauvegardé instanceof String ){
            return true;
        }
        return false;
    }

    //Vérifie l'égalité de 2 object Token
    public  static boolean equals(Token a, Token b){
        if(a!=null && b!=null) {
            if (a.isString() && b.isString()) {
                if ((a.v_sauvegardé).equals(b.v_sauvegardé)) {
                    return true;
                }
            } else if (!a.isString() && !b.isString()) {
                if ((a.v_sauvegardé == b.v_sauvegardé)) {
                    return true;
                }
            }
        } else if(a==null && b==null) return true;

        return false;
    }

    //retourne la représentation en String() de l'objet
    public String toString(){ return String.valueOf(v_sauvegardé); }
}
