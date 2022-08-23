import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_13023_이재훈 {
	static int N,M;
	static ArrayList<ArrayList<Integer>> list;
	static boolean[] visited;
	static int answer=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<N;i++)
			list.add(new ArrayList<Integer>());
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list.get(from).add(to);
			list.get(to).add(from);
		}
//		visited = new boolean[N];

		for(int i=0;i<N;i++) {
			visited = new boolean[N];
			visited[i] = true;
			dfs(0,i);
			if(answer == 1)
				break;
		}
		System.out.println(answer);
	}
	static void dfs(int depth, int n) {
		if(depth == 4) {
			answer = 1;
			return;
		}
		if(answer == 1)
			return;
		for(int i=0;i<list.get(n).size();i++) {
			if(visited[list.get(n).get(i)])
				continue;
			visited[list.get(n).get(i)] = true;
			dfs(depth+1,list.get(n).get(i));
			visited[list.get(n).get(i)] = false;
		}
	}
}
