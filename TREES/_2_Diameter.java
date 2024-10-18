public class _2_Diameter {
    Node root;

    // Number of Nodes in the Longest distance between two leaf nodes
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int height(Node root) {
        if (root == null)
            return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh) + 1;
    }

    public static int findDiameter1(Node root) { // O(N^2)
        if (root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        int diameter = lh + rh + 1;
        int leftDiameter = findDiameter1(root.left);
        int rightDiameter = findDiameter1(root.right);
        return Math.max(diameter, Math.max(leftDiameter, rightDiameter));

    }

    public static class TreeInfo {
        int dia;
        int height;

        TreeInfo(int dia, int height) {
            this.dia = dia;
            this.height = height;
        }
    }

    public static TreeInfo findDiameter2(Node root) { // O(N)
        if (root == null) {
            return new TreeInfo(0, 0);
        }
        TreeInfo leftInfo = findDiameter2(root.left);
        TreeInfo rightInfo = findDiameter2(root.right);

        int diameter = Math.max(leftInfo.height + rightInfo.height + 1,
                Math.max(leftInfo.dia, rightInfo.dia));
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;

        return new TreeInfo(diameter, height);
    }

    public static void main(String[] args) {
        _2_Diameter tree = new _2_Diameter();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(6);
        tree.root.left.right.right = new Node(7);
        tree.root.left.right.right.right = new Node(8);
            /*  
               1
             /   \
            2     3
           / \
          4   5
         /     \
        6       7
                 \
                  8
    */
        System.out.println("Diameter approach 1 = " + findDiameter1(tree.root));
        System.out.println("Diameter approach 2 = " + findDiameter2(tree.root).dia);
    }
}
