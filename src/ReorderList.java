import java.util.ArrayDeque;
import java.util.Deque;

public class ReorderList {
    public void reorderList(ListNode head) {
        Deque<ListNode> deque = new ArrayDeque<>();
        ListNode addHead = head;
        ListNode activeNode = head;
        ListNode keepNode = head;
        addHead = addHead.next;
        while(addHead != null) {
            deque.add(addHead);
            addHead = addHead.next;
        }
        while(!deque.isEmpty()) {
            activeNode.next =deque.pollLast();
            activeNode = activeNode.next;
            if (!deque.isEmpty()) {
                activeNode.next = deque.pollFirst();
                activeNode = activeNode.next;
            }
        }
        activeNode.next = null;
        head = keepNode;
    }
//    static void replace(ListNode head, Deque<ListNode> deque) {
//        if (!deque.isEmpty()) {
//            head.next =deque.pollLast();
//            head = head.next;
//            if (!deque.isEmpty()) {
//                head.next = deque.pollFirst();
//                head = head.next;
//                replace (head, deque);
//            }
//        }
//    }
}
