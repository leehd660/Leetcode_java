import java.util.HashSet;
import java.util.Set;

public class SetMetrixZeroes {
    public void setZeroes(int[][] matrix) {
        Set<Integer> xSet = new HashSet<>();
        Set<Integer> ySet = new HashSet<>();
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    xSet.add(i);
                    ySet.add(j);
                }
            }
        }
        for (int i : xSet) {
            for (int j=0; j<matrix[i].length; j++) {
                matrix[i][j] = 0;
            }
        }
        for (int i : ySet) {
            for (int j=0; j<matrix.length; j++) {
                matrix[j][i] = 0;
            }
        }
    }
}
