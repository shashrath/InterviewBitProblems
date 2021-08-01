package shasha.company.LinkedList;


public class sortedListtoBST {
    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);
        sortedListToBST(head);
    }

    public static TreeNode sortedListToBST(ListNode head) {
        return createBst(head, null);
    }

    public static TreeNode createBst(ListNode head, ListNode tail) {
        if (head == tail)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = createBst(head, slow);
        root.right = createBst(slow.next, tail);
        return root;
    }
}
