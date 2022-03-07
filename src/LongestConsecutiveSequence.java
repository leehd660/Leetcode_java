import java.util.PriorityQueue;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums.length != 0) {
//            PriorityQueue를 이용해서 간단하게 해결
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int i : nums) {
                queue.add(i);
            }
            int answer = 0;
            int count = 1;
            int keepNum = queue.poll();
            int len = queue.size();
            while (!queue.isEmpty()) {
                if (queue.peek() - keepNum == 1) {
                    count++;
                }
                else if (queue.peek() == keepNum) {
                    keepNum = queue.poll();
                    continue;
                }
                else {
                    answer = Math.max(answer, count);
                    count = 1;
                }
                keepNum = queue.poll();
            }
            answer = Math.max(answer, count);
            return answer;
        }
        else {
            return 0;
        }
    }
}
