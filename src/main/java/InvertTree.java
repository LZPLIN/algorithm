import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 反转二叉树：https://leetcode-cn.com/problems/invert-binary-tree/
 */
public class InvertTree {
    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode(23);
        TreeNode<Integer> node1 = new TreeNode(34);
        TreeNode<Integer> node2 = new TreeNode(21);
        TreeNode<Integer> node3 = new TreeNode(99);
        TreeNode<Integer> node4 = new TreeNode(77);
        TreeNode<Integer> node5 = new TreeNode(90);
        TreeNode<Integer> node6 = new TreeNode(45);
        TreeNode<Integer> node7 = new TreeNode(60);

        root.left=node1;
        root.right=node2;
        node1.left=node3;
        node3.left=node4;
        node3.right=node5;
        node2.left=node6;
        node2.right=node7;

        invertTreeR(root);

    }

    /**
     * 翻转二叉树：递归 类似后续遍历
     * @param node
     * @return
     * 时间复杂度：O(N)，其中 NN 为二叉树节点的数目。我们会遍历二叉树中的每一个节点，对每个节点而言，我们在常数时间内交换其两棵子树。
     * 空间复杂度：O(N)。使用的空间由递归栈的深度决定，它等于当前节点在二叉树中的高度。在平均情况下，二叉树的高度与节点个数为对数关系，即 O(\log N)。而在最坏情况下，树形成链状，空间复杂度为 O(N)。
     *
     */
    public static TreeNode invertTreeR(TreeNode node){
        if (node == null ) return null;
        if (node.left == null && node.right == null) return node;

        TreeNode left = invertTreeR(node.left);
        TreeNode right = invertTreeR(node.right);

        node.left=right;
        node.right=left;

        return node;
    }

}
