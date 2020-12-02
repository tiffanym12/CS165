
public class MyFunction implements TestingFunctions {

	@Override
	public int greatestCommonDivisor(int a, int b) {
		if (a == 0){
			return b;
		}
		return greatestCommonDivisor(b%a, a);
	}

	@Override
	public void reverseWindow(int[] arr, int index1, int index2) throws IndexOutOfBoundsException {
		index2--;
		if(index1 > index2) {
			int i = index1;
			index1 = index2;
			index2 = i;
		}
		if(index1 < 0 || index2 < 0 || index1 >= arr.length || index2 >= arr.length) {
			throw new IndexOutOfBoundsException();
		}
			int i;
			while(index1 < index2) {
				i = arr[index1];
				arr[index1] = arr[index2];
				arr[index2] = i;
				index1++;
				index2--;
			}

	}

}
