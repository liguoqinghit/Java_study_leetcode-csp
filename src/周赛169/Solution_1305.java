package 周赛169;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution_1305 {
//    先序遍历，非递归，基于stack
//    再融合
    public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        preOrder(root1, list1);
        preOrder(root2, list2);
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            int v1 = list1.get(i);
            int v2 = list2.get(j);
            if (v1 < v2) {
                list.add(v1);
                i++;
            } else if (v2 < v1) {
                list.add(v2);
                j++;
            } else {
                list.add(v1);
                list.add(v2);
                i++;
                j++;
            }
        }
        if (i < list1.size()) {
            while (i < list1.size()) {
                list.add(list1.get(i++));
            }
        } else if (j < list2.size()) {
            while (j < list2.size()) {
                list.add(list2.get(j++));
            }
        }
        return list;
    }

    public static void preOrder(TreeNode node, List<Integer> list) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                list.add(node.val);
                node = node.right;
            }
        }
    }

//    创建树，可多处利用
    public static void main(String[] args) {
        int[] r1 = {2,1,4};
        int[] r2 = {1,0,3};
        TreeNode root1 = createTree(r1);
        TreeNode root2 = createTree(r2);
        List<Integer> list = getAllElements(root1, root2);
        while (!list.isEmpty()) System.out.println(list.remove(0));
    }

    private static TreeNode createTree(int[] r2) {
        TreeNode[] root = new TreeNode[r2.length];
        for (int i = 0; i < r2.length; i++) {
            root[i] = new TreeNode(r2[i]);
        }
        for (int i = 0; i < r2.length; i++) {
            if (i * 2 + 1 < r2.length) root[i].left = root[i * 2 + 1];
            if (i * 2 + 2 < r2.length) root[i].right = root[i * 2 + 2];
        }
        return root[0];
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }
