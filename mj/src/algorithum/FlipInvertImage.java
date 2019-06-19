package algorithum;

public class FlipInvertImage {
	
	public static void main(String[] args) {
		
		int[] ary = {1,1,0};
		
//		System.out.println(Integer.reverse(ary[0]));
//		System.out.println(5/2);
		
		int[][]	A = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
		flipInventImg(A);
		
	}

	private static int[][] flipInventImg(int[][] a) {
		
		int len = a[0].length;
		
		for (int[] row : a) {
			int temp;
			for(int i=0; i<(len+1)/2; ++i) {
				temp = row[i]^1;
				row[i] = row[len-1-i]^1;
				row[len-1-i] = temp;
			}
		}
		return a;
	}

}
