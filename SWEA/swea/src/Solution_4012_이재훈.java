import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4012_이재훈 {
	static int[][] S;
	static int N, min;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			N = Integer.parseInt(br.readLine());
			S = new int[N][N];
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					S[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			visited = new boolean[N];
			min = Integer.MAX_VALUE;
			dfs(0,0);
			System.out.printf("#%d %d\n",t,min);
		}
	}
	static void dfs(int cnt, int start) {
		if(cnt == N/2) {
			int sumA = 0;
			int sumB = 0;
			for(int i=0;i<N;i++) {
				if(visited[i]) {
					for(int j=0;j<N;j++) {
						if(!visited[j]) {
							continue;
						}
						sumA += S[i][j];
					}
				}
				else {
					for(int j=0;j<N;j++) {
						if(visited[j]) {
							continue;
						}
						sumB += S[i][j];
					}
				}
			}
			min = Math.min(min, Math.abs(sumA-sumB));
			return;
		}
		for(int i=start;i<N;i++) { // start에 처음에 1부터 들어가게 해야함(0은 이미 고정방문)
			visited[i] = true;
			dfs(cnt+1,i+1);
			visited[i] = false;
		}
	}
	
}
