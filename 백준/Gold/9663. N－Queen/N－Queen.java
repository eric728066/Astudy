import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[][] attack;   // attack[r][c] > 0 이면 공격받는 칸
    static int[][] map;      // map[r][c] == 1 이면 여기에 퀸
    static long ans = 0;
    // 대각선 4방향(행/열은 별도로 처리)
    static final int[] dr = {-1, -1, 1, 1};
    static final int[] dc = {-1,  1, 1,-1};

    // row번째 행에 퀸을 하나 놓는 탐색
    static void dfs(int row) {
        if (row == n) {
            ans++;
            return;
        }
        for (int c = 0; c < n; c++) {
            if (attack[row][c] == 0) {      // 아무도 공격 안 하면 놓기 가능
                place(row, c, +1);          // 놓기(공격 범위 표시 +1)
                map[row][c] = 1;

                dfs(row + 1);

                map[row][c] = 0;
                place(row, c, -1);          // 되돌리기(공격 범위 -1)
            }
        }
    }

    // (r,c)에 퀸을 놓거나 빼면서 공격 범위를 갱신(add = +1 놓기, -1 빼기)
    static void place(int r, int c, int add) {
        // 같은 행
        for (int j = 0; j < n; j++) if (j != c) attack[r][j] += add;

        // 같은 열
        for (int i = 0; i < n; i++) if (i != r) attack[i][c] += add;

        // 대각선 4방향
        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            while (0 <= nr && nr < n && 0 <= nc && nc < n) {
                attack[nr][nc] += add;
                nr += dr[k];
                nc += dc[k];
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());

        attack = new int[n][n];
        map    = new int[n][n];

        dfs(0);
        System.out.println(ans);
    }


}
