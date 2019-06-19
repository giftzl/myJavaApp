package algorithum;

/**
 * 
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where
 * "adjacent" cells are those horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 * 
 * Example:
 * 
 * board = [ ['A','B','C','E'], 
 * 			 ['S','F','C','S'], 
 *           ['A','D','E','E'] 
 *         ]
 * 
 * Given word = "ABCCED", return true. 
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 * 
 * @author vivianzhu
 *
 */
public class WordSearch {
	
	static boolean[][] visited;
	
	public static void main(String[] args) {
		
		char[][] board = {{'A','B','C','E'},
						  {'S','F','C','S'},
						  {'A','D','E','E'}};
		
		String[] strings  = {"SEE", "ABCCED", "ABCB"};
		for (String str : strings) {
			System.out.println( "The word '"+str+(exist(board, str)?"' exists":"' doesn't exist")+" in the board.");
		}
		
	
		
	}
	
	public static boolean exist(char[][] board, String word) {
		
		
		if(board == null)
			return false;
		
		visited =new boolean[board.length][board[0].length];
		
		for(int i = 0; i< board.length; i++)
			for(int j = 0; j< board[0].length; j++) {
				if(word.charAt(0) == board[i][j] && search(board,word,i,j,0))
					return true;
			}
		
		return false;

	}

	public static boolean search(char[][] board, String word, int row, int col, int index ) {
		
		if(word.length() == index)
			return true;	
		
		if(row >= board.length || row< 0 || col >=board[row].length || col<0 
				|| board[row][col] != word.charAt(index) ||  visited[row][col] )
			return false;
		
		visited[row][col] = true;
		if(search(board, word, row-1, col, index+1)
			|| search(board, word, row+1, col, index+1)
			|| search(board, word, row, col-1, index+1)
			|| search(board, word, row, col+1, index+1))
			return true;
		
		visited[row][col]=false;
		
		
		
		return false;
	}
}
