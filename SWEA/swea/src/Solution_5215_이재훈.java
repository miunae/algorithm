import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5215_이재훈 {
	static int max;
	static int[][] food;
	static int N,L;
	static boolean[] isSelected;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			food = new int[N][2];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				food[i][0] = Integer.parseInt(st.nextToken()); // 
				food[i][1] = Integer.parseInt(st.nextToken());
			}
			max = 0;
			int cnt = 0;
			isSelected = new boolean[N];
			subset(cnt);
			System.out.printf("#%d %d\n",t,max);
			
		}
	}
	private static void subset(int cnt) {
		if(cnt == N) {
			int calSum = 0;
			int scoreSum = 0;
			for(int i=0;i<N;i++) {
				if(isSelected[i]) {
					calSum += food[i][1];
					scoreSum += food[i][0];
				}
			}
			if(calSum<=L)
				max = Math.max(max, scoreSum);
			return;
		}
		
		isSelected[cnt] = true;
		subset(cnt+1);
		isSelected[cnt] = false;
		subset(cnt+1);
	}
}
