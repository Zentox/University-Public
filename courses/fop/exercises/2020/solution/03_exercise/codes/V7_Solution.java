/**
 * Returns the multiplied matrices.
 * 
 * @param mat1 first matrix to be multiplied with the second one
 * @param mat2 second matrix to be multiplied with the first one
 * @return the multiplied matrices
 */
int[][] matrixMul(int[][] mat1, int[][] mat2) {

	int rowsMat1 = mat1.length;
	int colsMat1 = mat1[0].length;
	int rowsMat2 = mat2.length;
	int colsMat2 = mat2[0].length;

	// Result matrix
	int[][] mat3 = new int[rowsMat1][colsMat2];

	// Check if the dimension is correct
	if (colsMat1 != rowsMat2) {
		System.err.println("Wrong Dimensions");
		return null;
	}

	// Matrix multiplication
	for (int i = 0; i < rowsMat1; i++) {
		for (int j = 0; j < colsMat1; j++) {
			for (int k = 0; k < colsMat2; k++) {
				mat3[i][k] += mat1[i][j] * mat2[j][k];
			}
		}
	}
	return mat3;
}