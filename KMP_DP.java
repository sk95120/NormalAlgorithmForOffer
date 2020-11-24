public class KMP_DP {
	
	private int[][] dp;
	private String pat;
	
	public KMP_DP(String pat) {
		this.pat = pat;
		int M = pat.length();
		dp = new int[M][256];
		dp[0][pat.charAt(0)] = 1; //base case
		int X = 0;
		for(int j = 1 ; j < M ; j++) {
			for (int c = 0 ; c < 256 ; c++) {
				dp[j][c] = dp[X][c];
			}
			dp[j][pat.charAt(j)] = j + 1;
			X = dp[X][pat.charAt(j)];
		}
	}
	
	public int search(String txt) {
		int M = pat.length();
		int N = txt.length();
		
		int j = 0;
		for (int i = 0 ; i < N ; i++) {
			j = dp[j][txt.charAt(j)];
			if (j == M) 
			return i - M + 1;
		}
		return -1;
	}
	
}