package day18;

import java.util.HashMap;
import java.util.Map;

public class floodFill_map {
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

	public static void colorFill(int[][] image, int sr, int sc, int newColor) {
		int row = image.length;
		int column = image[0].length;

		int currentColor = image[sr][sc];
		if (currentColor == newColor)
			return;

		Map<Integer, Integer> checkPixel = new HashMap<>();
		checkPixel.put(sr * column + sc, currentColor);

		while (!checkPixel.isEmpty()) { // loop tiep tuc chay cho den khi trong map checkPixel ko con pixel can xet duyet nua
										
			Map<Integer, Integer> newCheckPixel = new HashMap<>(); // tao map moi luu tru cac gia tri can xet
			
			for (Map.Entry<Integer, Integer> xetduyet : checkPixel.entrySet()) {
				int key = xetduyet.getKey();
				int hang = key / column;
				int cot = key % column;
				int color = xetduyet.getValue();

				// kiem tra xem nhung pixel nao thoa man de thay color
				if (hang - 1 >= 0 && image[hang - 1][cot] == color // kiem tra xem có trung color voi starting position
						&& !newCheckPixel.containsKey((hang - 1) * column + cot)) { // có trong map newCheckPixel chưa, nếu chưa thì add																				
					newCheckPixel.put((hang - 1) * column + cot, color);
				}
				if (hang + 1 < row && image[hang + 1][cot] == color
						&& !newCheckPixel.containsKey((hang + 1) * column + cot)) {
					newCheckPixel.put((hang + 1) * column + cot, color);
				}
				if (cot - 1 >= 0 && image[hang][cot - 1] == color
						&& !newCheckPixel.containsKey(hang * column + (cot - 1))) {
					newCheckPixel.put(hang * column + (cot - 1), color);
				}
				if (cot + 1 < column && image[hang][cot + 1] == color
						&& !newCheckPixel.containsKey(hang * column + (cot + 1))) {
					newCheckPixel.put(hang * column + (cot + 1), color);
				}

				image[hang][cot] = newColor; // cap nhat lại mau moi sau khi da pass qua trinh kiem duyet
			}
			checkPixel = newCheckPixel; // sau khi xet duyet trong
		}

	}

}
