package shasha.company.LinkedList;

public class DeleteFromEnd {

    public static void main(String[] args) {
        ListNode e = new ListNode(5,null);
        ListNode d = new ListNode(4,e);
        ListNode c = new ListNode(3,d);
        ListNode b = new ListNode(2,c);
        ListNode a = new ListNode(1,b);
        removeNthFromEnd(a,2);
    }
    //Move the pointer n times ahead and then remove the node.
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fNode = head,pNode = head;
        for(int i=0;i<n;i++)
            fNode = fNode.next;
        while(fNode!=null && fNode.next!=null){
            fNode = fNode.next;
            pNode = pNode.next;
        }
        if(fNode == null)
            return head.next;
        pNode.next = pNode.next.next;
        return head;
    }
}
