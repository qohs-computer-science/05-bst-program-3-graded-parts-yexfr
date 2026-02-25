import java.lang.Comparable;

public class BST implements BSTInterface {

    private TreeNode root;
    private int size;

    // Constructor
    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return root == null;
    }

    // ADD
    public void add(Comparable obj) {
        root = addHelper(root, obj);
    }

    private TreeNode addHelper(TreeNode node, Comparable data) {
        if (node == null) {
            size++;
            return new TreeNode(data);
        }

        if (data.compareTo(node.getData()) <= 0) {
            node.setLeft(addHelper(node.getLeft(), data));
        } else {
            node.setRight(addHelper(node.getRight(), data));
        }

        return node;
    }

    // FIND
    public boolean find(Comparable obj) {
        return findHelper(root, obj);
    }

    private boolean findHelper(TreeNode node, Comparable data) {
        if (node == null)
            return false;

        if (data.compareTo(node.getData()) == 0)
            return true;

        if (data.compareTo(node.getData()) < 0)
            return findHelper(node.getLeft(), data);
        else
            return findHelper(node.getRight(), data);
    }

    // REPLACE
    public boolean replace(Comparable oldObj, Comparable newObj) {
        boolean existed = delete(oldObj);
        add(newObj);

        return existed;
    }

    // DELETE
    public boolean delete(Comparable obj) {
        if (!find(obj))
            return false;

        root = deleteHelper(root, obj);
        size--;
        return true;
    }

    private TreeNode deleteHelper(TreeNode node, Comparable data) {
        if (node == null)
            return null;

        if (data.compareTo(node.getData()) < 0) {
            node.setLeft(deleteHelper(node.getLeft(), data));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRight(deleteHelper(node.getRight(), data));
        } else {
            // Case 1: no children
            if (node.getLeft() == null && node.getRight() == null)
                return null;

            // Case 2: one child
            if (node.getLeft() == null)
                return node.getRight();

            if (node.getRight() == null)
                return node.getLeft();

            // Case 3: two children
            TreeNode successor = findMin(node.getRight());
            node.setData(successor.getData());
            node.setRight(deleteHelper(node.getRight(), successor.getData()));
        }

        return node;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.getLeft() != null)
            node = node.getLeft();
        return node;
    }

    // TRAVERSALS

    public void printInOrder() {
        printInOrderHelper(root);
        System.out.println();
    }

    private void printInOrderHelper(TreeNode node) {
        if (node != null) {
            printInOrderHelper(node.getLeft());
            System.out.print(node.getData() + " ");
            printInOrderHelper(node.getRight());
        }
    }

    public void printPreOrder() {
        printPreOrderHelper(root);
        System.out.println();
    }

    private void printPreOrderHelper(TreeNode node) {
        if (node != null) {
            System.out.print(node.getData() + " ");
            printPreOrderHelper(node.getLeft());
            printPreOrderHelper(node.getRight());
        }
    }

    public void printPostOrder() {
        printPostOrderHelper(root);
        System.out.println();
    }

    private void printPostOrderHelper(TreeNode node) {
        if (node != null) {
            printPostOrderHelper(node.getLeft());
            printPostOrderHelper(node.getRight());
            System.out.print(node.getData() + " ");
        }
    }
}