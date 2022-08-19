import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3234_이재훈 {
	static int[] numbers, tmps;
	static int N, total,answer;
	static boolean[] visited;
	static boolean[] visited2;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			numbers = new int[N];
			tmps = new int[N];
			int total = 0;
			visited = new boolean[N];
			visited2 = new boolean[N];
			answer =0;
			for (int i = 0; i < N; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
				total += numbers[i];
			}
			dfs(0);
			System.out.println("#"+t+" "+answer);
		}
		
	}

	static void dfs(int cnt) { // 왼쪽에 들어가는게 visited[]가 true
		if (cnt == N) {
			dfs2(0,tmps,0,0);
			return;
		}
		for(int i=0;i<N;i++) {
			if(visited[i])continue;
			visited[i] = true;
			tmps[cnt] = numbers[i];
			dfs(cnt+1);
			visited[i] = false;
		}
	}
	
	static void dfs2(int cnt, int[] arr,int left, int right) {
		if(left<right)
			return;
		
		if(cnt == N) {
			answer += 1;
			return;
		}
		
		visited2[cnt] = true;
		dfs2(cnt+1,arr,left+arr[cnt],right);
		visited2[cnt] = false;
		dfs2(cnt+1,arr,left,right+arr[cnt]);
	}
}
