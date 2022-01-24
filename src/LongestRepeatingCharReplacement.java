import java.util.*;

public class LongestRepeatingCharReplacement {
    public int characterReplacement(String s, int k) {
        String[] arr = s.split("");
        int answer = 0;
        //deque에 문자를 하나씩 담는다.
        Deque<String> deque = new ArrayDeque<>();
        //map에 문자와 deque에 그 문자가 몇번 있는지 적는다.
        HashMap<String, Integer> map = new HashMap<>();
        for (int i=0; i<arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i])+1);
            }
            else {
                map.put(arr[i], 1);
            }
            deque.addLast(arr[i]);
            //문자열에 제일 많이 있는 문자를 기준으로 다른 문자들이 바뀌어야하는 것이기 때문에
            //Collections.max(max.values())를 이용해서 문자열에서 제일 많은 문자가 얼마나 있는지 확인하고,
            //문자열의 길이에서 그 수를 빼준 값을 k와 계속 비교하면서 deque의 앞에서 문자를 뺄것인지 아닌지 확인한다.
            int max = Collections.max(map.values());
            if (deque.size()-max > k) {
                while (deque.size()-Collections.max(map.values()) > k) {
                    String word = deque.pollFirst();
                    map.put(word, map.get(word)-1);
                }
            }
            answer = Math.max(answer, deque.size());
        }
        return answer;
    }
}
