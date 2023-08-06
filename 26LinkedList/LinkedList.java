public class LinkedList {
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
    public int size;

    // add first Time Complexity - O(n) constant time
    public void addFirst(int data) {
        // step 1 - create a new node
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        // step 2 -newNode next = head
        newNode.next = head; // link

        // step 3 - head = newNode
        head = newNode;
    }

    public void addLast(int data) {
        // step 1 - create a new node
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        // step 2 - tail.next = head
        tail.next = newNode;

        // step 3 - tail = newNode
        tail = newNode;
    }
    /*
     * Methods :- add(), remove() , search() , print()
     */

    public void Print() {
        if (head == null) {
            System.out.println("LL is empty");
            return;
        }

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void addNode(int idx, int data) {
        if (idx == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;

        Node temp = head;
        int i = 0;
        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }
        // i = idx - 1 ; temp -> prev

        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFirst() {
        if (size == 0) {
            System.out.println("LL is epmty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int value = head.data;
            head = tail = null;
            size = 0;
            return value;
        }
        int value = head.data;
        head = head.next;
        size--;
        return value;
    }

    public int removeLast() {
        if (size == 0) {
            System.out.println("LL is epmty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int value = head.data;
            head = tail = null;
            size = 0;
            return value;
        }

        // prev : i = size - 2
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }

        int value = prev.next.data; // tail.data
        prev.next = null;
        tail = prev;
        size--;
        return value;
    }

    public int search(int key) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key) { // key is found
                return i;
            }
            temp = temp.next;
            i++;
        }
        // key is not found
        return -1;
    }

    public int helper(Node head, int key) {
        // base case
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        int idx = helper(head.next, key);
        if (idx == -1) {
            return -1;
        }
        return idx + 1;
    }

    public int RecusiveSearch(int key) {
        return helper(head, key);
    }

    public void Reverse() {
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void removeNthNode(int Nth) {
        // Calculate size
        int size = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }

        if (Nth == size) {
            head = head.next;
            return;
        }

        // size - Nth

        int i = 1;
        int iTofind = size - Nth;
        Node prev = head;
        while (i < iTofind) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }

    // Slow - Fast Approach
    public Node FindMid(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean CheckPalindrome() {
        if (head == null || head.next != null) {
            return true;
        }

        // step1 - find mid
        Node midNode = FindMid(head);

        // step 2 - reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev;
        Node left = head;

        // xtep 3 - check left half
        while (right != null) {
            if (left.data == right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    public static void main(String[] args) {
        LinkedList LL = new LinkedList();
        // LL.head = new Node(1);
        // LL.head.next = new Node(2);
        LL.addFirst(2);
        LL.addFirst(1);
        LL.addLast(4);
        LL.addLast(5);
        LL.addNode(2, 3);
        LL.Print(); // 1->2->3->4->5->null
        System.out.println(LL.size); // 5
        // LL.removeFirst();
        // LL.Print();
        // LL.removeLast(); // 2->3->4->null
        // LL.Print();

        // System.out.println(LL.search(4));
        // // System.out.println(LL.search(5));
        // // System.out.println(LL.search(10));

        // System.out.println(LL.RecusiveSearch(3));
        // LL.Reverse();
        // LL.Print();

        LL.removeNthNode(3);
        LL.Print();
    }
}
