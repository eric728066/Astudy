import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		long[] arr = new long[101];
		arr[1] = 1;
		arr[2] = 1;
		arr[3] = 1;
		for (int i = 4; i < arr.length; i++) {
			arr[i] = arr[i-2] + arr[i-3];
		}
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(arr[n]);
		}

	}

}
