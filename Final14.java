import java.util.HashSet;

/* class Node {
    char content;
    Node next;

    Node(char c, Node tail) {
        content = c;
        next = tail;
    }
} */

class ListE {
    public Node first;
    public Node last;

    ListE() {
        first = null;
        last = null;
    }

    public String toString() {
        if (this.first == null) {
            return "[ ]";
        } else {
            Node curr = this.first;
            String str = "[";
            while (curr.next != null) {
                str += curr.content + " -> ";
                curr = curr.next;
            }
            str += curr.content + "]";
            return str;
        }
    }
}

public class Final14 {

    public static ListE inverseStringList(String s) {
        char[] chars = s.toCharArray();
        ListE list = new ListE();
        list.first = new Node(chars[0], null);
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < Character.getNumericValue(chars[i]); j++) {
                Node temp = new Node(chars[i], list.first);
                if (list.last == null) {
                    list.last = temp;
                }
                list.first = temp;
            }
        }
        return list;
    }

    public static int numberOfNodes(BTree t) {
        return numberOfNodes(t.root);
    }

    public static int numberOfNodes(Node n) {
        if (n == null) {
            return 0;
        } else {
            return 1 + numberOfNodes(n.left) + numberOfNodes(n.right);
        }
    }

    public static int numberOfSmallerNodes(BTree t, String value) {
        return numberOfSmallerNodes(value, t.root);
    }

    public static int numberOfSmallerNodes(String value, Node n) {
        if (n == null) {
            return -1;
        } else if (((String) n.data).compareTo(value) == 0) {
            return numberOfNodes(n.left);
        } else {
            return Math.max(numberOfSmallerNodes(value, n.left), numberOfSmallerNodes(value, n.right));
        }
    }

    public static void removeInRange(HashSet<Integer> h, int min, int max) {
        for (int i = min; i <= max; i++) {
            h.remove(i);
        }
    }

    public static void main(String[] args) {
        
    }
}