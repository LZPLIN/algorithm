import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的前中后遍历
 * 前序遍历：https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * 中序遍历：https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * 后序遍历：https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 */
public class OrderTraversal {
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

        System.out.println(postOrderTraversalR(root));

    }

    /**
     * 前序遍历：迭代法 遍历顺序：根节点、左子树、右子树
     * @param root
     * @return
     */
    public static List<Integer> preOrderTraversal(TreeNode root){
        ArrayList<Integer> res = new ArrayList();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode curr = stack.pop();
            res.add(curr.val);
            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);
        }
        return res;
    }

    /**
     * 前序遍历：递归法
     * @param root
     * @return
     */
    public static List<Integer> preOrderTraversalR(TreeNode root){
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        preOrder(root,res);
        return res;
    }

    private static void preOrder(TreeNode node,List<Integer> res){
        if (node == null) return;
        res.add(node.val);
        preOrder(node.left,res);
        preOrder(node.right,res);
    }

    /**
     * 中序遍历 迭代法 遍历顺序：左子树、根节点、右子树
     * @param root
     * @return
     */
    public static List<Integer> inOrderTraversal(TreeNode root){
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()){
            while (curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode node = stack.pop();
            res.add(node.val);

            curr = node.right;
        }
        return res;

    }

    /**
     * 中序遍历：递归法
     * @param root
     * @return
     */
    public static List<Integer> inOrderTraversalR(TreeNode root){
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        inOrder(root,res);
        return res;
    }

    private static void inOrder(TreeNode node,List<Integer> res){
        if (node == null) return;
        inOrder(node.left,res);
        res.add(node.val);
        inOrder(node.right,res);
    }

    /**
     * 后序遍历：迭代法 遍历顺序：左子树、右子树、根节点
     * @param root
     * @return
     */
    public static List<Integer> postOrderTraversal(TreeNode root){
        ArrayList<Integer> res = new ArrayList();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode curr = stack.pop();
            res.add(curr.val);
            if (curr.left != null) stack.push(curr.left);
            if (curr.right != null) stack.push(curr.right);
        }
        Collections.reverse(res);
        return res;
    }

    /**
     * 后序遍历：递归法
     * @param root
     * @return
     */
    public static List<Integer> postOrderTraversalR(TreeNode root){
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        postOrder(root,res);
        return res;
    }

    private static void postOrder(TreeNode node,List<Integer> res){
        if (node == null) return;
        postOrder(node.left,res);
        postOrder(node.right,res);
        res.add(node.val);
    }


}

class TreeNode<Integer> {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
