package 周赛167;

public class Solution_1286 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
  }
    public static int getDecimalValue(ListNode head) {
        if (head.next == null) return head.val;
        int sum = 0;
        while (head != null) {
            sum = sum * 2 + head.val;
            head = head.next;
        }
        return sum;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        System.out.println(getDecimalValue(node));
    }
}
