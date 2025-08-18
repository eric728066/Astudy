import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	
	static void combi(char[]a, int start, int k, List<Character> cur, int vowelCnt, int consonantCnt) {
		if(k == 0) {
			if(vowelCnt >= 1 && consonantCnt >=2) {
				for (int i = 0; i < cur.size(); i++) {
					sb.append(cur.get(i));
				}
				sb.append('\n');
			}
			return;
		}
		
		if(k > a.length - start) return;
		
		for (int i = start; i <= a.length - k; i++) {
			cur.add(a[i]);
			if(a[i] == 'a'||a[i] == 'e'||a[i] == 'i'||a[i] == 'o'||a[i] == 'u') {
				vowelCnt++;
			}else {
				consonantCnt++;
			}
			combi(a,i+1,k-1,cur,vowelCnt,consonantCnt);
			if(a[i] == 'a'||a[i] == 'e'||a[i] == 'i'||a[i] == 'o'||a[i] == 'u') {
				vowelCnt--;
			}else {
				consonantCnt--;
			}
			cur.remove(cur.size()-1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		char[] a = new char[n];
		StringTokenizer s = new StringTokenizer(br.readLine());
		for (int i = 0; i < a.length; i++) {
			a[i] = s.nextToken().charAt(0);
		}
		Arrays.sort(a);
		combi(a,0,k,new ArrayList<>(),0,0);
		System.out.println(sb);
	}

}
