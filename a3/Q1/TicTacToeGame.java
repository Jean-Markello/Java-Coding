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

	/**
	 * The board of the game, stored as a single array.
	 */
	 private CellValue[] board;
 
 
	/**
	 * level records the number of rounds that have been
	 * played so far. Starts at 0.
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
	 public final int columns;
 
 
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
		 for(int i = 0; i < lines*columns ; i ++) {
			 board[i] = CellValue.EMPTY;
		 }
		 level = 0;
		 gameState = GameState.PLAYING;
	 }
 
	/**
	 * getter for the variable level
	 * @return
	 * 	the value of level
	 */
	 public int getLevel(){
		 return level;
	 }
 
 
	/**
	 * getter for the variable gameState
	 * @return
	 * 	the value of gameState
	 */
	 public GameState getGameState(){
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
		 return (level%2 == 0) ? CellValue.X : CellValue.O;
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
 
		 if(i < 0 || i >= lines*columns){
			 throw new IllegalArgumentException("Illegal position: " + i);
		 }
 
		 return board[i];
	 }
 
	/**
	 * This method is call by the next player to play
	 * at the cell  at index i.
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
 
		 if(i < 0 || i >= lines*columns){
			 throw new IllegalArgumentException("Illegal position: " + i);
		 }
		 if(board[i] != CellValue.EMPTY) {
			 throw new IllegalArgumentException("CellValue not empty: " + i + " in game " + toString());			
		 }
 
		 board[i] = nextCellValue();
		 level++;
		 if(gameState != GameState.PLAYING) {
			 System.out.println("hum, extending a finished game... keeping original winner");
		 } else {
			 setGameState(i);
		 }
	 
	 }
 
 
	/**
	 * A helper method which updates the gameState variable
	 * correctly after the cell at index i was just set.
	 * The method assumes that prior to setting the cell
	 * at index i, the gameState variable was correctly set.
	 * it also assumes that it is only called if the game was
	 * not already finished when the cell at index i was played
	 * (the the game was playing). Therefore, it only needs to 
	 * check if playing at index i has concluded the game
	 * 
		* @param i
	 *  the index of the cell in the array board that has just 
	 * been set
	   */
 
 
	 private void setGameState(int index){
 
		 int left = Math.min(sizeWin-1,index%columns);
		 int right= Math.min(sizeWin-1,columns - (index%columns +1));
		 if( (countConsecutive(index-1, left,-1,board[index]) +
				 countConsecutive(index+1, right,1,board[index]))
			 >= sizeWin-1 ) {			
			 setGameState(board[index]);
			 return;
		 }
 
 
 
		 int up 	= Math.min(sizeWin-1,index/columns);
		 int down= Math.min(sizeWin-1, lines - (index/columns +1));
		 if( (countConsecutive(index-columns, up,-columns,board[index]) +
				 countConsecutive(index+columns, down,columns,board[index]))
			 >= sizeWin-1 ) {			
			 setGameState(board[index]);
			 return;
		 }
 
		 int upLeft = Math.min(up, left); 
		 int downRight= Math.min(down, right); 
		 if( (countConsecutive(index-(columns+1), upLeft,-(columns+1),board[index]) +
				 countConsecutive(index+(columns+1), downRight,columns+1,board[index]))
			 >= sizeWin-1 ) {			
			 setGameState(board[index]);
			 return;
		 }
 
		 int upRight= Math.min(up, right); 
		 int downLeft = Math.min(down, left); 
		 if( (countConsecutive(index-(columns-1), upRight,-(columns-1),board[index]) +
				 countConsecutive(index+(columns-1), downLeft,columns-1,board[index]))
			 >= sizeWin-1 ) {			
			 setGameState(board[index]);
			 return;
		 }
 
 
		 if (level == lines*columns) {
			 gameState = GameState.DRAW;
		 } else {
			 gameState = GameState.PLAYING;			
		 }
 
	 }
 
 
	 private int countConsecutive(int startingPosition, int numberOfSteps, 
		 int stepGap, CellValue value){
 
		 int result= 0;
		 for(int i = 0; i < numberOfSteps;i++){
			 if(board[startingPosition + i*stepGap] != value)
				 break;
			 result++;
		 }
		 return result;
 
	 }
 
 
	 private void setGameState(CellValue value){
		 switch(value){
			 case X:
				 gameState = GameState.XWIN;
				 break;
			 case O:
				 gameState = GameState.OWIN;
				 break;
			 default:
				 throw new IllegalArgumentException("cannot set Game State to value " + value);
		 }
	 }
 
 
 
	 // see https://piazza.com/class/k4t0hxdmr2p5pq?cid=145
	 public final String NEW_LINE = System.getProperty("line.separator");
 
	/**
	 * Returns a String representation of the game matching
	 * the example provided in the assignment's description
	 * 
		* @return
	 *  String representation of the game
	   */
 
	 public String toString(){
		 String res = "";
		 for(int i = 0; i < lines ; i++){
			 if(i>0) {
				 for(int j = 0; j < 4*columns - 1; j++){
					 res+="-";
				 }
				 res+= Utils.NEW_LINE;
			 }
			 for(int j = 0; j < columns ; j++){
				 switch(board[i*columns + j]){
					 case X:
						 res+= " X ";
						 break;
					 case O:
						 res+= " O ";
						 break;
					 default:
						 res+=  "   ";
				 }
				 if(j<columns - 1){
					 res += "|";
				 } else{
					 res += Utils.NEW_LINE;
				 }
			 }
		 }
		 return res ;
		 
	 }
 
 }