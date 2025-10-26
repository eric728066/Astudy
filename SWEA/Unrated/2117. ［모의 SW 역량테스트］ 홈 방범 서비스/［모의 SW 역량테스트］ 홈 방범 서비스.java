import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	static int n, m;
	static int[][] map;
	static int maxHome;
	
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	static int bfs(int r, int c, int K) {
		boolean[][] visited = new boolean[n][n];
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {r,c,1});
		visited[r][c] = true;
		
		int cnt = 0;
		if(map[r][c] == 1) cnt++;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cr = cur[0];
			int cc = cur[1];
			int depth = cur[2];
			
			if(depth == K) continue;
			
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if(nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
				if(visited[nr][nc]) continue;
				
				visited[nr][nc] = true;
				q.offer(new int[] {nr,nc, depth + 1});
				if(map[nr][nc] == 1) cnt++;
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			map = new int[n][n];
			
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				for (int l = 0; l < n; l++) {
					map[j][l] = Integer.parseInt(st.nextToken());
				}
			}
			
			maxHome = 0;
			
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					for (int K = 1; K <= n+1; K++) {
						int cost = K*K + (K-1)*(K-1);
						int cnt = bfs(r,c,K);
						if(cnt*m >= cost) {
							maxHome = Math.max(maxHome, cnt);
						}
					}
				}
			}
			
			bw.write("#" + i + " " + maxHome + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
		
	}

}
