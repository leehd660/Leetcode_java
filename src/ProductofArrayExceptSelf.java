import java.util.Arrays;

public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        //O(n)으로 해결해라..
        int[] answer = new int[nums.length];
        Arrays.fill(answer,1);
        //그림 그렸을 때 nums[i][i]를 제외하고 보면 위쪽 삼각형과 아래 삼각형으로 나눌 수 있음
        //아래와 위를 각각 나눠서 dp로 해결.
        int upperDp = 1;
        for (int i=1; i<nums.length; i++) {
            upperDp *= nums[i-1];
            answer[i] *= upperDp;
        }
        int downDp = 1;
        for (int i=nums.length-2; i>=0; i--) {
            downDp *= nums[i+1];
            answer[i] *= downDp;
        }
        return answer;
    }
}
