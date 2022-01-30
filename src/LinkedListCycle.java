

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        //아래 주석 처리된 코드는 처음에 내가 해결한 방법.
//        boolean answer = true;
//        if (head == null) {
//            answer = false;
//        }
//        else {
//            //Listnode를 담는 list를 만들어서 추가하고, 다시 사이클 되는지 확인.
//            List<ListNode> list = new ArrayList<>();
//            while (!list.contains(head)) {
//                list.add(head);
//                if (head.next == null) {
//                    answer = false;
//                    break;
//                } else {
//                    head = head.next;
//                }
//            }
//        }
//        return answer;

        //follow up인 메모리를 O(1)로 하는 방법이 무엇인지 궁금해서 찾아봄.
        if (head == null) {
            return false;
        }
        else {
            //two pointer방식을 이용해서 한개는 빨리 가는 노드, 하나는 천천히 가는 노드를 만들어서
            // 노드가 서로 같은지 확인하는 방법.(사실 내 방법이 더 가시적인거 같긴함.)
            ListNode slowPointer = head;
            ListNode fastPointer = head.next;
            while (slowPointer != null && fastPointer != null
            && fastPointer.next != null) {
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next.next;
                if (fastPointer == slowPointer) {
                    return true;
                }
            }
            return false;
        }
        //근데 막상 메모리는 비슷하고, 시간이 훨씬 빠르네,,
    }


    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
