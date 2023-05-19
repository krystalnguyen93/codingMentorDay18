package day18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class factor {
	public static void main(String[] args) {
		int n = 16;
		int k = 4;
		System.out.println("The kth factor is: " + kthFactor(n, k));
	}

	public static int kthFactor(int n, int k) {
		List<Integer> factors = new ArrayList<>();

		for (int i = 1; i <= (int) Math.sqrt(n); i++) {
			if (n % i == 0) {
				factors.add(i);
				if (n / i != i) {
					factors.add(n / i);
				}
			}
		}

		Collections.sort(factors);
		if (k <= factors.size()) {
			return factors.get(k - 1);
		}
		return -1;
	}
}
