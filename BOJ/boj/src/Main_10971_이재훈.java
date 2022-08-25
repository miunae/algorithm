import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10971_이재훈 {
	static int[][] adjMatrix;
	static int N;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		adjMatrix = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] nodes = new int[N];
		boolean[] visited = new boolean[N];
		dfs(0,nodes,visited);
		System.out.println(min);

	}
	static void dfs(int depth, int[] nodes,boolean[] visited) {
		if(depth>1 && adjMatrix[nodes[depth-2]][nodes[depth-1]] == 0) {
			return;
		}
		if(depth == N) {
			if(adjMatrix[nodes[N-1]][nodes[0]] == 0)
				return;
			int sum = 0;
			for(int i=0;i<N-1;i++) {
				sum+= adjMatrix[nodes[i]][nodes[i+1]];
			}
			sum += adjMatrix[nodes[N-1]][nodes[0]];
			min = Math.min(min, sum);
			return;
		}
		for(int i=0;i<N;i++) {
			if(visited[i])continue;
			visited[i] = true;
			nodes[depth] = i;
			dfs(depth+1,nodes,visited);
			visited[i] = false;
		}
	}
}
