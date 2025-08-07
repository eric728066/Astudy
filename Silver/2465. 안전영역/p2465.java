package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2465 {
	
	static int [][] map;
	static boolean [][] visit;
	static int [] dr = {-1,0,1,0};
	static int [] dc = {0,1,0,-1};
	static int n;
	
	static void dfs(int r, int c, int h) {
		visit[r][c] = true;
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr<0||nc<0||nr>=n||nc>=n) continue;
			if(visit[nr][nc]) continue;
			if(map[nr][nc] <= h) continue;
			
			dfs(nr,nc,h);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		map = new int [n][n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int maxHeight = 0;
		for (int i = 0; i < n; i++) {
		    for (int j = 0; j < n; j++) {
		        maxHeight = Math.max(maxHeight, map[i][j]);
		    }
		}
		int cnt = 0;
		int max = 0;
		for (int k = 0; k < maxHeight; k++) {
			visit = new boolean [n][n];
			for (int i = 0; i < n; i++) {
			    for (int j = 0; j < n; j++) {
			        if(map[i][j] > k && !visit[i][j]) {
			        	dfs(i,j,k);
			        	cnt += 1;
			        }
			    }
			}
			if(max<cnt) {
				max = cnt;
			}
			cnt = 0;
		}
		
		System.out.println(max);
	}

}
