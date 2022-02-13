import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PacificAtlanticWaterFlow {
    private static boolean[][] pacificArr;
    private static boolean[][] atlanticArr;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        pacificArr = new boolean[heights.length][heights[0].length];
        atlanticArr = new boolean[heights.length][heights[0].length];
        Deque<int[]> deque1 = new ArrayDeque<>();
        Deque<int[]> deque2 = new ArrayDeque<>();
        for (int i=0; i<heights.length; i++) {
            int[] arr1 = {i,0};
            int[] arr2 = {i,heights[0].length-1};
            pacificArr[i][0] = true;
            atlanticArr[i][heights[0].length-1] = true;
            deque1.add(arr1);
            deque2.add(arr2);
        }
        for (int i=0; i<heights[0].length; i++) {
            int[] arr1 = {0,i};
            int[] arr2 = {heights.length-1, i};
            pacificArr[0][i] = true;
            atlanticArr[heights.length-1][i] = true;
            deque1.add(arr1);
            deque2.add(arr2);
        }
        PclimbAbility(deque1, heights);
        AclimbAbility(deque2, heights);
        List<List<Integer>> answerList = new ArrayList<>();
        for (int i=0; i<heights.length; i++) {
            for (int j=0; j<heights[0].length; j++) {
                if (pacificArr[i][j] && atlanticArr[i][j]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    answerList.add(list);
                }
            }
        }
        return answerList;
    }

    static void PclimbAbility (Deque<int[]> deque, int[][] heights) {
        while (!deque.isEmpty()) {
            int x = deque.peekFirst()[0];
            int y = deque.pollFirst()[1];
            if (x-1>=0 && !pacificArr[x-1][y] && heights[x][y]<=heights[x-1][y]) {
                int[] arr = {x-1,y};
                deque.add(arr);
                pacificArr[x-1][y] = true;
            }
            if (y-1>=0 && !pacificArr[x][y-1] && heights[x][y]<=heights[x][y-1]) {
                int[] arr = {x,y-1};
                deque.add(arr);
                pacificArr[x][y-1] = true;
            }
            if (x+1<heights.length && !pacificArr[x+1][y] && heights[x][y]<=heights[x+1][y]) {
                int[] arr = {x+1,y};
                deque.add(arr);
                pacificArr[x+1][y] = true;
            }
            if (y+1<heights[0].length && !pacificArr[x][y+1] && heights[x][y]<=heights[x][y+1]) {
                int[] arr = {x,y+1};
                deque.add(arr);
                pacificArr[x][y+1] = true;
            }
        }
    }

    static void AclimbAbility (Deque<int[]> deque, int[][] heights) {
        while (!deque.isEmpty()) {
            int x = deque.peekFirst()[0];
            int y = deque.pollFirst()[1];
            if (x-1>=0 && !atlanticArr[x-1][y] && heights[x][y]<=heights[x-1][y]) {
                int[] arr = {x-1,y};
                deque.add(arr);
                atlanticArr[x-1][y] = true;
            }
            if (y-1>=0 && !atlanticArr[x][y-1] && heights[x][y]<=heights[x][y-1]) {
                int[] arr = {x,y-1};
                deque.add(arr);
                atlanticArr[x][y-1] = true;
            }
            if (x+1<heights.length && !atlanticArr[x+1][y] && heights[x][y]<=heights[x+1][y]) {
                int[] arr = {x+1,y};
                deque.add(arr);
                atlanticArr[x+1][y] = true;
            }
            if (y+1<heights[0].length && !atlanticArr[x][y+1] && heights[x][y]<=heights[x][y+1]) {
                int[] arr = {x,y+1};
                deque.add(arr);
                atlanticArr[x][y+1] = true;
            }
        }
    }
}
