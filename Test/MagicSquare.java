public class MagicSquare {

    //Variable d'instance
    private int[] board;
    private int size, constant;

    //Constructeur
    public MagicSquare(int[] values) {
        this.size = (int) Math.sqrt(values.length);
        this.constant = (int) (size * (Math.pow(size, 2) + 1)) / 2;
        board = values.clone();
    }

    //Méthode d'accès
    public int getSize() {
        return size;
    }

    public int getConstant() {
        return constant;
    }

    //Méthode getValue
    public int getValue(int row, int column) {
        int square_value = (getSize() * row) + column;
        return board[square_value];
    }

    //Vérifie si les nombres alignée en diagonales sont égales au constant
    public boolean isMagic() {
        return isMagicDiagonals() && isMagicRows() && isMagicColumns();
    }

    //Confirm if somme == contant
    private boolean Confirm(int value){
        if(value == constant){
            return true;
        }else return false;
    }

    //Create a method is magic column
    private boolean isMagicColumns() {
        int somme=0;
        for(int a=0; a<getSize();a++) {
            for (int i = 0; i < getSize(); i++) {
                somme+= getValue(i,a);
            }
        }
        return Confirm(somme/3);
    }

    //create a method is magic Rows.
    private boolean isMagicRows() {
        int somme=0;
        for(int a=0; a<getSize();a++) {
            for (int i = 0; i < getSize(); i++) {
                somme+= getValue(a,i);
            }
        }
        return Confirm(somme/3);
    }

    private boolean isMagicDiagonals() {
        int somme = 0;
        int somme2 = 0;

        for (int i = 0; i < getSize(); i++) {
            somme += getValue(i, i);
            somme2 += getValue(i, getSize() - i - 1);
        }
        return Confirm(somme) && Confirm(somme2);
    }

    //Donne la raison pourquoi isnotMagic
    public String whyNotMagic() {
        String Magic_verification = "";
        if (isMagic()) {
            Magic_verification += "Magic";
        }
        if (!isMagicDiagonals()) {
            Magic_verification += "Not MagicDiagonals ";
        }
        if(!isMagicColumns()){
            Magic_verification+= "Not MagicColumn ";
        }
        if(!isMagicRows()){
            Magic_verification+= "Not MagicRow ";
        }
        return Magic_verification;
    }

    //représentation String() de l'objet
    public String toString() {
        String sortie = "", space = "\n";
        for (int i = 0; i < getSize(); i++) {
            for (int j = 0; j < getSize(); j++) {
                sortie += getValue(i, j) + "    ";
            }
            sortie += space;
        }
        return sortie;
    }
}
