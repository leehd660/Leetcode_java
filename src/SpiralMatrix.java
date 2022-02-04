import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        //1:y++, 2:x++, 3:y--, 4:x--
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i=1; i<=4; i++) {
            deque.addLast(i);
        }
        List<Integer> answer = new ArrayList<>();
        int x = 0;
        int y = 0;
        answer.add(matrix[x][y]);
        //이미 지난 것은 200으로 값을 바꿔줌
        matrix[x][y] = 200;
        while (true) {
            if (answer.size()== matrix.length*matrix[0].length){
                break;
            }
            else {
                int num = deque.pollFirst();
                switch (num) {
                    case 1:
                        while (true) {
                            try {
                                if (matrix[x][y + 1] == 200) {
                                    break;
                                } else {
                                    y++;
                                    answer.add(matrix[x][y]);
                                    matrix[x][y] = 200;
                                }
                            } catch (IndexOutOfBoundsException e) {
                                break;
                            }
                        }
                        break;
                    case 2:
                        while (true) {
                            try {
                                if (matrix[x+1][y] == 200) {
                                    break;
                                } else {
                                    x++;
                                    answer.add(matrix[x][y]);
                                    matrix[x][y] = 200;
                                }
                            } catch (IndexOutOfBoundsException e) {
                                break;
                            }
                        }
                        break;
                    case 3:
                        while (true) {
                            try {
                                if (matrix[x][y-1] == 200) {
                                    break;
                                } else {
                                    y--;
                                    answer.add(matrix[x][y]);
                                    matrix[x][y] = 200;
                                }
                            } catch (IndexOutOfBoundsException e) {
                                break;
                            }
                        }
                        break;
                    case 4:
                        while (true) {
                            try {
                                if (matrix[x-1][y] == 200) {
                                    break;
                                } else {
                                    x--;
                                    answer.add(matrix[x][y]);
                                    matrix[x][y] = 200;
                                }
                            } catch (IndexOutOfBoundsException e) {
                                break;
                            }
                        }
                        break;
                }
                deque.addLast(num);
            }
        }
        return answer;
    }
}
