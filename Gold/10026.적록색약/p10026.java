package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p10026 {

	static char map[][];
	static boolean visited[][];
	static int [] dr = {-1, 0, 1, 0};
	static int [] dc = {0, 1, 0, -1};
	static int n;
	static int see;
	static int nosee;
	
	static void dfs(int r, int c, char color) {
		if(visited[r][c]) return;
		
		
		visited[r][c] = true;
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if (nr<0||nc<0||nr>=n||nc>=n) continue;
			if (visited[nr][nc]) continue;
			if (map[nr][nc] != color) continue;
			
			dfs(nr, nc, color);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		visited = new boolean[n][n];
		int [] rgb = new int[3];
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j] == 'R' && visited[i][j] == false) {
					dfs(i,j,'R');
					see += 1;
				} else if(map[i][j] == 'G' && visited[i][j] == false) {
					dfs(i,j,'G');
					see += 1;
				} else if(map[i][j] == 'B' && visited[i][j] == false) {
					dfs(i,j,'B');
					see += 1;
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j] == 'G') {
					map[i][j] = 'R';
				}
			}
		}
		
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j] == 'R' && visited[i][j] == false) {
					dfs(i,j,'R');
					nosee += 1;
				} else if(map[i][j] == 'B' && visited[i][j] == false) {
					dfs(i,j,'B');
					nosee += 1;
				}
			}
		}
		
		System.out.println(see+" "+nosee);
	}

}
