package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class p11725 {
	
	static List<Integer>[] graph;
	static boolean [] visited;
	static int n;
	static int[] result;
	
	static void dfs(int v) {
		visited[v] = true;
		
		for (int neighbor : graph[v]) {
			if(!visited[neighbor]) {
				result[neighbor] = v;
				dfs(neighbor);
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		visited = new boolean[n + 1];
		graph = new ArrayList[n+1];
		result = new int[n+1];
		
		for (int i = 1; i < n + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < n-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			graph[b].add(a);
			
		}
		dfs(1);
		
		for (int i = 2; i < result.length; i++) {
			System.out.println(result[i]);
		}
		
		
	}

}
