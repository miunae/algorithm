import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3307_이재훈 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			int[] dp = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			dp[0] = 1;
			for(int i=1;i<N;i++) {
				int max = 0;
				for(int j=0;j<i;j++) {
					if(arr[i] > arr[j]) {
						max = Math.max(max, dp[j]);
					}
				}
				dp[i] = max+1;
			}
			int answer = 0;
			for(int i=0;i<N;i++) {
				answer = Math.max(answer, dp[i]);
			}
			System.out.printf("#%d %d\n",t,answer);
		}
	}

}
