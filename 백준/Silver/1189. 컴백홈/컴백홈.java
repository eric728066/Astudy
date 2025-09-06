import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static char[][] map;
	static int n, m, k;
	static boolean[][] visit;
	static int count = 0;
	
	static void dfs(int r, int c, int move) {
	    
		if(r == 0 && c == m-1) {
			if(move == k) {
				count +=1;
			}
			return;
		}
		
		visit[r][c] = true;
	    
	    for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr<0||nc<0||nr>=n||nc>=m) continue;
			
			if(!visit[nr][nc] && map[nr][nc] != 'T') {
				dfs(nr,nc, move + 1);
			}
		}
	    visit[r][c] = false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		visit = new boolean[n][m];
		

		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		dfs(n-1,0,1);
		
		System.out.println(count);
	}

}
