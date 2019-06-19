package algorithum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SprialMatrix {

	public static void main(String[] args) {
		
		int[][] matrix = {{1,2,3,4},
						  {5,6,7,8},
						  {9,10,11,12},
						  {13,14,15,16}};
		
		List<Integer> rs = printOutMatrixInspiralOrder(matrix);
		System.out.println(Arrays.toString(rs.toArray(new Integer[rs.size()])));
	

		int[][] matrx= generateMatrixInspiralOrder(3);
		for (int[] is : matrx) {
			System.out.println(Arrays.toString(is));
		}
		
	}

	private static int[][] generateMatrixInspiralOrder(int n) {
		
		int top =0;
		int left =0;
		int right = n-1;
		int bottom = n-1;
		
		int count = 1;
		
		int[][] matrix= new int[n][n];
		
		while(top<=bottom && left<=right) {
			for(int i = left; i<= right; i++)
				matrix[top][i] = count++;
			top++;
			
			for(int i = top; i<=bottom; i++)
				matrix[i][right] = count++;
			right--;
			
			for(int i = right; i>=left; i--)
				matrix[bottom][i] = count++;
			bottom--;
			
			for(int i= bottom; i>=top; i--) 
				matrix[i][left] = count++;
			left++;
			
		}
		
		return matrix;
	}

	public static List<Integer> printOutMatrixInspiralOrder(int[][] matrix) {
		 List<Integer> rs = new ArrayList<Integer>();
	        
	        if(matrix.length == 0 || matrix[0].length == 0)
	            return rs;
	        
	        int top = 0;
	        int left = 0;
	        int bottom = matrix.length-1;
	        int right = matrix[0].length-1;
	        
	        while(true){
	            for(int i = left; i<=right;i++)
	                rs.add(matrix[top][i]);
	            top++;
	            if(top > bottom || left> right) break;
	            
	            for(int i= top;i<=bottom; i++) 
	                rs.add(matrix[i][right]);
	            right--;
	            if(top > bottom || left> right) break;
	            
	            for(int i= right; i>=left; i--)
	                rs.add(matrix[bottom][i]);
	            bottom--;
	            if(top > bottom || left> right) break;
	            
	            for(int i=bottom; i>=top; i--)
	                rs.add(matrix[i][left]);
	            left++;
	             if(top > bottom || left> right) break;
	            
	        }
	        return  rs;
	}
}
