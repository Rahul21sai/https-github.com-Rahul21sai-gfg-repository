//{ Driver Code Starts
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}

class CreateTree {
    static ArrayList<Integer> result = new ArrayList<Integer>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            Node root = ob.createTree(arr);

            printLevelOrder(root);
            System.out.println();
        }
    }

    public static void printList(Node root) {
        while (root != null) {
            System.out.print(root.data + " ");
        }
    }

    public static void printLevelOrder(Node root) {
        int h = height(root);
        int i;
        for (i = 1; i <= h; i++) {
            result.clear();
            printGivenLevel(root, i);
            Collections.sort(result);
            for (int j = 0; j < result.size(); j++)
                System.out.print(result.get(j) + " ");
        }
    }

    public static int height(Node root) {
        if (root == null)
            return 0;

        else {

            int lheight = height(root.left);
            int rheight = height(root.right);

            if (lheight > rheight)
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }

    public static void printGivenLevel(Node node, int level) {
        if (node == null) return;
        if (level == 1)
            result.add(node.data);
        else if (level > 1) {
            printGivenLevel(node.left, level - 1);
            printGivenLevel(node.right, level - 1);
        }
    }
}

// } Driver Code Ends


/*node class of the binary tree
class Node
{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}*/
class Solution {
    // Function to construct binary tree from parent array.
    public Node createTree(int parent[]) {
        int n = parent.length;

        // Step 1: Create an array of Node references
        Node[] nodes = new Node[n];

        // Initialize all the nodes with their respective values
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }

        // Variable to hold the reference to the root node
        Node root = null;

        // Step 2: Link the nodes according to the parent array
        for (int i = 0; i < n; i++) {
            // If parent[i] is -1, then nodes[i] is the root
            if (parent[i] == -1) {
                root = nodes[i];
            } else {
                // Get the parent node for nodes[i]
                Node parentNode = nodes[parent[i]];

                // If the left child is not set, set it to nodes[i]
                if (parentNode.left == null) {
                    parentNode.left = nodes[i];
                } else {
                    // Otherwise, set the right child
                    parentNode.right = nodes[i];
                }
            }
        }

        // Return the root node of the constructed tree
        return root;
    }
}
