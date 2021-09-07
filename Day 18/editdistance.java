class Solution {
   public int minDistance(String word1, String word2) {
	int m = word1.length();
	int n = word2.length();

	int[][] sol = new int[m + 1][n + 1];

	for (int w1 = 0; w1 <= m; w1++) {
		sol[w1][0] = w1;
	}
	for (int w2 = 0; w2 <= n; w2++) {
		sol[0][w2] = w2;
	}

	for (int w1 = 1; w1 <= m; w1++) {
		for (int w2 = 1; w2 <= n; w2++) {
			if (word1.charAt(w1 - 1) == word2.charAt(w2 - 1)) {
				sol[w1][w2] = sol[w1 - 1][w2 - 1];
			} else {
				int insert = 1 + sol[w1 - 1][w2];
				int delete = 1 + sol[w1][w2 - 1];
				int replace = 1 + sol[w1 - 1][w2 - 1];
				sol[w1][w2] = Math.min(Math.min(insert, delete), replace);
			}
		}
	}

	return sol[m][n];
}
}
