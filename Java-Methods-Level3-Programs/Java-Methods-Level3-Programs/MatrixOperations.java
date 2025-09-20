class MatrixCalculator {
    
    public int[][] createRandomMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = (int) (Math.random() * 10) + 1;
            }
        }
        return matrix;
    }
    
    public int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }
    
    public int[][] subtractMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }
    
    public int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int cols2 = matrix2[0].length;
        int[][] result = new int[rows1][cols2];
        
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
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
}

public class MatrixOperations {
    public static void main(String[] args) {
        MatrixCalculator calculator = new MatrixCalculator();
        
        int[][] matrix1 = calculator.createRandomMatrix(3, 3);
        int[][] matrix2 = calculator.createRandomMatrix(3, 3);
        
        calculator.displayMatrix(matrix1, "Matrix 1:");
        calculator.displayMatrix(matrix2, "Matrix 2:");
        
        int[][] sum = calculator.addMatrices(matrix1, matrix2);
        calculator.displayMatrix(sum, "Addition:");
        
        int[][] difference = calculator.subtractMatrices(matrix1, matrix2);
        calculator.displayMatrix(difference, "Subtraction:");
        
        int[][] product = calculator.multiplyMatrices(matrix1, matrix2);
        calculator.displayMatrix(product, "Multiplication:");
    }
}
