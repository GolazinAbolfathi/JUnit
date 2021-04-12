package helix;

import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class MatrixHelixMorphTest {

    /** Check if two integer matrices have the same contents
     *
     * @param matrix1
     * @param matrix2
     * @return true if the contents of matrix1 and matrix2 are identical and false otherwise
     */
    public static boolean testEqual(int[][] matrix1, int[][] matrix2) {

        /*
            Basic sanity checking:
                Verify that lengths are equal
         */
        if (matrix1 == null || matrix2 == null) {
            return true;
        }
        if (matrix1.length != matrix2.length) {
            return false;
        }
        if (matrix1[0].length != matrix2[0].length) {
            return false;
        }

        /*
            Test the contents of the matrices
         */
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                if (matrix1[i][j] != matrix2[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    @Test
    public void test2x2() {
        int[][] inMatrix  = { {1, 2}, {3, 4} };
        int[][] expOutput = { {1, 2}, {4, 3} };

        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void test4x3() {
        int[][] inMatrix  = { {2,3,1,6}, {12,13,5,7},{8,4,11,9} };
        int[][] expOutput = { {2,3,1,6}, {4,11,9,12},{8,7,5,13} };

        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    //........Test for Col-Row > 2
    @Test
    public void test1x5() {
        int[][] inMatrix  = { {1,2,3,4,5} };
        int[][] expOutput = { {1,2,3,4,5} };

        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void test1x6() {
        int[][] inMatrix  = { {1},{2},{3},{4},{5},{6}};
        int[][] expOutput = { {1},{2},{3},{4},{5},{6}};

        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void test3x6() {
        int[][] inMatrix  = { {1,2,3},{4,5,6},{7,8,9},{10,11,12},{13,14,15},{16,17,18} };
        int[][] expOutput = { {1,2,3},{14,15,4},{13,16,5},{12,17,6},{11,18,7},{10,9,8} };

        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }
    @Test
    public void test2x6() {
        int[][] inMatrix  = { {1,2},{3,4},{5,6},{7,8},{9,10},{11,12} };
        int[][] expOutput = { {1,2},{12,3},{11,4},{10,5},{9,6},{8,7} };

        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void test1x1() {
        int[][] inMatrix  = { {1} };
        int[][] expOutput = { {1} };
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    // ADD TESTS TO CHECK PARTITIONS
}
