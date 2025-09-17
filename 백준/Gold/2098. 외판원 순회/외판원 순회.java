import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static final int inf = 1000000000;
	static int n;
	static int[][] w;
	static int[][] dp;
	
	static int tsp(int cur, int visit) {
		if(visit == (1<<n) - 1) {
			if(w[cur][0] == 0) return inf;
			return w[cur][0];
		}
		
		if(dp[cur][visit] != -1) return dp[cur][visit];
		
		int ret = inf;
		
		for(int next = 0; next < n; next++) {
			if((visit&(1<<next)) == 0 && w[cur][next] != 0) {
				ret = Math.min(ret, tsp(next, visit | (1<<next)) + w[cur][next]);
			}
		}
		return dp[cur][visit] = ret;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		w = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				w[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp = new int[n][1<<n];
		
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}
		
		int result = tsp(0, 1<<0);
		System.out.println(result);

	}

}
