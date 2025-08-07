package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2606 {

    static int[][] graph;
    static boolean[] visited;
    static int n;
    static int a;

    static void dfs(int node) {
        visited[node] = true;

        for (int i = 1; i <= n; i++) {
            if (graph[node][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        a = Integer.parseInt(br.readLine());

        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < a; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            graph[c][d] = 1;
            graph[d][c] = 1;
        }

        dfs(1);

        int count = 0;
        for (int i = 2; i <= n; i++) {  // 1번 컴퓨터 제외하고 카운트
            if (visited[i]) {
                count++;
            }
        }

        System.out.println(count);
    }
}
