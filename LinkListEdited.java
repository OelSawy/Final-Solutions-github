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

public class LinkListEdited {
    private Link head;

    public LinkListEdited() {
        head = null;
    }

    public void insertFirst(Object o) {
        Link newLink = new Link(o);
        newLink.next = head;
        head = newLink;
    }

    public Link removeFirst() {
        Link res = head;
        head = head.next;
        return res;
    }

    public Link getFirst() {
        return head;
    }

    public void insertLast(Object o) {
        Link newLink = new Link(o);
        if (head == null) {
            head = newLink;
            return;
        }
        Link current = head;
        while (current.next != null)
            current = current.next;
        current.next = newLink;
    }

    public Link removeLast() {
        if (head.next == null) {
            Link res = head;
            head = null;
            return res;
        }
        Link current = head;
        while (current.next.next != null)
            current = current.next;
        Link res = current.next;
        current.next = null;
        return res;
    }

    public Link getLast() {
        Link current = head;
        while (current.next != null)
            current = current.next;
        return current;
    }

    public boolean isEmpty() {
        return head == null;
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
}