package day18;

public class floodFill_dequy {
	public static void main(String[] args) {
		int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };

		int sr = 1;
		int sc = 1;
		int newColor = 2;

		colorFill(image, sr, sc, newColor);

		for (int i = 0; i < image.length; ++i) {
			System.out.println();
			for (int j = 0; j < image[i].length; ++j) {
				System.out.print(image[i][j] + " ");
			}
		}
	}

	public static int[][] colorFill(int[][] image, int sr, int sc, int newColor) {
		int currentColor = image[sr][sc];
		if (currentColor == newColor) {
			return image;
		}
		changeColor(image, sr, sc, currentColor, newColor);
		return image;
	}

	public static void changeColor(int[][] image, int sr, int sc, int currentColor, int newColor) {
		if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != currentColor) {
			return;
		}

		image[sr][sc] = newColor;

		int topRow = sr - 1;
		int bottomRow = sr - 1;
		int leftRow = sc - 1;
		int rightRow = sc - 1;

		changeColor(image, topRow, sc, currentColor, newColor);
		changeColor(image, bottomRow, sc, currentColor, newColor);
		changeColor(image, sr, leftRow, currentColor, newColor);
		changeColor(image, sr, rightRow, currentColor, newColor);
	}
}
