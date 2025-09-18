import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int w, h; //배열크기
	static char[][] map;
	static int[][] dist;
	static int[][] dp;
	static List<int[]> positions;
	static int n; // 로봇, 먼지 개수
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static final int inf = 1000000000;
	
	static int[][] bfs(int sr, int sc){
		int[][] d = new int[h][w];
		for(int[] row : d) Arrays.fill(row, -1);
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {sr, sc});
		d[sr][sc] = 0;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr<0 || nc<0 || nr>=h || nc >= w) continue;
				if(map[nr][nc] == 'x') continue;
				if(d[nr][nc] != -1) continue;
				
				d[nr][nc] = d[r][c] + 1;
				q.add(new int [] {nr,nc});
			}
		}
		return d;
	}
	
	static int tsp(int cur, int visit) {
		if(visit == (1<<n) - 1) return 0;
		
		if(dp[cur][visit] != -1) return dp[cur][visit];
		
		int ret = inf;
		for (int next = 0; next < n; next++) {
			if((visit & (1<<next)) != 0) continue; //이미 방문
			if(dist[cur][next] == -1) continue; // 간선의 가중치가 -1 갈 수 없음
			
			ret = Math.min(ret, tsp(next, visit | (1<<next)) + dist[cur][next]);
		}
		
		return dp[cur][visit] = ret;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w == 0 && h == 0) break;
			
			map = new char[h][w];
			positions = new ArrayList<>();
			
			for (int i = 0; i < h; i++) {
				String line = br.readLine();
				for (int j = 0; j < w; j++) {
					map[i][j] = line.charAt(j);
					if(map[i][j] == 'o') {
						positions.add(0,new int[] {i,j});
					} else if(map[i][j] == '*') {
						positions.add(new int[] {i,j});
					}
				}
			}
			
			n = positions.size();
			dist = new int[n][n];
			
			boolean ok = true;
			for (int i = 0; i < n; i++) {
				int[][] d = bfs(positions.get(i)[0],positions.get(i)[1]);
				for (int j = 0; j < n; j++) {
					int r = positions.get(j)[0];
					int c = positions.get(j)[1];
					dist[i][j] = d[r][c];
					if(i != j && dist[i][j] == -1) {
						ok = false;
					}
				}
			}
			
			if(!ok) {
				System.out.println(-1);
				continue;
			}
			
			dp = new int[n][1<<n];
			for(int[] row : dp) Arrays.fill(row,-1);
			
			System.out.println(tsp(0,1));
		}

	}

}
