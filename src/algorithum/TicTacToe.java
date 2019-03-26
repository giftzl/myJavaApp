package algorithum;

/**
 * Design a Tic-tac-toe game that is played between two players on a n x n grid.
 * 
 * You may assume the following rules:
 * 
 * A move is guaranteed to be valid and is placed on an empty block. Once a
 * winning condition is reached, no more moves is allowed. A player who succeeds
 * in placing n of their marks in a horizontal, vertical, or diagonal row wins
 * the game. Follow up: Could you do better than O(n2) per move() operation?
 * 
 * 
 */
public class TicTacToe {
	
	private int[] columns;
	private int[] rows;
	private int diagonal;
	private int antiDiagonal;
	private int n;

	/** Initialize your data structure here. */
	
	public TicTacToe(int n) {
		
		columns = new int[n];
		rows = new int[n];
		diagonal = 0;
		antiDiagonal = 0;
		this.n = n;
	}

	/**
	 * 
	 * Player {player} makes a move at ({row}, {col}).
	 * 
	 * @param row    The row of the board.
	 * @param col    The column of the board.
	 * @param player The player, can be either 1 or 2.
	 * 
	 * @return The current winning condition, can be either:
	 * 			 0: No one wins. 
	 * 			 1: Player 1 wins. 
	 * 			 2: Player 2 wins.
	 * 
	 */
	public int move(int row, int col, int player) {
		
		// place the player, identify which player; player 1 as 1, player 2 as -1;
		int number = player == 1 ? 1 : -1; 
		
		// save the value to row, col, diag, antiDiag
		rows[row] += number; 
		columns[col] += number;
		if (row == col) {
			diagonal += number;
		}
		if (row == n - 1 - col) {
			antiDiagonal += number;
		}
		
		 //TODO:  TicTacToe - winning condition
		if (Math.abs(rows[row]) == n || Math.abs(columns[col]) == n ||
				Math.abs(diagonal) == n || Math.abs(antiDiagonal) == n)
			return player;
		
		return 0;
	}
	
	public static void main(String[] args) {
		
		  TicTacToe obj = new TicTacToe(3); 
		  obj.move(1,2,-1);
		  obj.move(1, 1, -1);
		  int param_1= obj.move(1, 0, -1);
		  System.out.println("Player "+(param_1==1?"1":"2")+" WIN the game!!!");
		  
		  
		
	}
}

