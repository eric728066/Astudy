import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int max = Integer.MIN_VALUE;
	
	static List<List<Integer>> c = new ArrayList<>();
	static void perm(int[]a,int k,boolean[] used, List<Integer> cur) {
		if(cur.size() == k) {
			c.add(new ArrayList<>(cur));
			return;
		}
		
		for (int i = 0; i < a.length; i++) {
			if(used[i]) continue;
			used[i] = true;
			cur.add(a[i]);
			perm(a,k,used,cur);
			cur.remove(cur.size()-1);
			used[i] = false;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][9];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] put = {2,3,4,5,6,7,8,9};
		
		perm(put,8, new boolean [put.length] ,new ArrayList<>());
		
		for (List<Integer> arr : c) {
			int[] order = new int[9];
			for (int i = 0; i < 3; i++) {
				order[i] = arr.get(i);
			}
			order[3] = 1; 
			for (int i = 4; i < 9; i++) {
				order[i] = arr.get(i-1);
			}
			int getPoint = 0;
			int outcnt = 0;
			int pointer = 0;
			int ening = 0;
			int[] field = new int[3];
			while(ening != n) {
				if (outcnt == 3) {
					field = new int[3];
					ening += 1;
					outcnt = 0;
				}
				if(ening == n) {
					break;
				}
				if(map[ening][order[pointer]-1] == 0) {
					outcnt += 1;
				} else if(map[ening][order[pointer]-1] == 1) {
					for (int i = 2; i >= 0; i--) {
						if(field[i] == 1) {
							int a = i + 1;
							if(a<field.length) {
								field[i] = 0;
								field[a] = 1;
							} else if(a >= field.length) {
								field[i] = 0;
								getPoint += 1;
							}
						}
					}
					field[0] = 1;
				} else if(map[ening][order[pointer]-1] == 2) {
					for (int i = 2; i >= 0; i--) {
						if(field[i] == 1) {
							int a = i + 2;
							if(a<field.length) {
								field[i] = 0;
								field[a] = 1;
							} else if(a >= field.length) {
								field[i] = 0;
								getPoint += 1;
							}
						}
					}
					field[1] = 1;
				} else if(map[ening][order[pointer]-1] == 3) {
					for (int i = 2; i >= 0; i--) {
						if(field[i] == 1) {
							int a = i + 3;
							if(a<field.length) {
								field[i] = 0;
								field[a] = 1;
							} else if(a >= field.length) {
								field[i] = 0;
								getPoint += 1;
							}
						}
					}
					field[2] = 1;
				}
				else if(map[ening][order[pointer]-1] == 4) {
					for (int i = 2; i >= 0; i--) {
						if(field[i] == 1) {
							getPoint += 1;
						}
					}
					getPoint += 1;
					field = new int[3];
				}
				pointer = (pointer + 1)%9;
			}
			max = Math.max(max, getPoint);
			
		}
		
		System.out.println(max);
	}

}
