import java.util.HashMap;
public class LinkedList {
    Node head;
    static class Node {
        String val;
        Node next, random;
        public Node(String val) {
            this.val = val;
            this.next = this.random = null;
        }
    }
    public LinkedList(Node head) {
        this.head = head;
    }

    public static LinkedList insert(LinkedList ll, String val){
        Node newNode = new Node(val);
        newNode.next = null;

        if (ll.head == null) {
            ll.head = newNode;
        }
        else {
            Node currNode = ll.head;
            while (currNode.next != null) {
                currNode = currNode.next;
            }
            currNode.next = newNode;
        }
        return ll;
    }

    public static LinkedList remove(LinkedList ll, String val) {
        Node currNode = ll.head, prevNode = null;
        while (currNode != null && currNode.val != val) {
            prevNode = currNode;
            currNode = currNode.next;
        }
        if (currNode != null) {
            prevNode.next = currNode.next;
        }
        return ll;
    }

    public static void print(LinkedList ll) {
        Node currNode = ll.head;
        while (currNode != null){
            System.out.println(currNode.val);
            currNode = currNode.next;
        }
        System.out.println();
    }

   public static boolean palindrome(LinkedList ll) {
        LinkedList clone = ll.clone();
        clone.head = reverse(clone.head);
        if (compare(ll, clone) == true){
            return true;
        }
        return false;
   }

    public static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node rest = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }

    public LinkedList clone() {
        Node origCurr = this.head, cloneCurr = null;
        HashMap<Node, Node> map = new HashMap();
        while (origCurr != null)
        {
            cloneCurr = new Node(origCurr.val);
            map.put(origCurr, cloneCurr);
            origCurr = origCurr.next;
        }
        origCurr = this.head;
        while (origCurr != null)
        {
            cloneCurr = map.get(origCurr);
            cloneCurr.next = map.get(origCurr.next);
            cloneCurr.random = map.get(origCurr.random);
            origCurr = origCurr.next;
        }
        return new LinkedList(map.get(this.head));
    }

    public static boolean compare(LinkedList ll1, LinkedList ll2) {
        Node a = ll1.head;
        Node b = ll2.head;
        while (a != null && b != null) {
            if (a.val != b.val)
                return false;
            a = a.next;
            b = b.next;
        }
        if (a == null && b == null)
            return true;
        else
            return false;
    }


    public static void main(String[] args) {
        LinkedList ll = new LinkedList(new Node("a"));
        ll = insert(ll,"b");
        ll = insert(ll,"b");
        ll = insert(ll,"c");
        ll = insert(ll,"d");
        ll = insert(ll,"c");
        ll = insert(ll,"b");
        ll = insert(ll,"a");

        //remove function
        ll = remove(ll,"b");
        print(ll);

        //check for palindrome
        System.out.println(palindrome(ll));
    }
}
