public class AVLTrees {
   
    static class Node{
        int data, height;
        Node left, right;

        Node(int data){
            this.data = data;
            this.height = 1; // New node is initially added at leaf
        }
    }

    public static Node root;

    // Utility function to return the maximum of two integers
    public static int max(int a, int b){
        return (a > b) ? a : b;
    }

    // Function to get the height of the tree
    public static int height(Node root){
        if(root == null) {
            return 0;
        }
        return root.height;
    }

    // Function to rotate subtree rooted with `y` to the right
    public static Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    // Function to rotate subtree rooted with `x` to the left
    public static Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    // Get Balance factor of node `root`
    public static int getBalance(Node root){
        if (root == null) {
            return 0;
        }
        return height(root.left) - height(root.right);
    }

    // Function to insert a node into the AVL tree and balance it
    public static Node insert(Node root, int key) {
        // 1. Perform the normal BST insertion
        if (root == null) {
            return new Node(key);
        }

        if (key < root.data) {
            root.left = insert(root.left, key);
        } else if (key > root.data) {
            root.right = insert(root.right, key);
        } else {
            return root; // Duplicate keys are not allowed in the AVL tree
        }

        // 2. Update the height of this ancestor node
        root.height = 1 + max(height(root.left), height(root.right));

        // 3. Get the balance factor of this ancestor node to check whether it is unbalanced
        int balance = getBalance(root);

        // 4. If the node becomes unbalanced, there are 4 cases

        // Left Left Case
        if (balance > 1 && key < root.left.data) {
            return rightRotate(root);
        }

        // Right Right Case
        if (balance < -1 && key > root.right.data) {
            return leftRotate(root);
        }

        // Left Right Case
        if (balance > 1 && key > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Left Case
        if (balance < -1 && key < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        // Return the (unchanged) node pointer
        return root;
    }

    // Function to print the tree (in-order traversal)
    public static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    public static void main(String[] args) {
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);

        /*
                AVL Tree
                 30    
                /  \ 
               20   40 
              /  \    \
            10   25    50
        */
        
        System.out.println("In-order traversal of the constructed AVL tree is: ");
        inOrder(root); // Output: 10 20 25 30 40 50
    }
}
