public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {1,3,6,7,9,4,10,5,6};
        System.out.println(lengthOfLIS(arr));
    }
    public static int lengthOfLIS(int[] nums) {
        int maxNum = 0;
        int[] dp = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            for (int j=i-1; j>=0; j--) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
            if (dp[i]==0) {
                dp[i] = 1;
            }
            maxNum = Math.max(dp[i],maxNum);
        }
        return maxNum;
    }
}
