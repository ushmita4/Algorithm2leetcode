class Solution {
    public int longestCommonSubsequence(String a, String b) {
	int m = a.length();
	int n = b.length();
	
	int[][] sol = new int[m + 1][n + 1];

	for (int sa = 1; sa <= m; sa++) {
		for (int sb = 1; sb <= n; sb++) {
			if (a.charAt(sa - 1) == b.charAt(sb - 1)) {
				sol[sa][sb] = 1 + sol[sa - 1][sb - 1];
			} else {
				sol[sa][sb] = Math.max(sol[sa - 1][sb], sol[sa][sb - 1]);
			}
		}
	}

	return sol[m][n];
}
}
