import java.io.Console;
import java.io.IOException;



//classe qui realise l'interface Player
public class HumanPlayer implements Player {

    //verifie si le jeu est jouable

        public void play(TicTacToeGame game) {

            if (game.getGameState() == GameState.PLAYING) {
                System.out.println("Player 1's turn.");
                System.out.println(game.toString());

                if (game.getLevel() % 2 == 0) {
                    System.out.println("X to play: ");
                } else {
                    System.out.println("O to play: ");
                }
                boolean hasPlayed = false; 
                
                // demande a l'humain de selectionner un index
               while(! hasPlayed) {
                    Console console = System.console();
                    console = System.console();
                    String stringToPlay = console.readLine();
                    int toPlay = Integer.parseInt(stringToPlay) + 1;
                    if (toPlay < (game.lines * game.columns) + 1 && game.valueAt(toPlay - 1) == CellValue.EMPTY && 0 < toPlay) {
                        game.play(toPlay - 1);
                        hasPlayed = true;
                    } else if (toPlay >= 9){
                        //si l'index est deja pris
                        System.out.println("This cell has already been played");
                    }
               }
            }
            else {
                System.out.println("ERROR: The game can not be played");
            }
        }
    }
