class AdvancedMatrixCalculator {
    
    public int[][] createRandomMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = (int) (Math.random() * 10) + 1;
            }
        }
        return matrix;
    }
    
    public int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transposed = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }
    
    public double determinant2x2(int[][] matrix) {
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
    }
    
    public double determinant3x3(int[][] matrix) {
        double det = 0;
        det += matrix[0][0] * (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1]);
        det -= matrix[0][1] * (matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0]);
        det += matrix[0][2] * (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]);
        return det;
    }
    
    public double[][] inverse2x2(int[][] matrix) {
        double det = determinant2x2(matrix);
        if (det == 0) return null;
        
        double[][] inverse = new double[2][2];
        inverse[0][0] = matrix[1][1] / det;
        inverse[0][1] = -matrix[0][1] / det;
        inverse[1][0] = -matrix[1][0] / det;
        inverse[1][1] = matrix[0][0] / det;
        return inverse;
    }
    
    public void displayMatrix(int[][] matrix, String title) {
        System.out.println(title);
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public void displayDoubleMatrix(double[][] matrix, String title) {
        System.out.println(title);
        for (double[] row : matrix) {
            for (double element : row) {
                System.out.printf("%.2f\t", element);
            }
            System.out.println();
        }
        System.out.println();
    }
}

public class MatrixAdvancedOperations {
    public static void main(String[] args) {
        AdvancedMatrixCalculator calculator = new AdvancedMatrixCalculator();
        
        int[][] matrix2x2 = calculator.createRandomMatrix(2, 2);
        int[][] matrix3x3 = calculator.createRandomMatrix(3, 3);
        
        calculator.displayMatrix(matrix2x2, "2x2 Matrix:");
        calculator.displayMatrix(matrix3x3, "3x3 Matrix:");
        
        int[][] transposed = calculator.transpose(matrix3x3);
        calculator.displayMatrix(transposed, "Transposed 3x3 Matrix:");
        
        System.out.println("Determinant of 2x2: " + calculator.determinant2x2(matrix2x2));
        System.out.println("Determinant of 3x3: " + calculator.determinant3x3(matrix3x3));
        
        double[][] inverse = calculator.inverse2x2(matrix2x2);
        if (inverse != null) {
            calculator.displayDoubleMatrix(inverse, "Inverse of 2x2 Matrix:");
        } else {
            System.out.println("Matrix is not invertible");
        }
    }
}
