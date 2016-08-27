package practice.dev.algo;

/***
 * MergeSort
 * @author dev
 *
 */
public class MergeByDev {
	
	int[] src;
	int length;
	int[] temp;
	
	public MergeByDev(int[] arrayIn) {
		this.src = arrayIn;
		this.length = arrayIn.length;
		this.temp = new int[arrayIn.length];
	}

	public static void main(String[] args) {
		int[] arrayIn = {45,78,23,90,42,567,90,0,9,4};
		MergeByDev m = new MergeByDev(arrayIn);
		m.sort();
		for(int i:arrayIn){
            System.out.print(i);
            System.out.print(" ");
        }
	}
	
	public void sort() {
		performSort(0, (length - 1));
	}

	private void performSort(int lowerIndex, int higherIndex) {
		if(lowerIndex < higherIndex) {
			int mid = (lowerIndex + ((higherIndex - lowerIndex) / 2));
			performSort(lowerIndex, mid);
			performSort((mid + 1), higherIndex);
			mergeParts(lowerIndex, mid, higherIndex);
		}
	}

	private void mergeParts(int lowerIndex, int mid, int higherIndex) {
		for(int i = lowerIndex; i <= higherIndex; i++) {
			temp[i] = src[i];
		}
		int i = lowerIndex, j = (mid + 1), k = lowerIndex;
		while(i <= mid && j <= higherIndex) {
			if(temp[i] < temp[j]) {
				src[k] = temp[i];
				i++;
			} else {
				src[k] = temp[j];
				j++;
			}
			k++;
		}
		while(i <= mid) {
			src[k] = temp[i];
			k++;
			i++;
		}
		while(j <= higherIndex) {
			src[k] = temp[j];
			k++;
			j++;
		}
	}
}