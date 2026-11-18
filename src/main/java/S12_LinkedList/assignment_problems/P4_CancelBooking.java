import java.util.Scanner;

public class P4_CancelBooking {

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node removeFirst(Node head, String booking) {

        if (head == null)
            return null;

        if (head.data.equals(booking))
            return head.next;

        Node temp = head;

        while (temp.next != null &&
                !temp.next.data.equals(booking)) {
            temp = temp.next;
        }

        if (temp.next != null)
            temp.next = temp.next.next;
        else
            System.out.println(booking + " not found");

        return head;
    }

    static void printBookings(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
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

        String booking = sc.next();

        head = removeFirst(head, booking);
        printBookings(head);
    }
}
