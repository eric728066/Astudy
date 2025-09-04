import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int r;
	static int c;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int[][] map;
	
	static void bfs(int a, int b) {
		Queue<int[]> q = new LinkedList<>();
		boolean [][] visited = new boolean [r][c];
		visited[a][b] = true;
		
		q.offer(new int[] {a,b});
		
		while(!q.isEmpty()) {
			int [] curr = q.poll();
			int x = curr[0];
			int y = curr[1];
			
			for (int i = 0; i < 4; i++) {
				int nr = x + dr[i];
				int nc = y + dc[i];
				
				if(!(nr<0||nc<0||nr>=r||nc>=c)) {
					if(!visited[nr][nc] && map[nr][nc] == 1) {
						q.offer(new int[] {nr,nc});
						visited[nr][nc] = true;
						map[nr][nc] = map[x][y] + 1;
					}
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new int[r][c];
		
		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		
		bfs(0,0);
		
		System.out.println(map[r-1][c-1]);
	}

}
