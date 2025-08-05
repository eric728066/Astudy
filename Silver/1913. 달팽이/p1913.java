package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1913 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int s = Integer.parseInt(br.readLine());
		
		//배열 생성
		int [][] snail = new int[n][n];
		
		//하우상좌
		int[] dr = {1,0,-1,0};
		int[] dc = {0,1,0,-1};
		int point = 0;
		
		int r = 0;
		int c = 0;
		
		int resultr = 0;
		int resultc = 0;
		
		int value = n*n;
		
		while(value >= 1) {
			if(value == s) {
				resultr = r + 1;
				resultc = c + 1;
			}
			
			snail[r][c] = value--;
			
			int nr = r + dr[point];
			int nc = c + dc[point];
			
			// 예외처리
			if (nr < 0 || nr >= n || nc < 0 || nc >= n || snail[nr][nc] != 0) {
				point = (point + 1) % 4;
				
				nr = r + dr[point];
				nc = c + dc[point];
			}
			
			r = nr;
			c = nc;
			
		}
		

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
		    for (int j = 0; j < n; j++) {
		        sb.append(snail[i][j]).append(" ");
		    }
		    sb.append("\n");
		}

		System.out.print(sb); // 한 번에 출력
		System.out.println(resultr+" "+resultc);
	}

}
