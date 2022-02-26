public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode keepNode = head;
        ListNode preNode = null;
        ListNode nNode = head;
        ListNode afterNode = head.next;
        int count = 1;
        if (head.next == null) {
            return null;
        }
        else {
            while (head.next != null) {
                count++;
                head = head.next;
                if (count == n) {
                    nNode = keepNode;
                }
                else if (count > n) {
                    preNode = nNode;
                    nNode = nNode.next;
                    afterNode = nNode.next;
                }
            }
            if (nNode == keepNode) {
                return keepNode.next;
            }
            else {
                preNode.next = afterNode;
                return keepNode;
            }
        }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
