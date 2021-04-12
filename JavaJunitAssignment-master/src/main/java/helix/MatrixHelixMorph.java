package helix;

public class MatrixHelixMorph {

    /**
     * @param inMatrix
     * @return a matrix that is morphed into a helix version of inMatrix
     */
    public static int[][] helix( int[][] inMatrix) {

        if (inMatrix == null || inMatrix.length == 0)
            return null;

        int rows = inMatrix.length;
//        int cols = inMatrix[0].length;

        int cols = 0;

        if (rows > 0) {
            cols = inMatrix[0].length;

            for (int i = 1; i < inMatrix.length; i++) {
                if (cols != inMatrix[i].length) {
                    return null;
                }
            }
        }

        int spiralArray[][] = new int[rows][cols];
        int oneDimArray[] = new int[rows * cols];

        oneDimArray = convert2Dimto1Dim(inMatrix, rows, cols);

        ToSpiral(rows, cols, oneDimArray, spiralArray);

        //return morphed matrix
        return spiralArray;
    }//enf of helix

    // Function to make a Spiral array
    static void ToSpiral(int lastRow, int lastCol, int oneDimArray[], int spiralArray[][]) {

        int count = 0;
        //start from first row/ column
        int firstRow = 0;
        int firstCol = 0;

        while (firstRow < lastRow && firstCol < lastCol) {

            // Set the first row + go to the next row (row++)

            for (int i = firstCol; i < lastCol; ++i) {
                spiralArray[firstRow][i] = oneDimArray[count];
                count++;
            }

            firstRow++;

            // Set the last column + go to the previous column (col--)

            for (int i = firstRow; i < lastRow; ++i) {
                spiralArray[i][lastCol - 1] = oneDimArray[count];
                count++;
            }
            lastCol--;

            // Set the last row + go to the previous row (row--)

            if (firstRow < lastRow) {
                for (int i = lastCol - 1; i >= firstCol; --i) {
                    spiralArray[lastRow - 1][i] = oneDimArray[count];
                    count++;
                }
                lastRow--;
            }

            // Set the first column + go to the next column (col++)

            if (firstCol < lastCol) {
                for (int i = lastRow - 1; i >= firstRow; --i) {
                    spiralArray[i][firstCol] = oneDimArray[count];
                    count++;
                }
                firstCol++;
            }
        } //end of while
    }//end of method


    // Function to convert 2 Dimensional array to 1 Dimensional array
    public static int[] convert2Dimto1Dim(int y[][], int m, int n) {

        int count = 0;
        int x[] = new int[m * n];

        // Store value 2D Matrix To 1D array
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                x[count] = y[i][j];
                count++;
            }
        }
        return x;
    }//end of method

} //end of class