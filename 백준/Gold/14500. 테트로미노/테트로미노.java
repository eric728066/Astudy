import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int[][] map;
	static boolean [][] visit;
	static int n,m;
	static int re_sum ;
	static int max = Integer.MIN_VALUE;
	
	static void dfs(int r, int c , int depth, int sum) {
		sum += map[r][c];
		
		visit[r][c] = true;
		
		if(depth == 4) {
			if(re_sum < sum) {
				re_sum = sum;
			}
			visit[r][c] = false;
			return;
		}else {
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr<0|| nc<0 || nr>=n || nc>=m) continue;
				
				if(!visit[nr][nc]) {
					visit[nr][nc] = true;
					dfs(nr,nc,depth+1, sum);
					visit[nr][nc] = false;
				}
			}
		}
		visit[r][c] = false;
		
	}
	
	static void remain(int r, int c) {
		int sum = 0;
		sum += map[r][c];
		
		int subup = 0;
		for (int i = 0; i < 4; i++) {
		    int sub = 0;
		    boolean valid = true;   // <-- 위치 이동
		    for (int j = 0; j < 3; j++) {
		        int nr = r + dr[(i+j)%4];
		        int nc = c + dc[(i+j)%4];
		        if(nr<0|| nc<0 || nr>=n || nc>=m) {
		            valid = false;
		            break;
		        }
		        sub += map[nr][nc];
		    }
		    if(valid) subup = Math.max(subup, sub);
		}
		sum += subup;
		max = Math.max(max, sum);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visit = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				re_sum = Integer.MIN_VALUE;
				dfs(i,j,1,0);
				max = Math.max(max, re_sum);
				remain(i,j);
			}
		}
		System.out.println(max);
	}

}
