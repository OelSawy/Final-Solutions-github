class Link {

	public Object data;
	public Link next;

	public Link(Object o) {
		this.data = o;
		this.next = null;
	}

	public String toString() {
		return data.toString();
	}
}

class LinkList {
	private Link head;
	private Link last;

	public LinkList() {
		head = null;
	}

	public void insertFirst(Object o) {
		Link newLink = new Link(o);
		newLink.next = head;
		head = newLink;
		Link curr = this.head;
		while (curr.next != null) {
			curr = curr.next;
		}
		this.last = curr;
	}

	public Object removeFirst() {
		Object res = head.data;
		head = head.next;
		return res;
	}

	public Object getFirst() {
		return head.data;
	}

	public void insertLast(Object o) {
		Link newLink = new Link(o);
		if (head == null) {
			head = newLink;
			last = newLink;
			return;
		}
		Link current = head;
		while (current.next != null)
			current = current.next;
		current.next = newLink;
		last = newLink;
	}

	public Object removeLast() {
		if (head.next == null) {
			Object res = head.data;
			head = null;
			return res;
		}
		Link current = head;
		while (current.next.next != null)
			current = current.next;
		Object res = current.next.data;
		last = current;
		current.next = null;
		return res;
	}

	public Object getLast() {
		return last;
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

	public boolean isSortedAsc() {
		if (this.head == null) {
			return true;
		} else {
			Link curr = this.head;
			while (curr.next != null) {
				if (((Comparable) curr.data).compareTo(curr.next.data) > 0) {
					return false;
				}
				curr = curr.next;
			}
			return true;
		}
	}

	public int size() {
		int count = 0;
		Link curr = this.head;
		while (curr != null) {
			count++;
			curr = curr.next;
		}
		return count;
	}

	public void addOne() {
		if (this.head == null) {
			return;
		} else {
			if ((int) this.last.data < 9) {
				this.last.data = ((int) this.last.data) + 1;
				return;
			} else {
				addOne(this.head);
				if ((int) this.head.data == 10) {
					Link temp = new Link(1);
					this.head.data = 0;
					temp.next = this.head;
					this.head = temp;
				}
			}
		}
	}

	public void addOne(Link n) {
		if (n.next == this.last) {
			this.last.data = 0;
			n.data = ((int) n.data) + 1;
		} else {
			addOne(n.next);
			if ((int) n.next.data == 10) {
				n.next.data = 0;
				n.data = ((int) n.data) + 1;
			}
		}
	}

	public boolean putInPlace(Object input) {
		if (isSortedAsc()) {
			Link temp = new Link(input);
			Link curr = this.head;
			if (curr == null) {
				this.head = temp;
			} else {
				if ((int) input < (int) curr.data) {
					temp.next = curr;
					this.head = temp;
				} else {
					while (curr.next != null) {
						if ((int) input < (int) curr.next.data) {
							temp.next = curr.next;
							curr.next = temp;
							return true;
						}
						curr = curr.next;
					}
					curr.next = temp;
				}
			}
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		LinkList l = new LinkList();
		l.insertLast(2);
		l.insertLast(9);
		l.insertLast(9);
		l.insertLast(9);
		l.addOne();
		System.out.println(l.toString());
	}
}
