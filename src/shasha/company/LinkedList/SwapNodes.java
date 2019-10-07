package shasha.company.LinkedList;

public class SwapNodes {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode head = a;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        swapPairs(head);

    }

    private static ListNode swapPairs(ListNode A) {
        if (A == null || A.next == null) return A;
        ListNode cptr = A, fptr, prev = null;
        A = A.next;
        while (cptr != null && cptr.next != null) {
            fptr = cptr.next;
            if (prev != null)
                prev.next = fptr;
            cptr.next = fptr.next;
            fptr.next = cptr;
            prev = cptr;
            cptr = cptr.next;
        }
        return A;
    }
}
