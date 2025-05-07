package linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

    public Node copyRandomList(Node head) {
        Map<Node, Node> hm = new HashMap<>();
        Node curr = head;
        Node head1 = null;
        Node curr1 = null;
        while (curr != null) {
            if (head1 == null) {
                head1 = new Node(curr.val);
                curr1 = head1;
                hm.put(curr, curr1);
            } else {
                curr1.next = new Node(curr.val);
                curr1 = curr1.next;
                hm.put(curr, curr1);
            }
            curr = curr.next;

        }
        curr1 = head1;
        curr = head;
        while (curr != null) {
            curr1.random = hm.get(curr.random);
            curr = curr.next;
            curr1 = curr1.next;
        }
        return head;

    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {
        CopyListWithRandomPointer obj = new CopyListWithRandomPointer();
        Node head = obj.new Node(1);
        head.next = obj.new Node(2);
        head.next.random = head;
        head.random = head.next;

        Node copiedList = obj.copyRandomList(head);

        // Print the copied list
        Node curr = copiedList;
        while (curr != null) {
            System.out.println("Value: " + curr.val + ", Random: " + (curr.random != null ? curr.random.val : "null"));
            curr = curr.next;
        }

    }
}
