package 周赛163;

public class Solution_1261 {
}
//方法1
//class FindElements {
//    TreeNode temp;
//
//    public FindElements(TreeNode root) {
//        root.val = 0;
//        createTree(root.left, 1);
//        createTree(root.right, 2);
//        temp = root;
//    }
//
//    public void createTree(TreeNode root, int k) {
//        if (root == null) {
//            return ;
//        }
//        root.val = k;
//        if (root.left != null) {
//            int kl = k * 2 + 1;
//            createTree(root.left, kl);
//        }
//        if (root.right != null) {
//            int kr = k * 2 + 2;
//            createTree(root.right, kr);
//        }
//
//    }
//
//    public boolean find(int target) {
//        return findTree(temp, target);
//    }
//    public boolean findTree(TreeNode root, int target) {
//        if (root == null || root.val > target) {
//            return false;
//        }
//        if (root.val == target) {
//            return true;
//        }
//        return findTree(root.left, target) || findTree(root.right, target);
//    }
//}
//方法2
//class FindElements {
//    Set<Integer> set = new HashSet<>();
//
//    public FindElements(TreeNode root) {
//        root.val = 0;
//        set.add(0);
//        createTree(root.left, 1);
//        createTree(root.right, 2);
//    }
//
//    public void createTree(TreeNode root, int k) {
//        if (root == null) {
//            return ;
//        }
//        root.val = k;
//        set.add(k);
//        if (root.left != null) {
//            int kl = k * 2 + 1;
//            createTree(root.left, kl);
//        }
//        if (root.right != null) {
//            int kr = k * 2 + 2;
//            createTree(root.right, kr);
//        }
//
//    }
//
//    public boolean find(int target) {
//        return set.contains(target);
//    }
//
//}
