package algorithum;

import java.util.Arrays;

public class BattleShipCount {

	public static void main(String[] args) {
		
		char[][] board = {{'X','.','.','X'},
						  {'.','.','.','.'},
						  {'.','.','.','X'}};
//		System.out.println(board.length);
		
		for (int i = 0; i < board.length; i++) {
			System.out.println(Arrays.toString(board[i]));
		}
		
		int count = countBattleShips(board);
		System.out.println("Battleship count is "+count);
	}

	/**
	 * Going over all cells, we can count only those that are the "first" cell of
	 * the battleship. First cell will be defined as the most top-left cell. We can
	 * check for first cells by only counting cells that do not have an 'X' to the
	 * left and do not have an 'X' above them.
	 * 
	 * @param board
	 * @return
	 */
	private static int countBattleShips(char[][] board) {
		
		int count = 0;
		int row = board.length;
		if (row == 0)
			return 0;
		int col = board[0].length;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (board[i][j] == '.')
					continue;
				if (i > 0 && board[i - 1][j] == 'X')
					continue;
				if (j > 0 && board[i][j - 1] == 'X')
					continue;
				count++;
			}
		}
		return count;
	}
}
