import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] newArr = new int[intervals.length+1][2];
        newArr[0] = newInterval;
        for (int i=1; i<intervals.length+1; i++) {
            newArr[i] = intervals[i-1];
        }
        for (int i=1; i<newArr.length; i++) {
            if (newArr[i-1][0] > newArr[i][0]) {
                int[] keepArr = newArr[i-1];
                newArr[i-1] = newArr[i];
                newArr[i] = keepArr;
            }
            else if (newArr[i-1][0] == newArr[i][0]) {
                if (newArr[i-1][1] >= newArr[i][1]) {
                    int[] keepArr = newArr[i-1];
                    newArr[i-1] = newArr[i];
                    newArr[i] = keepArr;
                }
            }
            else {
                break;
            }
        }
        List<int[]> list = new ArrayList<>();
        for (int i=0; i<newArr.length-1; i++) {
            if (newArr[i][1] >= newArr[i+1][0]) {
                int minNum = newArr[i][0];
                int maxNum = Math.max(newArr[i][1], newArr[i+1][1]);
                int[] mergeArr = {minNum, maxNum};
                newArr[i+1] = mergeArr;
            }
            else {
                list.add(newArr[i]);
            }
        }
        list.add(newArr[newArr.length-1]);
        int[][] newIntervals = new int[list.size()][2];
        for (int i=0; i<list.size(); i++) {
            newIntervals[i] = list.get(i);
        }
        return newIntervals;
    }


    // intervals의 array를 boolean[]에 체크해서 문제를 해결하려고 했지만 (0,0)과 같은 input값이 있다는 것을 알고 다른 방법으로 접근 시도.
//        public int[][] insert(int[][] intervals, int[] newInterval) {
//        int totalNum = 0;
//        if (intervals.length == 0) {
//            totalNum = newInterval[1];
//        }
//        else {
//            totalNum = Math.max(intervals[intervals.length - 1][1], newInterval[1]);
//        }
//        boolean[] check = new boolean[totalNum+1];
//        for (int i=0; i<intervals.length; i++) {
//            for (int j=intervals[i][0]; j<intervals[i][1]; j++) {
//                check[j] = true;
//            }
//        }
//        for (int i=newInterval[0]; i<newInterval[1]; i++) {
//            check[i] = true;
//        }
//        for (boolean s : check) {
//            System.out.println(s);
//        }
//        List<int[]> list = new ArrayList<>();
//        boolean test = false;
//        int startNum = 0;
//        int finNum = 0;
//        for (int i=1; i<=totalNum; i++) {
//            if (!test && check[i]) {
//                startNum = i;
//                test = true;
//            }
//            else if (test && !check[i]) {
//                finNum = i;
//                test = false;
//                int[] arr = {startNum, finNum};
//                System.out.println(startNum);
//                System.out.println(finNum);
//                list.add(arr);
//            }
//        }
//        int[][] newIntervals = new int[list.size()][2];
//        for (int i=0; i< list.size(); i++) {
//            newIntervals[i][0] = list.get(i)[0];
//            newIntervals[i][1] = list.get(i)[1];
//        }
//        return newIntervals;
//    }
}
