package about_string;

import java.util.*;

public class LengthStringWithoutRepeat {
    public int lengthOfLongestSubstring(String s) {
        String[] strArr = s.split("");
//        Deque<String> deque = new ArrayDeque<>();
        List<String> list = new ArrayList<>();
        int maxNum = 0;
        for (int i=0; i<strArr.length; i++) {
            if (strArr[i].equals("")) continue;
//            deque.addLast(strArr[i]);
//            list.add(strArr[i]);
            while (list.contains(strArr[i])) {
//                deque.removeFirst();
                list.remove(0);
            }
            list.add(strArr[i]);
            if (maxNum<list.size()) {
                maxNum = list.size();
            }
        }
        return maxNum;
    }

//    public boolean repeatCheck (String str) {
//        String[] strArr = str.split("");
//
//    }
}
