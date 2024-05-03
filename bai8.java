public class bai8 {
    public static void main(String[] args) {
        int[][] A = {{1, 2, 3}, {4, 5, 6}}; 
        int[][] B = {{7, 8}, {9, 10}, {11, 12}}; 

        int m = A.length; 
        int n = A[0].length; 
        int k = B[0].length; 

        int[][] result = multiplyMatrices(A, B, m, n, k);

        
        System.out.println("Tích của hai ma trận là:");
        printMatrix(result);
    }

    
    public static int[][] multiplyMatrices(int[][] A, int[][] B, int m, int n, int k) {
        int[][] result = new int[m][k];

        
        for (int i = 0; i < m; i++) {
           
            for (int j = 0; j < k; j++) {
                
                
                for (int l = 0; l < n; l++) {
                    result[i][j] += A[i][l] * B[l][j];
                }
            }
        }

        return result;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
