class Link {
    public Object data;
    public Link next;

    Link(Object o) {
        this.data = o;
        this.next = null;
    }

    public String toString() {
        return data.toString();
    }
}

public class SSL {
    private Link head;

    public SSL(Link head) {
        this.head = head;
    }

    public static void josephusProblem(int m, int n) {
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            q.add(i);
        }
        int i = 1;
        while (!q.isEmpty()) {
            while (i < m) {
                q.add(q.remove());
                i++;
            }
            i = 1;
            System.out.print(q.remove() + " ");
        }
    }

    public void insert(Object o) {
        if (this.head == null) {
            this.head = new Link(o);
        } else {
            Link curr = this.head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = new Link(o);
        }
    }

    public SSL evenOdd() {
        if (head == null || head.next == null)
            return null;
        Link curr = head;
        Link ret = head.next;
        SSL retList = new SSL(ret);
        while (curr != null && ret != null) {
            curr.next = ret.next;
            curr = curr.next;
            if (curr != null) {
                ret.next = curr.next;
                ret = curr.next;
            }
        }
        return retList;
    }

    public String toString() {
        if (head == null)
            return "[ ]";
        String res = "[ " + head.data;
        Link current = head.next;
        while (current != null) {
            res += ", " + current.data;
            current = current.next;
        }
        res += " ]";
        return res;
    }

    public static void main(String[] args) {
        SSL s = new SSL(null);
        s.insert(1);
        s.insert(2);
        s.insert(3);
        s.insert(4);
        s.insert(5);

        System.out.println(s.evenOdd().toString());
    }
}
