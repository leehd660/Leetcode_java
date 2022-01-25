import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        //우선 coins를 오름차순으로 정렬
        Arrays.sort(coins);
        //목표 금액이 1부터 amount까지 dp로 해결한다.
        for (int i=1; i<amount+1; i++) {
            //목표금액인 i가 coins 속 coin들보다 크기가 큰지 확인
            for (int j=0; j<coins.length; j++) {
                //크기가 크면
                if (i>=coins[j]) {
                    //i가 이미 만드는 방법이 있는지 확인
                    //있다면
                    if (dp[i] != 0) {
                        //있다고 하더라도 코인하나로 해결할 수 있는지 확인
                        if (i-coins[j]==0) {
                            dp[i] = 1;
                        }
                        else if (dp[i-coins[j]] != 0) {
                            //min을 이용하여 크기 비교
                            dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                        }
                    }
                    else {
                        if (i-coins[j]==0) {
                            dp[i] = 1;
                        }
                        else if (dp[i-coins[j]] != 0) {
                            dp[i] = dp[i - coins[j]]+1;
                        }
                    }
                }
                //크기가 작으면 break
                else {
                    break;
                }
            }
        }
        if (amount!=0 && dp[amount]==0) {
            return -1;
        }
        else {
            return dp[amount];
        }
    }
}
