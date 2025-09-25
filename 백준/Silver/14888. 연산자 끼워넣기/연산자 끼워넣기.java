import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] nums;
    static int[] op = new int[4]; // + - * /
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, nums[0]); // 두 번째 숫자부터 시작
        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int idx, int result) {
        if(idx == n) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for(int i=0; i<4; i++) {
            if(op[i] > 0) {
                op[i]--;
                int next = calc(result, nums[idx], i);
                dfs(idx+1, next);
                op[i]++; // 복구
            }
        }
    }

    static int calc(int a, int b, int opIdx) {
        switch(opIdx) {
            case 0: return a+b;
            case 1: return a-b;
            case 2: return a*b;
            case 3: return a/b; 
        }
        return 0;
    }
}
