public class DiaMeTree01 {
    public static class Node { // O(n^2)
        int data;
        Node left = null;
        Node right = null;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int height(Node root) { // O(n) Linear
        if (root == null) {
            return 0;
        }

        int LH = height(root.left);
        int RH = height(root.right);

        return Math.max(LH, RH) + 1;
    }

    public static int DiameterTree(Node root) {
        if (root == null) {
            return 0;
        }

        int LeftDia = DiameterTree(root.left);
        int LeftHT = height(root.left);
        int RightDia = DiameterTree(root.right);
        int RightHT = height(root.right);

        int selfDia = LeftHT + RightHT + 1;

        return Math.max(selfDia, Math.max(LeftDia, RightDia));
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);

        System.out.println(DiameterTree(root));
    }
}
