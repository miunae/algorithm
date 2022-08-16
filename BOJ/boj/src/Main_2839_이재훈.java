import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2839_이재훈 {
	static int[] dp;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		for(int i=0;i<dp.length;i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		memozation(0,0);
		if(dp[N] == Integer.MAX_VALUE)
			System.out.println(-1);
		else System.out.println(dp[N]);
	}
	static void memozation(int cnt, int n) {
		if(n == N) {
			dp[n] = Math.min(dp[n], cnt);
			return;
		}
		if(n > N)
			return;
		dp[n] = Math.min(dp[n], cnt);
		int tmp = N-n;
		if(tmp%5 ==0) {
			memozation(cnt+tmp/5,N);
		}
		else if(tmp%3 ==0) {
			memozation(cnt+1,n+3);
		}
		else {
			memozation(cnt+1,n+3);
			memozation(cnt+1,n+5);
		}
	}
}
