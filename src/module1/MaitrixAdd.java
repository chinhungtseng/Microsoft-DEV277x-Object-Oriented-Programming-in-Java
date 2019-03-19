/*
 * Write a method named matrixAdd that accepts a pair of two-dimensional arrays of integers as parameters, treats the arrays as 2D 
 * matrices and adds them, returning the result. The sum of two matrices A and B is a matrix C where for every row i and column j, Cij = Aij
 * + Bij. You may assume that the arrays passed as parameters have the same dimensions.
 * 
 */

package module1;

public class MaitrixAdd {

	public static void main(String[] args) {
		int[][] a = {{1, 2}, {3, 4}};
		int[][] b = {{1, 2}, {2, 3}};
		int[][] d = matrixAdd(a, b);
		for (int i = 0; i < d.length; i++) {
			for (int j = 0; j < d[i].length; j++) {
				System.out.println(d[i][j]);
			}
		}

	}

	public static int[][] matrixAdd(int[][] a, int[][] b) {

		int aLength = a.length;
		int bLength = b.length;
		int aRowLength = a[(a.length) - 1].length;
		int bRowLength = b[(b.length) - 1].length;
		int ii = 0;
		int jj = 0;

		if (aLength >= bLength) {
			ii = aLength;
		} else {
			ii = bLength;
		}
		if (aRowLength >= bRowLength) {
			jj = aRowLength;
		} else {
			jj = bRowLength;
		}

		int[][] c = new int[ii][jj];

		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[i].length; j++) {
				c[i][j] = a[i][j] + b[i][j];
			}
		}
		return c;
	}
}
