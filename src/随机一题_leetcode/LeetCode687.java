package 随机一题_leetcode;

import java.util.Map;

public class LeetCode687 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
    private int count = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        search(root, root.val);
        return count;
    }
//    依次找到每个节点左子树和右子树中值和节点相同的
//    count可以理解为当前节点的最长同值路径
//    如果要与当前节点的父节点相连，只能取左子树或右子树其中最大的
    public int search(TreeNode node, int val) {
        if (node == null) return 0;
        int left = search(node.left, node.val);
        int right = search(node.right, node.val);
        count = Math.max(count, left + right);
        if (node.val == val) return Math.max(left, right) + 1;
        return 0;
    }

    public static void main(String[] args) {
    }
}
/*

    1
  1   2
1   1   2


 */