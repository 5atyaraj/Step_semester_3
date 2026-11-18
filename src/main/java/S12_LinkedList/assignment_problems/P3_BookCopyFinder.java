import java.util.Scanner;

public class P3_BookCopyFinder {

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    static String find(Node head, String id) {
        int position = 1, first = -1, copies = 0;

        Node temp = head;

        while (temp != null) {
            if (temp.data.equals(id)) {
                if (first == -1)
                    first = position;

                copies++;
            }

            temp = temp.next;
            position++;
        }

        if (first == -1)
            return id + " not found";

        return id + " first at position " + first +
                ", copies: " + copies;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Node head = null, tail = null;

        for (int i = 0; i < n; i++) {
            Node newNode = new Node(sc.next());

            if (head == null)
                head = tail = newNode;
            else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        String id = sc.next();

        System.out.println(find(head, id));
    }
}
