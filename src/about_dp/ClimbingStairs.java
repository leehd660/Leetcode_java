package about_dp;

public class ClimbingStairs {
    public int climbStairs(int n) {
        int answer = 0;
        // dp1[i]는 i-2번째 계단을 무조건 밟고 i-1번째 계단을 밟는 경우의 수
        // dp2[i]는 i-2번째 계단을 밟지 않고 i-1번째 계단을 밟는 경우의 수
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        if (n==1) {
            dp1[0] = 1;
            dp2[0] = 0;
        }
        else if (n==2) {
            dp1[1] = 1;
            dp2[1] = 1;
        }
        else {
            dp1[0] = 1;
            dp2[0] = 0;
            dp1[1] = 1;
            dp2[1] = 1;
            for (int i=2; i<n; i++) {
                dp1[i] = dp1[i-1] + dp2[i-1];
                dp2[i] = dp1[i-2] + dp2[i-2];
            }
        }
        answer = dp1[n-1] + dp2[n-1];
        return answer;
    }
}
