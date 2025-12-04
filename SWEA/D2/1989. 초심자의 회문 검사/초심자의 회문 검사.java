import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			String str = br.readLine();
			StringBuilder sb = new StringBuilder(str);
			String str2 = sb.reverse().toString();

			
//			for (int i = str.length()-1; i >= 0; i--) {
//				str2 += str.charAt(i);
//			}
			
			if(str.equals(str2)) {
				bw.write("#" + t + " " + 1 + "\n");
			}else {
				bw.write("#" + t + " " + 0 + "\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();

	}

}
