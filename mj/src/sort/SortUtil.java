package sort;

import util.ArrayUtils;

/**
 * 
 * 
 * @author vivianzhu
 *
 */
public class SortUtil {
	
	public static void main(String[] args) {
		
		int[] array= new int[]{11,10,33,42,12,34,5,23,6};
		ArrayUtils.printArray(array,"Before sortation:");
	

		SortUtil SortUtil = new SortUtil();
		
		SortUtil.bubbleSort(array);
		ArrayUtils.printArray(array,"Bubble Sort:");
		
		array= new int[]{11,10,33,42,12,34,5,23,6};
		SortUtil.insertSort(array);
		ArrayUtils.printArray(array,"Insert Sort:");
		
		array= new int[]{11,10,33,42,12,34,5,23,6};
		SortUtil.selectSort(array);
		ArrayUtils.printArray(array, "Select Sort:");
		
		array= new int[]{11,10,33,42,12,34,5,23,6};
		SortUtil.quickSort(array);
		ArrayUtils.printArray(array, "Quick Sort:");
		
		array= new int[]{11,10,33,42,12,34,5,23,6};
		SortUtil.mergeSort(array);
		ArrayUtils.printArray(array, "Merge Sort:");
		

	}
	
	private void mergeSort(int[] array) {
		sortArray(array, 0, array.length-1);
		
	}

	private void sortArray(int[] array, int start, int end) {
		if(start == end)
			return;
		
		int size = end - start + 1;
		int separator = 0;
		if(size % 2 == 0) {
			separator = start + size / 2 - 1;
		}else{
			separator = start + size / 2;
		}
		sortArray(array, start, separator);
		sortArray(array, separator+1, end);
		
		mergeArray(array, start, separator, end);
	}

	private void mergeArray(int[] array, int start, int separator, int end) {
		int totalSize = end - start + 1;
		int size1 = separator - start +1;
		int size2 = end - separator ;
		
		int[] ary1 = new int[size1];
		int[] ary2 = new int[size2];
		
		for(int i = 0; i< size1; i++) {
			ary1[i] =  array[start+i];
		}
		
		for(int i = 0; i< size2; i++){
			ary2[i] = array[separator+1 +i];
		}
		
		int mergeCount = 0;
		int index1 = 0;
		int index2 = 0;
		
		while(mergeCount < totalSize) {
			if(index1 == size1) {
				for(int j = index2; j<size2 ;j++) {
					array[start + mergeCount] = ary2[j];
					index2++;
					mergeCount++;
				}
			}else if(index2 == size2) {
				for(int k = index1; k<size1; k++) {
					array[start + mergeCount] = ary1[k];
					index1++;
					mergeCount++;
				}
			}else {
				int value1 = ary1[index1];
				int value2 = ary2[index2];
				
				if(value1 == value2) {
					array[start+mergeCount] = value1;
					array[start+ mergeCount +1] = value1;
					mergeCount++;
					index1++;
					index2++;
				}else if(value1 < value2) {
					array[start + mergeCount] = value1;
					mergeCount++;
					index1++;
					
				}else if(value1 > value2){
					array[start + mergeCount] = value2;
					mergeCount++;
					index2++;
				}
				
			}
		}
		
		
	}

	/**
	 * 交换排序
	 * bubble sort, 
	 * Time: O(n^2)
	 * Space: O(1)
	 * Steady
	 * 
	 * @param a 
	 */
	public void bubbleSort(int[] a) {
		
		for(int i = 0 ;i< a.length; i++) {
			for(int j=i+1; j< a.length; j++) {
				if(a[i] > a[j]) {
					int temp = a[j];
					 a[j]= a[i];
					 a[i]=temp;
				}
			}
		}
	}
	
	/**
	 * 直接插入排序
	 * insert sort: assume first n-1 element is sorted already. T
	 * hen insert n element in to correct position.
	 * 
	 * Time O(n^2)
	 * Space: O(1)
	 * steady
	 * 
	 * @param a
	 */
	public void insertSort(int[] a) {

		// begin from the second element, assure element ahead is already sorted.
		for(int i = 1; i<a.length; i++) {
			int insertVal = a[i];
			int j = i-1;
			for(; j>=0 && insertVal < a[j]; j--) {
				//move backward the sorted array
				a[j+1] = a[j];
			}
			a[j+1] = insertVal;
		}
	}
	
	/**
	 *
	 * 选择排序
	 * select sort: use first element as pivotkey, each time select smallest in rest n-1 elements
	 * 
	 * Given: 4,3,5,1,10
	 * 
	 * 1st: 1,3,5,4,10；
	 * 2nd: 1,3,5,4,10;
	 * 3rd: 1,3,4,5,10;
	 * 
	 *  * Time: O(n^2)
	 * Space: O(1)
	 * Steady
	 * 
	 * @param a
	 */
	public void selectSort(int[] a) {
		for (int i = 0; i < a.length-1; i++) {
			int pivotkey = a[i];
			int index = i;
			int min = a[i];
			for(int j = i+1; j < a.length-1; j++) {
				if(a[j+1] < min) {
					min = a[j+1];
					index = j+1;
				}
			}
			a[i]= a[index];
			a[index] = pivotkey;
		}
	}
	
	/**
	 * Quick Sort: 基本思想：选择一个基准元素,通常选择第一个元素或者最后一个元素
	 * 通过一趟扫描，将待排序列分成两部分,一部分比基准元素小,一部分大于等于基准元素,
	 * 此时基准元素在其排好序后的正确位置,然后再用同样的方法递归地排序划分的两部分。
	 * 
	 * Time: O(n*log2n)~ O(n^2) (n*log以2为底，n的对数)
	 * Space:O(log2n)~O(n) (n*log以2为底，n的对数)
	 * Un-Steady
	 * 
	 * @param array
	 */
	public void quickSort(int[] array) {
		
		_quickSort(array, 0, array.length-1);
	}
	
	private void _quickSort(int[] a, int low, int high) {
		if(low < high){
			int middle = getMiddle(a, low, high);
			_quickSort(a, low, middle-1 );
			_quickSort(a, middle+1, high);
		}
	}
	
	private int getMiddle(int[] a , int low, int high) {
		
		int pivot = a[low];  
		while(low < high) {
			while(low < high && a[high]>= pivot) {
				high--;
			}
			a[low]=a[high];
			
			while(low < high && a[low]<= pivot) {
				low++;
			}
			a[high] = a[low];
		}
		a[low] = pivot;
		return low;
	}
	
}
