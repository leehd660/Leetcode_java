public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int answer = nums[0];
        for (int i=1; i<nums.length; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
            answer = Math.max(answer, dp[i]);
        }
        return answer;
    }
}
