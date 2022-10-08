import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5643_이재훈 {
	static int N,M;
	static int big,small;
	static int[][] adj;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int t=1;t<=T;t++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			adj = new int[N][N];
			int cnt = 0;
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adj[a-1][b-1] = 1;
			}
			for(int i=0;i<N;i++) {
				big=small=0;
				bfs1(i);
				bfs2(i);
				if(big+small == N-1)
					cnt += 1;
			}
			System.out.printf("#%d %d\n",t,cnt);
		}
	}
	static void bfs1(int n) { // 키 큰 애
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		boolean[] visited = new boolean[N];
		visited[n] = true;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int i=0;i<N;i++) {
				if(!visited[i] && adj[cur][i] == 1) {
					visited[i] = true;
					q.add(i);
					big++;
				}
			}
		}
	}
	
	static void bfs2(int n) { // 키 작은 애
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		boolean[] visited = new boolean[N];
		visited[n] = true;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int i=0;i<N;i++) {
				if(!visited[i] && adj[i][cur] == 1) {
					visited[i] = true;
					q.add(i);
					small++;
				}
			}
		}
	}

}
