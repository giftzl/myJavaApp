package algorithum;

import java.util.Arrays;

public class MergeSortedArray {

	public static void main(String[] args) {
		int[] ary1 = {1,2,3,0,0,0};
		int[] ary2 = {2,4,5};
		
	    merge(ary1, 3, ary2, 3);
	    
	    System.out.println(Arrays.toString(ary1));
		
	}
	
	public static void insertSort(int[] a) {
		
		for(int i = 1; i< a.length; i++) {
			int temp = a[i];
			int j = i-1;
			for( ; j>0 && a[j] > temp; j--) {
				a[j++] = a[j];
			}
			a[j+1] = temp;
		}

	}
	
	public static void merge(int A[], int m, int B[], int n) {
	    int i=m-1, j=n-1, k=m+n-1;
	    while (i>-1 && j>-1) 
	    	A[k--]= (A[i]>B[j]) ? A[i--] : B[j--];
	    while (j>-1)        
	    	A[k--]=B[j--];
	}
}
