package TREES;

import java.util.LinkedList;
import java.util.Queue;

public class BuildTreePreorder {
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

    static class binaryTree {
        static int idx = -1;

        public static Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }

        public static void preorder(Node root) {
            if (root == null) {
                return;
            }
            System.out.print(root.data + " - ");
            preorder(root.left);
            preorder(root.right);
        }

        public static void inorder(Node root) {
            if (root == null) {
                return;
            }
            inorder(root.left);
            System.out.print(root.data + " - ");
            inorder(root.right);
        }

        public static void postorder(Node root) {
            if (root == null) {
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " - ");
        }

        public static void levelorder(Node root) {
            if (root == null) {
                return;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            queue.add(null);// nextLine
            while (!queue.isEmpty()) {
                Node curNode = queue.remove();
                if (curNode == null) {
                    System.out.println();
                    if (queue.isEmpty())
                        break;
                    else
                        queue.add(null);
                } else {
                    System.out.print(curNode.data + " ");
                    if (curNode.left != null) {
                        queue.add(curNode.left);
                    }
                    if (curNode.right != null) {
                        queue.add(curNode.right);
                    }
                }
            }
        }
    }

    public static int height(Node root) {
        int count = 0;
        if (root == null)
            return 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node curNode = q.remove();
            if (curNode == null) {
                count++;
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if (curNode.left != null)
                    q.add(curNode.left);
                if (curNode.right != null)
                    q.add(curNode.right);
            }
        }
        return count;
    }

    public static int heightrecursive(Node root) {
        if (root == null)
            return 0;
        int lh = heightrecursive(root.left);
        int rh = heightrecursive(root.right);
        return Math.max(lh, rh) + 1;
    }

    public static int countNodes(Node root) {
        if (root == null)
            return 0;
        int lc = countNodes(root.left);
        int rc = countNodes(root.right);
        return lc + rc + 1;
    }

    public static int sumNodes(Node root) {
        if (root == null)
            return 0;
        int ls = sumNodes(root.left);
        int rs = sumNodes(root.right);
        return ls + rs + root.data;
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        binaryTree tree = new binaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println("\nPreorder: ");
        tree.preorder(root);
        System.out.println("\nInorder: ");
        tree.inorder(root);
        System.out.println("\nPostorder: ");
        tree.postorder(root);
        System.out.println("\nLevelorder: ");
        tree.levelorder(root);
        System.out.println("The height of the tree is = " + height(root));
        System.out.println("The height of the tree(recursive) is = " + heightrecursive(root));
        System.out.println("The Number of Nodes in the tree is = " + countNodes(root));
        System.out.println("The Sum of Nodes in the tree is = " + sumNodes(root));
    }
}
