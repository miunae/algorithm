import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1753_이재훈 {
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
	static ArrayList<Node>[] nodeList;
	static int[] D;
	static int V,E;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		D = new int[V+1];
		nodeList = new ArrayList[V+1];
		for(int i=0;i<=V;i++)
			nodeList[i] = new ArrayList<>();
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			nodeList[from].add(new Node(to,weight));
			
		}
		Arrays.fill(D, Integer.MAX_VALUE);
		
		dijkstra(start);
		for(int i=1;i<=V;i++) {
			if(D[i] != Integer.MAX_VALUE)
				System.out.println(D[i]);
			else System.out.println("INF");
		}
	}
	static void dijkstra(int start) {
		D[start] = 0;
		boolean[] visited = new boolean[V+1];
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
