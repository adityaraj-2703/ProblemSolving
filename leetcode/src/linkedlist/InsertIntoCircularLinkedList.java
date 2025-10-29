package linkedlist;

public class InsertIntoCircularLinkedList {
    public Node insert(Node head, int insertVal) {
        if(head==null){
            head = new Node(insertVal);
            head.next = head;
            return head;
        }
        Node curr = head;
        while(curr.next!=head){
            if(curr.val<=insertVal && curr.next.val>=insertVal){
                Node temp = new Node(insertVal,curr.next);
                curr.next = temp;
                return head;
            }
            else if(curr.val>curr.next.val){
                if(insertVal>=curr.val || insertVal<=curr.next.val){
                    Node temp = new Node(insertVal,curr.next);
                    curr.next = temp;
                    return head;
                }
            }
            curr = curr.next;
        }
        Node newNode = new Node(insertVal,curr.next);
        curr.next = newNode;
        return head;
    }
    public static void main(String[] args) {
        InsertIntoCircularLinkedList i = new InsertIntoCircularLinkedList();
        Node head = new Node();
        head.val = 3;
        head.next = new Node(3);
        head.next.next = new Node(5);
        head.next.next.next = head;
        Node res = i.insert(head,0);
        Node curr = res;
        do{
            System.out.print(curr.val+" ");
            curr = curr.next;
        }while(curr!=res);
    }

}
class Node{
    int val;
    Node next;
    Node(){}
    Node(int val,Node next){
        this.val = val;
        this.next = next;
    }
    Node(int val){
        this.val = val;
    }
}
