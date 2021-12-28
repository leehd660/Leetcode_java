package about_array;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        boolean test = false;
        for (int i=0; i<nums.length-1; i++) {
            for (int j=i+1; j< nums.length; j++) {
                if (nums[i]+nums[j] == target) {
                    test = true;
                    answer[0] = i;
                    answer[1] = j;
                    break;
                }
            }
            if (test) {
                break;
            }
        }
        return answer;
    }
}
