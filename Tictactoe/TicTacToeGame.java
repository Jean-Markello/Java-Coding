

/**
 * The class <b>TicTacToeGame</b> is the
 * class that implements the Tic Tac Toe Game.
 * It contains the grid and tracks its progress.
 * It automatically maintain the current state of
 * the game as players are making moves.
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */
public class TicTacToeGame {

// FINISH THE VARIABLE DECLARATION
	/**
	 * a cell_value, stored the cellValue that is expected next.
	 */
	private CellValue cellValue;
	/**
	 * The board of the game, stored as a one dimension array.
	 */
	private CellValue[] board;

	/**
	 * level records the number of rounds that have been
	 * played so far.
	 */
	private int level;

	/**
	 * gameState records the current state of the game.
	 */
	private GameState gameState;


	/**
	 * lines is the number of lines in the grid
	 */
	public final int lines;

	/**
	 * columns is the number of columns in the grid
	 */
	private final int columns;


	/**
	 * sizeWin is the number of cell of the same type
	 * that must be aligned to win the game
	 */
	public final int sizeWin;


	/**
	 * default constructor, for a game of 3x3, which must
	 * align 3 cells
	 */
	public TicTacToeGame(){

		this(3,3,3);

	}

	/**
	 * constructor allowing to specify the number of lines
	 * and the number of columns for the game. 3 cells must
	 * be aligned.
	 * @param lines
	 *  the number of lines in the game
	 * @param columns
	 *  the number of columns in the game
	 */
	public TicTacToeGame(int lines, int columns){

		this(lines, columns, 3);

	}

	/**
	 * constructor allowing to specify the number of lines
	 * and the number of columns for the game, as well as
	 * the number of cells that must be aligned to win.
	 * @param lines
	 *  the number of lines in the game
	 * @param columns
	 *  the number of columns in the game
	 * @param sizeWin
	 *  the number of cells that must be aligned to win.
	 */
	public TicTacToeGame(int lines, int columns, int sizeWin){

		this.lines = lines;
		this.columns = columns;
		this.sizeWin = sizeWin;
		board = new CellValue[lines*columns];
		for (int i = 0; i < lines*columns; i++) {
			board[i] = CellValue.EMPTY;
		}
		level = 0;
		gameState = GameState.PLAYING;

	}


	/**
	 * getter for the variable lines
	 * @return
	 * 	the value of lines
	 */
	public int getLines(){

		// YOUR CODE HERE
		return lines;

	}

	/**
	 * getter for the variable columns
	 * @return
	 * 	the value of columns
	 */
	public int getColumns(){

		// YOUR CODE HERE
		return columns;

	}

	/**
	 * getter for the variable level
	 * @return
	 * 	the value of level
	 */
	public int getLevel(){

		// YOUR CODE HERE
		return level;

	}

	/**
	 * getter for the variable sizeWin
	 * @return
	 * 	the value of sizeWin
	 */
	public int getSizeWin(){

		// YOUR CODE HERE 
		return sizeWin;
	}

	/**
	 * getter for the variable gameState
	 * @return
	 * 	the value of gameState
	 */
	public GameState getGameState(){

		// YOUR CODE HERE
		return gameState;

	}

	/**
	 * returns the cellValue that is expected next,
	 * in other word, which played (X or O) should
	 * play next.
	 * This method does not modify the state of the
	 * game.
	 * @return
	 *  the value of the enum CellValue corresponding
	 * to the next expected value.
	 */
	public CellValue nextCellValue(){

		// condition for deciding a players turn
		if (level%2==0) {
			cellValue=CellValue.X;
		} else if (level%2!=0) {
			cellValue=CellValue.O;
		}
		return cellValue;
	}

	/**
	 * returns the value  of the cell at
	 * index i.
	 * If the index is invalid, an error message is
	 * printed out. The behaviour is then unspecified
	 * @param i
	 *  the index of the cell in the array board
	 * @return
	 *  the value at index i in the variable board.
	 */
	public CellValue valueAt(int i) {

		// YOUR CODE HERE
		if(i<0 || i>9) {
			System.out.println("Error!");
		}
		return board[i];

	}


	/**
	 * This method is called when the next move has been
	 * decided by the next player. It receives the index
	 * of the cell to play as parameter.
	 * If the index is invalid, an error message is
	 * printed out. The behaviour is then unspecified
	 * If the chosen cell is not empty, an error message is
	 * printed out. The behaviour is then unspecified
	 * If the move is valide, the board is updated, as well
	 * as the state of the game.
	 * To faciliate testing, is is acceptable to keep playing
	 * after a game is already won. If that is the case, the
	 * a message should be printed out and the move recorded.
	 * the  winner of the game is the player who won first
	 * @param i
	 *  the index of the cell in the array board that has been
	 * selected by the next player
	 */
	public void play(int i) {

		// YOUR CODE HERE

		board[i]= nextCellValue();
		setGameState(i);
		level++;


	}


	/**
	 * A helper method which updates the gameState variable
	 * correctly after the cell at index i was just set in
	 * the method play(int i)
	 * The method assumes that prior to setting the cell
	 * at index i, the gameState variable was correctly set.
	 * it also assumes that it is only called if the game was
	 * not already finished when the cell at index i was played
	 * (i.e. the game was playing). Therefore, it only needs to
	 * check if playing at index i has concluded the game, and if
	 * set the oucome correctly
	 *
	 * @param i
	 *  the index of the cell in the array board that has just
	 * been set
	 */

	//method called by setgame to say who's the winner
	private void winner(int i ){
		if (board[i]==CellValue.X){
			System.out.println("result: XWIN");
			gameState=GameState.XWIN;
		}else if((board[i]==CellValue.O))  {
			System.out.println("Result: OWIN");
			gameState=GameState.OWIN;
		}
	}

	private void setGameState(int i){
		int s=0;
		int [] count= new int[board.length];

		//test for vertical and horizontal wins
		for (int z=0; z<board.length; z++){
			if(board[z]==CellValue.X){
				count[z]=z;
				System.out.println(z);
			}
		}

		int a=count[1]-count[0];
		int b=count[2]-count[0];
		int c=count[3]-count[0];
		for (int m=0; m< count.length; m++){
			if ((m+1)< count.length){
				if (count[m]+a==count[m+1]){
					s++;
				}
			}

		}
		if (s==sizeWin){
			winner(i);
		}


	}


	/**
	 * Returns a String representation of the game matching
	 * the example provided in the assignment's description
	 *
	 * @return
	 *  String representation of the game
	 */

	public String toString(){

		//create a copy of board
		String [] copy= new String[board.length];
		for (int i=0; i<copy.length; i++) {
			if (board[i]==CellValue.EMPTY){
				copy[i] = "   ";
			}else if (board[i]==CellValue.X){
				copy[i]=" X ";
			}else if (board[i]==CellValue.O) {
				copy[i] = " O ";
			}
		}

		//with the array copy, we can display the board
		String a,b,c,d;
		d="_______________";
		a= copy[0] + " | " + copy[1]+ " | " +copy[2];
		b= copy[3] + " | " + copy[4]+ " | " +copy[5];
		c= copy[6] + " | " + copy[7]+ " | " +copy[8];

		return a+ "\n" + d + "\n" + b + "\n" + d + "\n" + c;
		}

}