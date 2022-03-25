public class HouseRobber2 {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        else {
            int[][] dp = new int[nums.length][2];
            dp[0][0] = nums[0];
            dp[1][1] = nums[1];
            int answer = Math.max(nums[0],nums[1]);
            for (int i=2; i<nums.length; i++) {
                for (int j=i-2; j>=0; j--) {
                    dp[i][0] = Math.max(dp[j][0]+nums[i], dp[i][0]);
                    dp[i][1] = Math.max(dp[j][1]+nums[i], dp[i][1]);
                }
                if (i==nums.length-1) {
                    answer = Math.max(answer, dp[i][1]);
                }
                else {
                    answer = Math.max(answer, Math.max(dp[i][1],dp[i][0]));
                }
            }
            return answer;
        }

    }
}
