import java.util.Stack;

public class Final17 {

    public static void convert(LinkListEdited l) {
        int zerosCount = 0;
        Stack<Integer> s = new Stack<Integer>();
        while (!l.isEmpty()) {
            int temp = (int) l.removeFirst().data;
            if (temp == 0) {
                zerosCount++;
            } else if (!l.isEmpty() && temp == (int) l.getFirst().data) {
                s.push(temp * 2);
                l.removeFirst();
                zerosCount++;
            } else {
                s.push(temp);
            }
        }
        while (!s.isEmpty()) {
            l.insertFirst(s.pop());
        }
        for (int i = zerosCount; i > 0; i--) {
            l.insertLast(0);
        }
    }

    public static void main(String[] args) {
        LinkListEdited l = new LinkListEdited();
        l.insertLast(0);
        l.insertLast(2);
        l.insertLast(2);
        l.insertLast(2);
        l.insertLast(0);
        l.insertLast(6);
        l.insertLast(6);
        l.insertLast(0);
        l.insertLast(0);
        l.insertLast(8);
        convert(l);
        System.out.println(l.toString());
    }
}
