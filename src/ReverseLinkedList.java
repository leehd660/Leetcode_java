import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
//        Stack<Integer> stack = new Stack<>();
        if (head == null) {
            return null;
        }
        else {
            Deque<ListNode> deque = new ArrayDeque<>();
            while (head.next != null) {
//            stack.push(head.val);
                deque.add(head);
                head = head.next;
            }
            while (!deque.isEmpty()) {
                ListNode keepNode = head.next;
                deque.peekFirst().next = keepNode;
                head.next = deque.pollFirst();
            }
            return head;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {};
    ListNode(int val) { this.val = val; };
    ListNode(int val, ListNode next) { this.val = val; this.next = next; };
}
