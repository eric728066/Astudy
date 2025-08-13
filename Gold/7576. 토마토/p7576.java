package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p7576 {
	
	static int r;
	static int c;
	static int [][] map;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	static void bfs(Queue<int[]> q) {
		while(!q.isEmpty()) {
			int [] curr = q.poll();

			int a = curr[0];
			int b = curr[1];
			
			
			for (int i = 0; i < 4; i++) {
				int nr = a + dr[i];
				int nc = b + dc[i];
				
				
				if(!(nr<0||nc<0||nr>=r||nc>=c)) {
					if (map[nr][nc] == 0) {
                        map[nr][nc] = map[a][b] + 1;
                        q.offer(new int[]{nr, nc});
                    }
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<int[]> one = new LinkedList<>();
		
		c = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		map = new int[r][c];
		
		for (int i = 0; i < r; i++) {
			StringTokenizer s = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(s.nextToken());
				if (map[i][j] == 1) {
					one.offer(new int[] {i,j});
				}
			}
		}
		
		bfs(one);
		
		int max = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 0) {
                    System.out.println(-1); // 안 익은 토마토 존재
                    return;
                }
                max = Math.max(max, map[i][j]);
            }
        }

        System.out.println(max - 1);
		
	}

}
