import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    static class xy {
        int x;
        int y;

        public xy(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class node extends xy {
        int depth;

        public node(int x, int y, int depth) {
            super(x, y);
            this.depth = depth;
        }
    }

    static int N;
    static int[][] matrix;
    static boolean[][] visited;
    static int[] d_row = { -1, 0, 1, 0 };
    static int[] d_col = { 0, 1, 0, -1 };
    static int ans;
    static xy start;
    static xy end;

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            matrix = new int[N][N];
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            // 출발 좌표 입력
            start = new xy(sc.nextInt(), sc.nextInt());
            // 도착 좌표 입력
            end = new xy(sc.nextInt(), sc.nextInt());

            if (start.x == end.x && start.y == end.y) {
                System.out.println("#" + test_case + " " + 0);
                continue;
            }

            System.out.println("#" + test_case + " " + (bfs() ? ans : -1));

        }

    }

    static boolean bfs() {
        Queue<node> q = new LinkedList<>();
        q.add(new node(start.x, start.y, 0));
        visited[start.x][start.y] = true;

        while (!q.isEmpty()) {
            node now = q.poll();

            for (int i = 0; i < 4; i++) {
                xy next = new xy(now.x + d_row[i], now.y + d_col[i]);

                if (next.x < 0 || next.x >= N || next.y < 0 || next.y >= N) {
                    continue;
                }

                if (next.x == end.x && next.y == end.y) {
                    ans = now.depth + 1;
                    return true;
                }

                if (matrix[next.x][next.y] == 1 || visited[next.x][next.y]) {
                    continue;
                }

                if (matrix[next.x][next.y] == 2) {
                    if (now.depth % 3 == 2) {
                        visited[next.x][next.y] = true;
                        q.add(new node(next.x, next.y, now.depth + 1));
                    } else {
                        visited[now.x][now.y] = true;
                        q.add(new node(now.x, now.y, now.depth + 1));
                    }
                } else {
                    visited[next.x][next.y] = true;
                    q.add(new node(next.x, next.y, now.depth + 1));
                }
            }
        }
        return false;
      }
}