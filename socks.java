package day18;

import java.util.HashMap;
import java.util.Map;

public class socks {
	public static void main(String[] args) {
		int[] socks = { 10, 20, 20, 10, 10, 30, 50, 10, 20 };
		int n = socks.length;
		System.out.println("Number of sock pair is: " + sockMerchant(n, socks));

	}

	public static int sockMerchant(int n, int[] array) {
		Map<Integer, Integer> sockCount = new HashMap<>();
		int sockPair = 0;

		// so sock cua moi color
		for (int color : array) {
			if (sockCount.containsKey(color)) {
				sockCount.put(color, sockCount.get(color) + 1);
			} else {
				sockCount.put(color, 1);
			}
		}

		// so sock pair
		for (int sock : sockCount.values()) {
			sockPair += sock / 2;
		}
		return sockPair;
	}
}
