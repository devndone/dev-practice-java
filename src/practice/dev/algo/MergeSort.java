package practice.dev.algo;

public class MergeSort {

	private int[] source;
	private int[] temp;
	private int length;
	
	public static void main(String [] args) {
		int[] srcArray = {23,45,67,89,234,56,43,56,32,73,85};
		MergeSort ms = new MergeSort();
		ms.sort(srcArray);
		for(int i : srcArray) {
			System.out.println(i);
		}
	}
	
	public void sort(int [] source) {
		this.source = source;
		this.length = source.length;
		this.temp = new int[source.length];
		doMergeSort(0, this.length - 1);
	}
	
	private void doMergeSort(int lowerIndex, int higherIndex) {
		if(lowerIndex < higherIndex) {
			int middle = lowerIndex + (higherIndex - lowerIndex)/2;
			// Below step sorts the left side of the array
			doMergeSort(lowerIndex, middle);
			// Below step sorts the right side of the array
			doMergeSort(middle + 1, higherIndex);
			// Now merge both sides
			mergeParts(lowerIndex, middle, higherIndex);
		}
	}
	
	private void mergeParts(int lowerIndex, int middle, int higherIndex) {
		for(int i = lowerIndex; i <= higherIndex; i++) {
			temp[i] = source[i];
		}
		int i = lowerIndex;
		int j = middle+1;
		int k = i;
		while(i <= middle && j <= higherIndex) {
			if(temp[i] <= temp[j]) {
				source[k] = temp[i];
				i++;
			} else {
				source[k] = temp[j];
				j++;
			}
			k++;
		}
		while(i <= middle) {
			source[k] = temp[i];
			k++;
			i++;
		}
		while(j <= higherIndex) {
			source[k] = temp[j];
			k++;
			j++;
		}
	}
	
}

