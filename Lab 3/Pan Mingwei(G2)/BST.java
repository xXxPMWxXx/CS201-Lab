/*
 * Name:Pan Mingwei
 * Email ID:mingwei.pan.2022
 */

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}

public class BST {
    private TreeNode root;

    public void buildBSTFromPreorder(String preOrder) {
        String[] nodes = preOrder.split("-");
        int n = nodes.length;

        if (n == 0) {
            return;
        }

        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(nodes[i]);
        }

        root = buildBSTFromPreorder(values, 0, n - 1);
    }

    private TreeNode buildBSTFromPreorder(int[] values, int start, int end) {
        if (start > end) {
            return null;
        }
        //the first element will be the root node
        TreeNode node = new TreeNode(values[start]);

        //find the index of the element that is large than the root node, this means start from that index, it will be on the right subtree.
        int i;
        for (i = start + 1; i <= end; i++) {
            if (values[i] > node.value) {
                break;
            }
        }
        //recursive call to build the left and right subtree
        node.left = buildBSTFromPreorder(values, start + 1, i - 1);
        node.right = buildBSTFromPreorder(values, i, end);

        return node;
    }

    public TreeNode getRoot() {
        return root;
    }

    public String inOrderTraversal(TreeNode root) {
        if (root == null) {
            return "";
        }

        String left = inOrderTraversal(root.left);
        String result = left + root.value + "-";
        String right = inOrderTraversal(root.right);

        result += right;
        return result;
    }

    public String postOrderTraversal(TreeNode root) {
        if (root == null) {
            return "";
        }

        String left = postOrderTraversal(root.left);
        String right = postOrderTraversal(root.right);

        String result = left + right + root.value + "-";
        return result;
    }

}
