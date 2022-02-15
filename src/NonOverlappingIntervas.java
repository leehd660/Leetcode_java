import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervas {
    public static void main(String[] args) {
        int[][] arr = {{-52,31},{-73,-26},{82,97},{-65,-11},{-62,-49},{95,99},{58,95},{-31,49},{66,98},{-63,2},{30,47},{-40,-26}};
        System.out.println(eraseOverlapIntervals(arr));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1]-o2[1];
                }
                else {
                    return o1[0]-o2[0];
                }
            }
        });
        int[] dp = new int[intervals.length];
        dp[0]=1;
        int answer = 1;
        for (int i=1; i<intervals.length; i++) {
            for (int j=i-1; j>=0; j--) {
                //겹치면 continue
                if (intervals[i][0] >= intervals[j][0] && intervals[i][0] < intervals[j][1]) {
                    continue;
                }
                //안겹치면
                else {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    break;
                }
            }
            if (dp[i]==0) {
                dp[i] = 1;
            }
            answer = Math.max(answer, dp[i]);
        }
        return intervals.length-answer;
    }

//    public static int eraseOverlapIntervals(int[][] intervals) {
//        //배열 정렬
//        Arrays.sort(intervals, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if (o1[0] == o2[0]) {
//                    return o1[1]-o2[1];
//                }
//                else {
//                    return o1[0]-o2[0];
//                }
//            }
//        });
//        //정렬해서 겹치는게 있으면, 크기가 큰거를 제거함.
//        //겹치지 않으면 list에 추가
//        List<int[]> list = new ArrayList<>();
//        int[] arr = {intervals[0][0], intervals[0][1]};
//        list.add(arr);
//        for (int i=1; i<intervals.length; i++) {
//            if (intervals[i][0] >= list.get(list.size()-1)[0] && intervals[i][0] < list.get(list.size()-1)[1]) {
//                if (intervals[i][1] - intervals[i][0] >= list.get(list.size()-1)[1] - list.get(list.size()-1)[0]) {
//                    continue;
//                }
//                else {
//                    list.remove(list.size()-1);
//                    int[] arr1 = {intervals[i][0],intervals[i][1]};
//                    list.add(arr1);
//                }
//            }
//            else {
//                int[] arr1 = {intervals[i][0],intervals[i][1]};
//                list.add(arr1);
//            }
//        }
//        return intervals.length-list.size();
//    }
}
