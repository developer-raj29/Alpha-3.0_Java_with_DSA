public class _04DectectingCycle {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    public static boolean IsCycle() { // Floyd's Cycle Finding Algorithm
        Node Slow = head;
        Node Fast = head;

        while (Fast != null && Fast.next != null) {
            Slow = Slow.next; // +1 agee badega
            Fast = Fast.next.next; // +2 agee badega

            if (Slow == Fast) { // when both are equal
                return true; // when cycle is exists - Ans true
            }
        }

        return false; // when cycle is does'nt exists - Ans false
    }

    public static void main(String[] args) {
        head = new Node(1); // 1 -> 2 -> 3 -> 1
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = head; // 1->2->3->4->-5->1

        // head.next.next.next = head;

        System.out.println(IsCycle()); // true when cycle is exists
    }
}
