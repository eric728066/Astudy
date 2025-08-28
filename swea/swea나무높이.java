package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea나무높이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int i = 1; i <= tc; i++) {
			int n = Integer.parseInt(br.readLine());
			int[]arr = new int[n];
			int maxh = Integer.MIN_VALUE;
			int result;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
				maxh = Math.max(maxh, arr[j]);
			}
			
			int total = 0;
			int cnt_oddnum = 0;
			for(int a : arr) {
				int diff = maxh - a;
				total += diff;
				if(diff%2 == 1) {
					cnt_oddnum += 1;
				}
			}
			total -= cnt_oddnum;
			// 최소 홀수 갯수 구하기
			int odddays;
			odddays = 2*cnt_oddnum - 1;
			int evendays;
			evendays = 2*(cnt_oddnum-1);
			result = odddays;
			// 종료조건
			if(total <= evendays) {
				System.out.println("#" + i +" " +result);
				continue;
			}
			
			int remain = total - evendays;
			//홀수 날에서 종료 했으므로 짝수일부터 시작, day는 짝수일
			int day = 1;
			while(remain > day + (day+1)/2) {
				day++;
			}
			result += day;
			
			System.out.println("#" + i +" " +result);
		}
	}

}
