import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		Belt [] arr = new Belt[2*n];
		for (int i = 0; i < 2*n; i++) {
			int a = Integer.parseInt(st.nextToken());
			Belt b = new Belt(a,0);
			arr[i] = b;
		}
		int dieCount = 0;
		int turn = 0;
		while(dieCount < k) {
			turn += 1;
			//벨트 이동
			Belt r = arr[2*n-1];
			for (int i = 2*n-2; i >= 0; i--) {
				arr[i+1] = arr[i];
			}
			arr[0] = r;
			//로봇 내리기
			if(arr[n-1].getRobot() == 1) {
				arr[n-1].setRobot(0);
			}
			//로봇 이동
			for (int i = n-2; i >= 0; i--) {
				if(arr[i].getRobot() == 1) {
					if(arr[i+1].getRobot() == 0 && (arr[i+1].getLife() > 0)) {
						arr[i].setRobot(0);
						arr[i+1].setRobot(1);
						int a = arr[i+1].getLife()-1;
						arr[i+1].setLife(a);
						if(arr[i+1].getLife() == 0) dieCount += 1;
					}
				}
			}
			//로봇 내리기
			if(arr[n-1].getRobot() == 1) {
				arr[n-1].setRobot(0);
			}
			//로봇 생성
			if(arr[0].getLife()>0) {
				arr[0].setRobot(1);
				int temp = arr[0].getLife() - 1;
				arr[0].setLife(temp);
				if(arr[0].getLife() == 0) dieCount += 1;
			}
		}
		System.out.println(turn);
	}

}

class Belt{
	int life;
	int robot;
	
	public Belt() {
		
	}
	
	public Belt(int life, int robot) {
		this.life = life;
		this.robot = robot;
	}
	
	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}

	public int getRobot() {
		return robot;
	}

	public void setRobot(int robot) {
		this.robot = robot;
	}
	
	
	
}