
import java.io.Console;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class TicTacToe{

   /**
     * <b>main</b> of the application. Creates the instance of  TicTacToeGame 
     * and starts the game. If two parameters lines  and columns
     * are passed, they are used. If the paramters lines, columns
     * and win are passed, they are used.
     * Otherwise, a default value is used. Defaults values (3) are also
     * used if the paramters are too small (less than 2).
     * Here, we assume that the command lines arguments are indeed integers
     *
     * @param args
     *            command lines parameters
     */
     public static void main(String[] args) {

        StudentInfo.display();

        Console console = System.console();
        TicTacToeGame game;
        int lines, columns, win;
        lines = 3;
        columns = 3;
        win = 3;

        if (args.length >= 2) {
            lines = parseInt(args[0]);
            if(lines<2){
                System.out.println("Invalid argument, using default...");
                lines = 3;
            }
            columns = parseInt(args[1]);
            if(columns<2){
                System.out.println("Invalid argument, using default...");
                columns = 3;
            }
        }
        if (args.length >= 3){
            win = parseInt(args[2]);
            if(win<2){
                System.out.println("Invalid argument, using default...");
                win = 3;
            }
        } 
        if (args.length > 3){
            System.out.println("Too many arguments. Only the first 3 are used.");
        } 
        
        game = new TicTacToeGame(lines, columns,win);


        // YOUR CODE HERE
         int inputX, inputO;
         Scanner scanner = new Scanner(System.in);

        while (game.getGameState()==GameState.PLAYING) {

            //if its player X turn
            if(game.nextCellValue()==CellValue.X) {

                //conditions if user input is invalid
                while (true){
                    System.out.println(game.toString());
                    System.out.print("\nX to play: ");
                    inputX=scanner.nextInt();

                    if (inputX>=0 && inputX<=8){
                        if(game.valueAt(inputX) != CellValue.EMPTY){
                            System.out.println("This cell has already been played");
                        }else{
                            break;
                        }
                    } else if (inputX<0 || inputX>8) {
                        System.out.println("The value should be between 1 and 9");
                    }
                    //Once condition is met, the game can resume.
                } game.play(inputX);


            // if player O's turns
            } else if(game.nextCellValue()==CellValue.O) {
                while (true) {
                    System.out.println(game.toString());
                    System.out.print("\nO to play: ");
                    inputO = scanner.nextInt();

                    if (inputO>=0 && inputO<=8){
                        if(game.valueAt(inputO) != CellValue.EMPTY){
                            System.out.println("This cell has already been played");
                        }else{
                            break;
                        }
                    } else if (inputO<0 || inputO>8) {
                        System.out.println("The value should be between 1 and 9");
                    }
                }game.play(inputO);
            }

        } System.out.println(game.toString());

     }

   }