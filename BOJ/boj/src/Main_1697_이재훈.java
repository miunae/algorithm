import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1697_이재훈 {
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		dfs(0,N,K);
		System.out.println(min);
		
	}

	static void dfs(int depth, int n, int k) {
		if (depth > min)
			return;
		if (n == k) {
			min = Math.min(depth, min);
			return;
		}
		
		if(n<=k/2) {
			dfs(depth + 1, n * 2, k);
			dfs(depth+1,n+1,k);
			dfs(depth+1,n-1,k);
		}
		if(n>k)
			dfs(depth+1,n-1,k);
		if(n<k) {
			dfs(depth + 1, n + 1, k);
			dfs(depth+1,n*2,k);
		}

	}

}
