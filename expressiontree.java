import java.util.Stack;

class TreeNode {
    char data;
    TreeNode left, right;

    public TreeNode(char data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class ET {
    static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public static TreeNode constructET(String prefix) {
        Stack<TreeNode> stack = new Stack<>();

        // Reading the prefix expression in reverse order
        for (int i = prefix.length() - 1; i >= 0; i--) {
            char c = prefix.charAt(i);

            if (isOperator(c)) {
                TreeNode leftOperand = stack.pop();
                TreeNode rightOperand = stack.pop();

                TreeNode operatorNode = new TreeNode(c);
                operatorNode.left = leftOperand;
                operatorNode.right = rightOperand;

                stack.push(operatorNode);
            } else {
                TreeNode operandNode = new TreeNode(c);
                stack.push(operandNode);
            }
        }

        return stack.pop();
    }

    public static void postOrderTraversal(TreeNode root) {
        if (root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        Stack<Character> result = new Stack<>();

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            result.push(current.data);

            if (current.left != null)
                stack.push(current.left);
            if (current.right != null)
                stack.push(current.right);
        }

        while (!result.isEmpty()) {
            System.out.print(result.pop() + " ");
        }
    }

    public static void deleteTree(TreeNode root) {
        if (root == null)
            return;

        deleteTree(root.left);
        deleteTree(root.right);
        root = null; // This line just to emphasize the deletion, though not really necessary in Java
    }

    public static void main(String[] args) {
        String prefixExpression = "+--a*bc/def"; // Example prefix expression
        TreeNode root = constructET (prefixExpression);
        System.out.println("Postorder traversal of the expression tree:");
        postOrderTraversal(root);

        // Deleting the entire tree
        deleteTree(root);
        System.out.println("\nTree deleted.");
    }
}
