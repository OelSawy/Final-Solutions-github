public class Heap {
    private int[] arr;
    private int maxSize;
    private int count = 0;

    public Heap(int maxSize) {
        this.maxSize = maxSize + 1;
        this.arr = new int[this.maxSize + 1];
    }

    public void insert(int input) {
        if (isEmpty()) {
            count++;
            arr[1] = input;
            return;
        } else if (isFull()) {
            System.out.println("No free spaces");
            return;
        } else {
            int position = ++count;
            arr[position] = input;
            int temp;
            // ? parent at i/2
            while (input < arr[position / 2]) {
                arr[position] = arr[position / 2];
                position /= 2;
            }
            arr[position] = input;
        }
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public boolean isFull() {
        return this.count == this.maxSize - 1;
    }

    public String toString() {
        String str = "[ ";
        for (int i = 0; i < count + 1; i++) {
            str += arr[i] + ", ";
        }
        str += "]";
        return str;
    }

    public static void main(String[] args) {
        Heap h = new Heap(7);
        h.insert(7);
        h.insert(10);
        h.insert(12);
        h.insert(17);
        h.insert(6);
        h.insert(15);
        h.insert(5);
        System.out.println(h.toString());
    }
}
