public class HouseRobber {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int maxNum = dp[0];
        if (nums.length>=2) {
            dp[1] = nums[1];
            maxNum = Math.max(maxNum,dp[1]);
            for (int i=2; i<nums.length; i++) {
                for (int j=i-2; j>=0; j--) {
                    dp[i] = Math.max(dp[j]+nums[i],dp[i]);
                }
                maxNum = Math.max(maxNum,dp[i]);
            }
        }
        return maxNum;
    }
}
