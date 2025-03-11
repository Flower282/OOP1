public class Matrices {
    public static int[][] AddTwoMatrices(int[][] array1, int[][] array2) {
        int row = array1.length;
        int column = array1[0].length;
        int result[][] = new int[row][column];
        //addition of 2 matrices
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = array1[i][j] + array2[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int array1[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int array2[][] = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
        int result[][] = AddTwoMatrices(array1, array2);
        System.out.println("The sum of two matrices is: ");
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }
}
