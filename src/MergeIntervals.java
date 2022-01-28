import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] arr = {{1,3},{2,6},{15,18}};
        merge(arr);
    }

    public static int[][] merge(int[][] intervals) {
        //정렬해주기
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                else {
                    return o1[0] - o2[0];
                }
            }
        });
        //List만들기
        List<int[]> list = new ArrayList<>();
        int[] keepArr = new int[2];
        keepArr[0] = intervals[0][0];
        keepArr[1] = intervals[0][1];
        for (int i=0; i< intervals.length; i++) {
//            if (keepArr[0] == 0 && keepArr[1] == 0) {
//                keepArr[0] = intervals[i][0];
//                keepArr[1] = intervals[i][1];
//            }
//            else {
                if (keepArr[1] >= intervals[i][0]) {
                    keepArr[0] = Math.min(keepArr[0], intervals[i][0]);
                    keepArr[1] = Math.max(keepArr[1], intervals[i][1]);
                }
                else {
                    int[] arr = {keepArr[0], keepArr[1]};
                    list.add(arr);
                    keepArr[0] = intervals[i][0];
                    keepArr[1] = intervals[i][1];
                }
//            }
            if (i == intervals.length-1) {
                int[] arr = {keepArr[0], keepArr[1]};
                list.add(arr);
            }
        }
        int[][] answer = list.toArray(new int[list.size()][2]);
        return answer;
    }
}
