/*
 * TODO: Name
 * TODO: Date
 * TODO: Class Period
 * TODO: Program Description
 */

 import java.lang.Comparable;

 public class BSTTester {

    public static void main(String[] args) {

        BST tree = new BST();

        System.out.println("Is tree empty? " + tree.isEmpty());

        // Add elements
        String[] elements = {
                "O", "R", "C", "H", "A", "R", "D",
                "Q", "U", "I", "N", "C", "E"
        };

        for (String s : elements)
            tree.add(s);

        System.out.println("Size after adding elements: " + tree.size());
        System.out.println("Is tree empty? " + tree.isEmpty());

        System.out.println("\nInOrder Traversal:");
        tree.printInOrder();

        System.out.println("PreOrder Traversal:");
        tree.printPreOrder();

        System.out.println("PostOrder Traversal:");
        tree.printPostOrder();

        // Test find
        System.out.println("\nFind 'Q': " + tree.find("Q"));
        System.out.println("Find 'Z': " + tree.find("Z"));

        // Test delete
        System.out.println("\nDelete 'H': " + tree.delete("H"));
        tree.printInOrder();

        System.out.println("Delete 'Z' (not in tree): " + tree.delete("Z"));

        // Test replace
        System.out.println("\nReplace 'R' with 'B': " + tree.replace("R", "B"));
        tree.printInOrder();

        System.out.println("Replace 'X' with 'Y' (X not in tree): " + tree.replace("X", "Y"));
        tree.printInOrder();

        System.out.println("\nFinal Size: " + tree.size());
    }
}