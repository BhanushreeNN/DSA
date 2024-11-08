import java.util.*;

class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int data) {
        this.data = data;
        left = right = null;
    }
}

public class _3_BurningTree {
    
    // Map to represent the adjacency list of the tree
    private static Map<TreeNode, List<TreeNode>> map;

    // Build the adjacency list for the tree
    private static void buildMap(TreeNode node, TreeNode parent) {
        if (node == null) return;

        // If node not in map, add it with an empty list
        if (!map.containsKey(node)) {
            map.put(node, new ArrayList<TreeNode>());

            // If there's a parent, add mutual connections between parent and node
            if (parent != null) {
                map.get(node).add(parent);
                map.get(parent).add(node);
            }

            // Recursively build the map for the left and right children
            buildMap(node.left, node);
            buildMap(node.right, node);
        }
    }

    // Perform BFS to simulate burning from the starting node
    public static List<List<Integer>> burnTree(TreeNode root, TreeNode start) {
        map = new HashMap<>(); // Initialize the map
        buildMap(root, null);  // Build the adjacency list from the tree

        List<List<Integer>> burnSequence = new ArrayList<>();
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();

        // Initialize BFS with the starting node
        queue.add(start);
        visited.add(start);

        // BFS to burn nodes level by level
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.data);

                // Traverse all neighbors of the current node
                for (TreeNode neighbor : map.getOrDefault(currentNode, new ArrayList<>())) {
                    if (!visited.contains(neighbor)) {
                        queue.add(neighbor);
                        visited.add(neighbor);
                    }
                }
            }

            burnSequence.add(currentLevel);
        }

        return burnSequence;
    }

    // Utility function to print the burn sequence
    public static void printBurnSequence(List<List<Integer>> burnSequence) {
        for (int time = 0; time < burnSequence.size(); time++) {
            System.out.println("Time " + time + ": " + burnSequence.get(time));
        }
    }

    public static void main(String[] args) {
        // Construct the tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        TreeNode start = root.left.left; // Starting node (node with value 4)
        
        // Get the burn sequence
        List<List<Integer>> burnSequence = burnTree(root, start);

        // Print the burn sequence
        System.out.println("Burn Sequence:");
        printBurnSequence(burnSequence);
    }
}
