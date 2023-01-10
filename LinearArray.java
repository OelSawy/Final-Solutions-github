public class LinearArray {

	int itemCount;
	int[] array;

	public LinearArray(int maxSize) {
		itemCount = 0;
		array = new int[maxSize];
	}

	public void insertLast(int x) {
		if (itemCount < array.length)
			array[itemCount++] = x;
		else
			System.out.print("Array is Full");
	}

	public void displayArray() {

		System.out.print("Array: ");
		for (int i = 0; i < itemCount; i++)
			System.out.print(array[i] + " ");
		System.out.println();
	}
}
