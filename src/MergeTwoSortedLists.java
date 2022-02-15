public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        int start = 0;
        if(list1 == null && list2 == null) {
            return null;
        }
        else {
//            if (list1 != null && list2 != null) {
                if (list1 == null) {
                    start = list2.val;
                    list2 = list2.next;
                } else if (list2 == null) {
                    start = list1.val;
                    list1 = list1.next;
                } else {
                    if (list1.val <= list2.val) {
                        start = list1.val;
                        list1 = list1.next;
                    } else {
                        start = list2.val;
                        list2 = list2.next;
                    }
                }

                ListNode answer = new ListNode(start);
                ListNode head = answer;
                while (list1 != null || list2 != null) {
                    if (list1 == null) {
                        ListNode node = new ListNode(list2.val);
                        list2 = list2.next;
                        answer.next = node;
                        answer = answer.next;
                    } else if (list2 == null) {
                        ListNode node = new ListNode(list1.val);
                        list1 = list1.next;
                        answer.next = node;
                        answer = answer.next;
                    } else {
                        if (list1.val <= list2.val) {
                            ListNode node = new ListNode(list1.val);
                            list1 = list1.next;
                            answer.next = node;
                            answer = answer.next;
                        } else {
                            ListNode node = new ListNode(list2.val);
                            list2 = list2.next;
                            answer.next = node;
                            answer = answer.next;
                        }
                    }
                }
                return head;
//            }
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
