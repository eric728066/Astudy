import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static Queue<int[]> q = new LinkedList<>();
	static Queue<String[]> direction = new LinkedList<>();
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int dir = 1;
	static int time = 0;
	static int cntDir;
	static String sDir;
	static int n,k;
	
	static void snakeMove(int r, int c) {
		
		if(time == cntDir) {
			if("D".equals(sDir)) { 
				dir = (dir + 1)%4;
			}else if ("L".equals(sDir)) {
				dir = (dir + 3)%4;
			}
			if(!direction.isEmpty()) {
				String[] x = direction.poll();
				int y = Integer.parseInt(x[0]);
				String z = x[1];
				cntDir = y;
				sDir = z;
			}
		}
		
		int nr = r + dr[dir];
		int nc = c + dc[dir];
		time += 1;
		
		//종료 조건
		if(nr<0 || nc<0 || nr>=n || nc>=n || visited[nr][nc]) {
			return;
		}
        
		//이동
		q.offer(new int[] {nr,nc});
		if(map[nr][nc] == 1) {
			map[nr][nc] = 0;
		} else {
			int[] v = q.poll();
			visited[v[0]][v[1]] = false;
		}
		visited[nr][nc] = true;
		snakeMove(nr,nc);
	}
	

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n][n];
		for (int i = 0; i < k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			map[a][c] = 1;
		}
		int l = Integer.parseInt(br.readLine());
		for (int i = 0; i < l; i++) {
			StringTokenizer s1 = new StringTokenizer(br.readLine());
			String f = s1.nextToken();
			String sec = s1.nextToken();
			direction.offer(new String[] {f,sec});
		}
		
		if(!direction.isEmpty()) {
			String[] x = direction.poll();
			int y = Integer.parseInt(x[0]);
			String z = x[1];
			cntDir = y;
			sDir = z;
		}
		q.offer(new int[] {0,0});
		snakeMove(0,0);
		
		
		System.out.println(time);
	}

}