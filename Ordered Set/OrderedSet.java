import java.util.LinkedList;

public class OrderedSet {
    private BTree bst;
    private int count;

    public OrderedSet() {
        this.bst = new BTree();
        this.count = 0;
    }

    public void add(Comparable item) {
        if (bst.search(item) == null) {
            this.bst.add(item);
            count++;
        }
    }

    public boolean contains(Comparable item) {
        if (bst.search(item) == null) {
            return false;
        } else {
            return true;
        }
    }

    public int size() {
        return this.count;
    }

    public void remove(Comparable item) {
        bst.delete(item);
    }

    public LinkedList toList() {
        LinkedList output = new LinkedList();
        toList(this.bst.root, output);
        return output;
    }

    public void toList(Node n, LinkedList output) {
        if (n == null) {
            return;
        }

        toList(n.left, output);
        output.addLast(n.data);
        toList(n.right, output);
    }

    public static void main(String[] args) {
        OrderedSet s = new OrderedSet();
        s.add(20);
        s.add(15);
        s.add(25);
        s.add(12);
        s.add(18);
        s.add(22);
        s.add(29);
        System.out.println(s.toList().toString());
        System.out.println(s.size());
    }
}
