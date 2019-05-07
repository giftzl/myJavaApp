package algorithum;

import util.ArrayUtils;

/**
 * 
 * 
 * You are given an n x n 2D matrix representing an image.
 * 
 * Rotate the image by 90 degrees (clockwise).
 * 
 * Note:
 * 
 * You have to rotate the image in-place, which means you have to modify the
 * input 2D matrix directly. DO NOT allocate another 2D matrix and do the
 * rotation.
 * 
 * Example 1:
 * 
 * Given input matrix = [ [1,2,3], 
 * 						  [4,5,6], 
 * 						  [7,8,9] ],
 * 
 * rotate the input matrix in-place such that it becomes:
 * 
 *  [ [7,4,1], 
 *    [8,5,2],  
 *    [9,6,3] ]
 *    
 */
public class RotateImage {
	
	public static void main(String[] args) {
		
		int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};		
		ArrayUtils.printMatrix(matrix,"Input array:");
		
		clockwiseRotate(matrix);
		ArrayUtils.printMatrix(matrix,"Rotate array:");
		
	}

	/**
	 * basic thought:
	 * 
	 * 1. transpose (行列互转)
	 
        1  2  3        1  4  7 
		4  5  6   =>   2  5  8
		7  8  9        3  6  9
	 
	 * 2. horizontal flip.
	  
	    1  4  7        7  4  1
		2  5  8   =>   8  5  2
		3  6  9        9  6  3
	 *   
	 * 
	 * @param matrix
	 */
	private static void clockwiseRotate(int[][] matrix) {
		
		//transpose
		for(int i = 0 ;i < matrix.length; i++)
			for(int j = i; j< matrix[0].length; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		//horizontal flip
		for(int i = 0; i<matrix.length; i++)
			for(int j = 0; j< matrix.length/2; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][matrix.length-1-j];
				matrix[i][matrix.length-1-j] = temp;
			}
	}
}
