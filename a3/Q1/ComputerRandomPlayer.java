import java.util.Random;

//classe qui realise l'interface Player
public class ComputerRandomPlayer implements Player{

    //verifie si le jeu est jouable
    //si il est jouable, le programme selectionne un CellValue qui est vide
    public void play(TicTacToeGame game) {
        if (game.getGameState() == GameState.PLAYING) {
            System.out.println("Player 2's turn.");
            boolean hasPlayed = false;
            while (!hasPlayed) {
                Random randomIndex = new Random();
                int indexToPlay = randomIndex.nextInt(game.lines * game.columns);

                //si le CellValue est vide, on peut jouer et on rend la var hasPlayed a true
                if (game.valueAt(indexToPlay) == CellValue.EMPTY) {
                    game.play(indexToPlay);
                    hasPlayed = true;
                }
            }
        }
        //message si le cellvalue est remplie
        else System.out.println("This cell has already been played.");
    }
}
