import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_이재훈 {
	static int N;
	static boolean[] visited;
	static public Queue<Integer> queue;
	static public List<ArrayList<Integer>> adj;
	
	static void DFS(int node) {
		if(visited[node] == false) {
			visited[node] = true;
			System.out.print(node+" ");
		}
		else {
			return;
		}
		for(int i=0;i<adj.get(node).size();i++) {
			DFS(adj.get(node).get(i));
		}
	}
	
	static void BFS(int node) {
		queue.add(node);
		while (!queue.isEmpty()) {
			int tmp = queue.poll();
			if(visited[tmp] == true) continue;
			visited[tmp] = true;
			System.out.print(tmp+" ");
			for(int i=0;i<adj.get(tmp).size();i++) {
				if(visited[adj.get(tmp).get(i)] == false) {
					queue.offer(adj.get(tmp).get(i));
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1]; // 방문정보 저장
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		adj = new ArrayList<>(); // 인접 정보를 저장할 리스트
		adj.add(null); // 0번째 인덱스를 0으로
		for(int i=0;i<=N;i++) {
			adj.add(new ArrayList<Integer>());
		}
		int[][] mArray = new int[M][2];
		// 인접 정보 기록
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if(x>y) {
				int tmp = x;
				x=y;
				y=tmp;
			}
			mArray[i][0] = x;
			mArray[i][1] = y;
		}
		Arrays.sort(mArray,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0])
					return o1[1]-o2[1];
				return o1[0] - o2[0];
			}
		});
		
		for(int i=0;i<M;i++) {
			int x = mArray[i][0];
			int y = mArray[i][1];
			adj.get(x).add(y);
			adj.get(y).add(x);
		}
		DFS(V);
		System.out.println();
		visited = new boolean[N+1];
		queue = new LinkedList<>();
		BFS(V);
	}

}
