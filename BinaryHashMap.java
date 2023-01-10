import java.util.LinkedList;
import java.util.Stack;

public class BinaryHashMap {
    LinkedList<Integer>[] arr;

    public BinaryHashMap() {
        this.arr = (LinkedList<Integer>[]) new LinkedList<?>[2];
        this.arr[0] = new LinkedList<Integer>();
        this.arr[1] = new LinkedList<Integer>();
    }

    public int hashValue(int x) {
        return x % 2;
    }

    public void insert(int k) {
        this.arr[hashValue(k)].addLast(k);
    }

    public boolean search(int k) {
        boolean flag = false;
        int key = hashValue(k);
        Stack<Integer> s = new Stack<Integer>();
        while (!this.arr[key].isEmpty() && !flag) {
            int temp = this.arr[key].getFirst();
            if (temp == k) {
                flag = true;
            } else {
                s.push(this.arr[key].removeFirst());
            }
        }
        while (!s.isEmpty()) {
            this.arr[key].addFirst(s.pop());
        }
        return flag;
    }

    public static void main(String[] args) {
        BinaryHashMap b = new BinaryHashMap();
        b.insert(10);
        b.insert(11);
        b.insert(12);
        b.insert(13);
        b.insert(14);
        b.insert(15);
        b.insert(16);
        b.insert(17);
        b.insert(18);
        b.insert(19);
        b.insert(20);
    }
}
