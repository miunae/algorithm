import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1916 {
	static int[] D;
	static int N,M;
	static ArrayList<Node>[] nodeList;
	static class Node implements Comparable<Node>{
		int to, weight;
		Node(int to, int weight){
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		D = new int[N+1];
		nodeList = new ArrayList[N+1];
		for(int i=0;i<=N;i++)
			nodeList[i] = new ArrayList<>();
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			nodeList[from].add(new Node(to,weight));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		Arrays.fill(D, Integer.MAX_VALUE);
		dijkstra(start);
		System.out.println(D[end]);
		
	}
	static void dijkstra(int start) {
		D[start] = 0;
		boolean[] visited = new boolean[N+1];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start,0));
		int min = Integer.MAX_VALUE;
		while(!pq.isEmpty()) {
			Node tmp = pq.poll();
			if(visited[tmp.to])
				continue;
			else
				visited[tmp.to]= true;
			for(Node node : nodeList[tmp.to]) { // node: 인접한 애들
				if(D[node.to] > D[tmp.to]+node.weight) {
					D[node.to]= D[tmp.to]+node.weight; 
					pq.add(new Node(node.to,D[node.to]));
				}		
			}
		}

	}
}
