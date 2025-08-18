import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int r;
	static int c;
	static int h;
	static int[] dh = {0,0,0,0,1,-1};
	static int[] dr = {-1,0,1,0,0,0};
	static int[] dc = {0,1,0,-1,0,0};
	static int[][][] map;
	
	static void bfs(Queue<int[]> a) {
		while(!a.isEmpty()) {
			int [] cur = a.poll();
			int ch = cur[0];
			int cr = cur[1];
			int cc = cur[2];
			
			for (int i = 0; i < 6; i++) {
				int nh = ch + dh[i];
				int nr = cr + dr[i];
				int nc = cc + dc[i];
				
				if(nh>=0 && nh < h && nr >= 0 && nr < r && nc>=0 && nc < c) {
					if(map[nh][nr][nc] == 0) {
						map[nh][nr][nc] = map[ch][cr][cc] + 1;
						a.offer(new int[] {nh,nr,nc});
					}
				}
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		c = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		map = new int[h][r][c];
		Queue<int[]> q = new LinkedList<>();
		
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < r; j++) {
				StringTokenizer s = new StringTokenizer(br.readLine());
				for (int k = 0; k < c; k++) {
					map[i][j][k] = Integer.parseInt(s.nextToken());
					if(map[i][j][k] == 1) {
						q.add(new int [] {i,j,k});
					}
				}
			}
		}
		
		bfs(q);
		
		int max = Integer.MIN_VALUE;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < r; j++) {
            	for (int k = 0; k < c; k++) {
            		if (map[i][j][k] == 0) {
            			System.out.println(-1); // 안 익은 토마토 존재
                        return;
            		}
            		max = Math.max(max, map[i][j][k]);
				}
            }
        }

        System.out.println(max - 1);
	}

}
