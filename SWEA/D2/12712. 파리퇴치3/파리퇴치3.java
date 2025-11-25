import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	
	static int n,m;
	static int [][] arr;
	
	static int[] pdr = {-1,0,1,0};
	static int[] pdc = {0,1,0,-1};
	
	static int[] xdr = {-1,1,1,-1};
	static int[] xdc = {1,1,-1,-1};
	
	static int killPlus(int r, int c) {
		int sum = arr[r][c];
		
		for (int d = 0; d < 4; d++) {
			for (int k = 1; k < m; k++) {
				int nr = r + pdr[d]*k;
				int nc = c + pdc[d]*k;
				
				if(nr<0 || nc<0 || nr>=n || nc>=n) continue;
				
				sum+=arr[nr][nc];
			}
		}
		
		return sum;
	}
	
	static int killX(int r, int c) {
		int sum = arr[r][c];
		
		for (int d = 0; d < 4; d++) {
			for (int k = 1; k < m; k++) {
				int nr = r + xdr[d]*k;
				int nc = c + xdc[d]*k;
				
				if(nr<0 || nc<0 || nr>=n || nc>=n) continue;
				
				sum+=arr[nr][nc];
			}
		}
		
		return sum;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int max = 0;
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					max = Math.max(max, killPlus(i,j));
					max = Math.max(max, killX(i,j));
				}
			}
			
			bw.write("#" + t + " " + max + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();

	}

}
