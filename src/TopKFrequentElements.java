import java.util.*;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        int[] answer = new int[k];
        //map을 이용해서 문자 개수 세기
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if (map.keySet().contains(nums[i])) {
                map.put(nums[i],map.get(nums[i])+1);
            }
            else {
                map.put(nums[i],1);
            }
        }
        //map의 key와 value를 2차원 arr에 넣기
        int[][] arr = new int[map.keySet().size()][2];
        int index = 0;
        for (int i : map.keySet()) {
            arr[index][0] = i;
            arr[index][1] = map.get(i);
            index++;
        }
        //arr의 키값으로 정렬
        Arrays.sort(arr,Comparator.comparingInt(ol -> ol[1]));
        for (int i=0; i<k; i++) {
            answer[i] = arr[arr.length-1-i][0];
        }
        return answer;
    }
}
