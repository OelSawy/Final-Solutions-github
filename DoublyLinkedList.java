import java.util.Stack;

class Link {
	public Object data;
	public Link next;
	public Link previous;

	public Link(Object o) {
		data = o;
	}

	public String toString() {
		return data.toString();
	}
}

class DoublyLinkedList {
	private Link first; // reference to first link on list
	private Link last; // reference to first link on list

	public DoublyLinkedList() {
		first = null;
		last = null;
	}

	public boolean isEmpty() {
		return (first == null);
	}

	public void insertFirst(Object d) {
		Link newLink = new Link(d);
		if (isEmpty()) {
			last = newLink;
		} else {
			first.previous = newLink;
		}
		newLink.next = first;
		first = newLink;
	}

	public void insertLast(Object d) {
		Link newLink = new Link(d);
		if (isEmpty())
			first = newLink;
		else {
			last.next = newLink;
			newLink.previous = last;
		}
		last = newLink;
	}

	public Object removeFirst() {
		Object temp = first.data;
		if (first.next == null)
			last = null;
		else
			first.next.previous = null;
		first = first.next;
		return temp;
	}

	public Object removeLast() {
		Object temp = last.data;
		if (first.next == null)
			first = null;
		else
			last.previous.next = null;
		last = last.previous;
		return temp;
	}

	public Object getFirst() {
		return first.data;
	}

	public Object getLast() {
		return last.data;
	}

	public void displayForward() {
		System.out.print("[ ");
		Link current = first;
		while (current != null) {
			System.out.print(current + " ");
			current = current.next;
		}
		System.out.println("]");
	}

	public void displayBackward() {
		System.out.print("[ ");
		Link current = last;
		while (current != null) {
			System.out.print(current + " ");
			current = current.previous;
		}
		System.out.println("]");
	}

	public int count() {
		int count = 1;
		Link curr = this.first;
		while (curr.next != null) {
			count++;
			curr = curr.next;
		}
		return count;
	}

	public static void main(String[] args) {
		DoublyLinkedList l = new DoublyLinkedList();
		l.insertFirst(1);
		l.insertFirst(2);
		l.insertFirst(3);
		l.insertFirst(4);
		l.insertFirst(5);
		// l.reveerse();
		l.displayForward();
	}
}