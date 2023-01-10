class Node {
    Comparable obj1;
    Comparable obj2;
    Node nodeRef1;
    Node nodeRef2;

    Node(Comparable obj1, Comparable obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }
}

public class MultiList {
    private Node nodeHead1;
    private Node nodeHead2;

    public MultiList() {

    }

    public void insert(Comparable o1, Comparable o2) {
        Node temp = new Node(o1, o2);
        if (isEmpty()) {
            nodeHead1 = temp;
            nodeHead2 = temp;
        } else {
            if (o1.compareTo(nodeHead1.obj1) < 0) {
                temp.nodeRef1 = nodeHead1;
                nodeHead1 = temp;
            } else {
                Node curr = nodeHead1;
                while (curr.nodeRef1 != null) {
                    if (((String) o1).compareTo((String) curr.nodeRef1.obj1) <= 0) {
                        temp.nodeRef1 = curr.nodeRef1;
                        curr.nodeRef1 = temp;
                        break;
                    }
                    curr = curr.nodeRef1;
                }
                if (((String) o1).compareTo((String) curr.obj1) > 0) {
                    curr.nodeRef1 = temp;
                }
            }

            if (o2.compareTo(nodeHead2.obj2) < 0) {
                temp.nodeRef2 = nodeHead2;
                nodeHead2 = temp;
            } else {
                Node curr = nodeHead2;
                while (curr.nodeRef2 != null) {
                    if (o2.compareTo(curr.nodeRef2.obj2) <= 0) {
                        temp.nodeRef2 = curr.nodeRef2;
                        curr.nodeRef2 = temp;
                        break;
                    }
                    curr = curr.nodeRef2;
                }
                if (o2.compareTo(curr.obj2) > 0) {
                    curr.nodeRef2 = temp;
                }
            }
        }
    }

    public boolean isEmpty() {
        return this.nodeHead1 == null;
    }

    public void displayNode1() {
        Node curr = nodeHead1;
        while (curr != null) {
            System.out.print(curr.obj1 + " ");
            curr = curr.nodeRef1;
        }
        System.out.println();
    }

    public void displayNode2() {
        Node curr = nodeHead2;
        while (curr != null) {
            System.out.print(curr.obj2 + " ");
            curr = curr.nodeRef2;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MultiList m = new MultiList();
        m.insert("Ahmed N.", 2532648);
        m.insert("Mona L.", 2531910);
        m.insert("Jameel O.", 5325500);
        m.insert("Walid Z.", 4317756);

        m.displayNode1();
        m.displayNode2();
    }
}