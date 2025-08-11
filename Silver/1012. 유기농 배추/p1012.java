package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1012 {
	
	static int [][] map;
	static boolean [][] visited;
	static int [] dr = {-1,0,1,0};
	static int [] dc = {0,1,0,-1};
	static int n, m, k;
	
	static void dfs(int r, int c) {
		
		visited[r][c] = true;
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr<0||nc<0||nr>=n||nc>=m) continue;
			if(map[nr][nc] == 0) continue;
			if(visited[nr][nc]) continue;
			
			dfs(nr,nc);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			map = new int[n][m];
			visited = new boolean[n][m];
			int count = 0;
			
			for (int j = 0; j < k; j++) {
				StringTokenizer s = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(s.nextToken());
				int b = Integer.parseInt(s.nextToken());
				map[a][b] = 1;
			}
			
			for (int k = 0; k < n; k++) {
				for (int u = 0; u < m; u++) {
					if(map[k][u] == 1 && !visited[k][u]) {
						dfs(k,u);
						count += 1;
					}
				}
			}
			
			System.out.println(count);
			
		}
	}

}
