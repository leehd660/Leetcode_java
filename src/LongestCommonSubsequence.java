public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String text1 = "acc";
        String text2 = "ccc";
        int answer = longestCommonSubsequence(text1,text2);
        System.out.println(answer);
    }
    public static int longestCommonSubsequence(String text1, String text2) {
        int num1 = text1.length();
        int num2 = text2.length();
        String[] text1Arr = text1.split("");
        String[] text2Arr = text2.split("");
        int[][] dp = new int[num1][num2];
        if (text1Arr[0].equals(text2Arr[0])) {
            dp[0][0] = 1;
        }
        for (int i=1; i<num2; i++) {
            if (text1Arr[0].equals(text2Arr[i])) {
                dp[0][i] = 1;
            }
            else {
                dp[0][i] = dp[0][i-1];
            }
        }
        for (int i=1; i<num1; i++) {
            if (text2Arr[0].equals(text1Arr[i])) {
                dp[i][0] = 1;
            }
            else {
                dp[i][0] = dp[i-1][0];
            }
        }
        for (int i=1; i<num1; i++) {
            for (int j=1; j<num2; j++) {
                if (text1Arr[i].equals(text2Arr[j])) {
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[num1-1][num2-1];
    }
}
