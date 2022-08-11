import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_2961_이재훈 {
	static int N;
	static boolean[] isSelected;
	static int[][] food;
	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		food = new int[N][2];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			food[i][0] = Integer.parseInt(st.nextToken());
			food[i][1] = Integer.parseInt(st.nextToken());
		}
		min = Integer.MAX_VALUE;
		isSelected = new boolean[N];
		subset(0);
		System.out.println(min);
	}
	// 인덱스들의 조합을 뽑아낸다
	static void subset(int cnt) {
		if(cnt == N) {
			int sumS = 1; // 신 맛
			int sumB = 0; // 쓴 맛
			int selectCnt = 0;
			for(int i=0;i<N;i++) {
				if(isSelected[i]) {
					selectCnt++;
					sumS *= food[i][0];
					sumB += food[i][1];
				}
			}
			if(selectCnt == 0) return; // 아무것도 고르지 않았다면 pass
			min = Math.min(Math.abs(sumS-sumB), min);
			return;
		}
		
		// 포함할 때
		isSelected[cnt] = true;
		subset(cnt+1);
		// 포함하지 않을 때
		isSelected[cnt] = false;
		subset(cnt+1);
	}
}
