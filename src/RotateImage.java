public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] rotatedMatrix = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0;j<n; j++) {
                if (!visited[i][j]) {
                    if (i==(n-1)/2 && j==(n-1)/2) {
                        visited[i][j] = true;
                    }
                    else {
                        int keepNum = matrix[i][j];
                        matrix[i][j] = matrix[n-1-j][i];
                        matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                        matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                        matrix[j][n-1-i] = keepNum;
                        visited[i][j] = true;
                        visited[n-1-j][i] = true;
                        visited[n-1-i][n-1-j] = true;
                        visited[j][n-1-i] = true;
                    }
                }
            }
        }
    }
}
