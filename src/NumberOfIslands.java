import java.util.ArrayDeque;
import java.util.Deque;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int N = grid.length;
        int M = grid[0].length;
        boolean[][] visited = new boolean[N][M];
        Deque<int[]> deque = new ArrayDeque<>();
        int count = 0;
        int[] xArr = {0,0,1,-1};
        int[] yArr = {1,-1,0,0};
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (!visited[i][j] && Character.compare('1',grid[i][j]) == 0) {
                    visited[i][j] = true;
                    int[] arr = {i,j};
                    deque.add(arr);
                    while (!deque.isEmpty()) {
                        int x = deque.peekFirst()[0];
                        int y = deque.pollFirst()[1];
                        for (int index=0; index<4; index++) {
                            if (x+xArr[index]>=0 && x+xArr[index]<N && y+yArr[index]>=0 && y+yArr[index]<M
                            && Character.compare('1', grid[x+xArr[index]][y+yArr[index]])==0 && !visited[x+xArr[index]][y+yArr[index]]) {
                                visited[x+xArr[index]][y+yArr[index]] = true;
                                int[] innerArr = {x+xArr[index], y+yArr[index]};
                                deque.add(innerArr);
                            }
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }
}
