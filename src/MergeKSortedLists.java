import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }
        else {
            //모든 노드들의 val값을 list에 저장
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < lists.length; i++) {
                while (lists[i] != null) {
                    list.add(lists[i].val);
                    lists[i] = lists[i].next;
                }
            }
            //list안의 값을 내림차순으로 정렬
            Collections.sort(list, Collections.reverseOrder());
            //stack에 node를 저장해놓으면서 다음 node를 만들면 꺼내서 연결
            Stack<ListNode> stack = new Stack<>();
            for (int num : list) {
                //list안에 들어있는 순서대로의 val을 갖는 node 생성
                ListNode listNode = new ListNode(num);
                if (stack.isEmpty()) {
                    //stack에 아무것도 안들어있으면 처음 노드라는 의미임으로 push
                    stack.push(listNode);
                } else {
                    //stack에 node가 있으면 꺼내서 새로만든 노드의 뒤에 연결하고, 새로 만든 node를 stack에 넣는다.
                    listNode.next = stack.pop();
                    stack.push(listNode);
                }
            }
            if (stack.isEmpty()) {
                return null;
            }
            else {
                return stack.pop();
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

//    public ListNode mergeKLists(ListNode[] lists) {
//        //lists가 비어있으면 null 반환하기
//        if (lists == null) {
//            return null;
//        }
//        else {
//            //return할 node를 새로 만들어주기
//            ListNode answer = lists[0];
//            for (int i = 1; i<lists.length; i++) {
//                ListNode recursionNode = answer;
//                // lists[i]의 노드들을 하나씩 돌기
//                ListNode compareNode = lists[i];
//                while (compareNode != null) {
//                    ListNode compareAfterNode = compareNode.next;
//                    while (recursionNode != null) {
//                        //answer의 노드들의 값을 비교해서 노드 추가하는 while문
//                        if (recursionNode.next != null) {
//                            if (recursionNode.val == compareNode.val) {
//                                //값이 같으면 그냥 뒤에 넣기
//                                ListNode keepNode = recursionNode.next;
//                                recursionNode.next = compareNode;
//                                compareNode.next = keepNode;
//                                break;
//                            } else if (recursionNode.val < compareNode.val && recursionNode.next.val > compareNode.val) {
//                                //뒤에 넣을 경우
//                                ListNode keepNode = recursionNode.next;
//                                recursionNode.next = compareNode;
//                                compareNode.next = keepNode;
//                                break;
//                            } else if (recursionNode.val < compareNode.val && recursionNode.next.val < compareNode.val) {
//                                recursionNode = recursionNode.next;
//                            }
//                            else {
////                                ListNode keepNode = compareNode.next;
//                                compareNode.next = recursionNode;
//                                break;
//                            }
//                        }
//                        else {
//                            ListNode keepNode = recursionNode.next;
//                            recursionNode.next = compareNode;
//                            compareNode.next = keepNode;
//                        }
//                    }
//                    compareNode = compareAfterNode;
//                }
//            }
//            return answer;
//        }
//    }
}


