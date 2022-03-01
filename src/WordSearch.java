import java.util.ArrayList;
import java.util.List;

public class WordSearch {
    private static List<Integer> listX;
    private static List<Integer> listY;
    private static boolean[][] visited;
    private static int[] xArr;
    private static int[] yArr;
    private static String[] wordArr;
    private static boolean answer;

    public boolean exist(char[][] board, String word) {
        answer = false;
        visited = new boolean[board.length][board[0].length];
        xArr = new int[]{1,-1,0,0};
        yArr = new int[]{0,0,1,-1};
        listX = new ArrayList<>();
        listY = new ArrayList<>();
        wordArr = word.split("");
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (board[i][j]==word.charAt(0)) {
                    visited[i][j] = true;
                    listX.add(i);
                    listY.add(j);
                    DFS(board,1);
                    visited[i][j] = false;
                    listX.remove(listX.size() - 1);
                    listY.remove(listY.size() - 1);
                }
                if (answer) {
                    break;
                }
            }
            if (answer) break;
        }
        return answer;
    }
    static void DFS (char[][] board, int num) {
        if (listX.size() == wordArr.length) {
            answer = true;
        }
        else {
            int x = listX.get(listX.size() - 1);
            int y = listY.get(listY.size() - 1);
            for (int i = 0; i < 4; i++) {
                if (x + xArr[i] >= 0 && x + xArr[i] < visited.length && y + yArr[i] >= 0 && y + yArr[i] < visited[0].length) {
                    if (board[x + xArr[i]][y + yArr[i]] == wordArr[num].charAt(0) && !visited[x + xArr[i]][y + yArr[i]]) {
                        visited[x + xArr[i]][y + yArr[i]] = true;
                        listX.add(x + xArr[i]);
                        listY.add(y + yArr[i]);
                        DFS(board, num + 1);
                        visited[x + xArr[i]][y + yArr[i]] = false;
                        listX.remove(listX.size() - 1);
                        listY.remove(listY.size() - 1);
                    }
                }
            }
        }
    }
}
