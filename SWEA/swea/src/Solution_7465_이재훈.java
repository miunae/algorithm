import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_7465_이재훈 {
	static ArrayList<ArrayList<Integer>> list;
	static int N, M;
	static boolean[] visited;
	static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			visited = new boolean[N+1];
			int from=0,to=0;
			list = new ArrayList<ArrayList<Integer>>();
			for(int i=0;i<=N+1;i++) {
				list.add(new ArrayList<Integer>());
			}
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				list.get(from).add(to);
				list.get(to).add(from);
			}
			cnt = 0;
			for(int i=1;i<=N;i++) {
				if(!visited[i])
					bfs(i);
			}
			System.out.printf("#%d %d\n",t,cnt);
		}
	}

	static void bfs(int n) {
		cnt+=1;
		Queue<Integer> que = new LinkedList<>();
		que.offer(n);
		while(!que.isEmpty()) {
			int tmp  = que.poll();
			visited[tmp] = true;
			for(int i=0;i<list.get(tmp).size();i++) {
				int node = list.get(tmp).get(i);
				if(!visited[node]) {
					que.offer(node);
				}
			}
		}
	}

}
