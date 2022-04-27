import java.util.LinkedList;

public class ListOfGamesGenerator {


   /**
	* generates all different games for the specified
	* parameters. Each game is recorded only once.
	* once a game is finished, it is not extended further
	* @param lines
    *  the number of lines in the game
    * @param columns
    *  the number of columns in the game
    * ``@param sizeWin
    *  the number of cells that must be aligned to win.
    * @return
    * a list of lists of game instances, ordered by levels
  	*/
	public static LinkedList<LinkedList<TicTacToeGame>> generateAllGames(int lines, int columns, int winLength){

		//variable which contains the LinkedList of TiTactoeGame and another which contains a List of the list of tictatoegame
		LinkedList<TicTacToeGame> first = new LinkedList();
		LinkedList<LinkedList<TicTacToeGame>> second = new LinkedList<LinkedList<TicTacToeGame>>();
		TicTacToeGame game = new TicTacToeGame(lines, columns,winLength);

		//the variable clone will clone List first because If List first is cleared List second is null, that's why we have the clone
		LinkedList<TicTacToeGame> clone= new LinkedList();
		boolean args=true;

		//add the game to the List first , clone it and put it in second List and clear List first.
		first.add(game);
		clone= (LinkedList<TicTacToeGame>) first.clone();
		second.add(clone);
		first.clear();

		while(args){

			//This first loop is to get access to the last clone_first List in List second / Only happen once
			for(int d=0;d<1;d++){
				LinkedList<TicTacToeGame> h=second.getLast();

				//This second loop is to get access to every TictacToeGame element inside clone_fist List
				for(int z=0;z<h.size();z++){
					TicTacToeGame k=h.get(z);

					//This third loop is create a multitude of TicTactoeGame object base on each TictacToeGame element inside clone_fist List
					for (int i = 0; i < (columns * lines) && k.getGameState()==GameState.PLAYING ; i++) {
						if (k.valueAt(i)==CellValue.EMPTY) {
							TicTacToeGame newwin = new TicTacToeGame(k, i);

							//Verifies that none of the TicTactoeGame object create arent the same
							if(!first.contains(newwin)) first.add(newwin);
						}
					}
				}
			}

			//Create another clone of first for reason mention previously.
			LinkedList<TicTacToeGame> clone1= (LinkedList<TicTacToeGame>) first.clone();

			//As long as first_clone1 isn't empty first_clone1 will be added to second, else the first while loop ends.
			if (clone1.isEmpty() == false){
				second.add(clone1);
				first.clear();
			} else args=false;
		} return second;
	}
}