package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

public class p1018 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//B로 시작하는 체스판
		String[] bc = {"BWBWBWBW",
					   "WBWBWBWB",
					   "BWBWBWBW",
					   "WBWBWBWB",
					   "BWBWBWBW",
					   "WBWBWBWB",
					   "BWBWBWBW",
					   "WBWBWBWB"};
		//W로 시작하는 체스판
		String[] wc = {"WBWBWBWB",
				   	   "BWBWBWBW",
				   	   "WBWBWBWB",
				   	   "BWBWBWBW",
				   	   "WBWBWBWB",
				   	   "BWBWBWBW",
				   	   "WBWBWBWB",
				   	   "BWBWBWBW"};
		
		String fst = br.readLine();
		String[] sed = fst.split(" ");
		int n = Integer.parseInt(sed[0]);
		int m = Integer.parseInt(sed[1]);
		
		String[] chess = new String[n];
		
		for (int i = 0; i < n; i++) {
			chess[i] = br.readLine();
		}
		int count = 999;
		for (int i = 0; i < n-7; i++) {
			for (int j = 0; j < m-7; j++) {
				int c1 = 0;
				int c2 = 0;
				for (int k = 0; k < 8; k++) {
					for (int l = 0; l < 8; l++) {
						//bc랑 비교할때
						if(chess[k+i].charAt(l+j) != bc[k].charAt(l)) {
							c1 += 1;
						}
						//wc랑 비교할때
						if(chess[k+i].charAt(l+j) != wc[k].charAt(l)) {
							c2 += 1;
						}
					}
				}
				if (c1 < c2) {
					if (c1 < count) {
						count = c1;
					}
					
				} else {
					if (c2 < count) {
						count = c2;
					}
				}
			}
		}
		
		System.out.println(count);
		
	}

}
