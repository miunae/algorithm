import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_14621_이재훈 {
	static int N, M;
	static ArrayList<Node>[] nodeList;
	static char[] genderList;

	static class Node implements Comparable<Node> {
		int from, to, weight;

		Node(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}

	static class Vertex implements Comparable<Vertex> {
		int no, weight;

		Vertex(int no, int weight) {
			this.no = no;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			return this.weight - o.weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		genderList = new char[N + 1];
		nodeList = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			nodeList[i] = new ArrayList<>();
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			genderList[i] = st.nextToken().charAt(0);
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			nodeList[from].add(new Node(from, to, weight)); // 인접리스트 만들어줌.
			nodeList[to].add(new Node(to, from, weight));
		}
		boolean[] visited = new boolean[N + 1];
		int[] minEdge = new int[N + 1];
		int cnt = 0, result = 0;
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		minEdge[1] = 0;
		pq.add(new Vertex(1, minEdge[1]));

		while (!pq.isEmpty()) {
			Vertex minVertex = pq.poll();
			if (visited[minVertex.no])
				continue;
			visited[minVertex.no] = true;
//			System.out.println(minVertex.no + " " + minVertex.weight);
//			System.out.println(cnt);
			result += minVertex.weight;
			if (++cnt == N)
				break;

			for (Node node : nodeList[minVertex.no]) {
				if (!visited[node.to] && minEdge[node.to] > node.weight) {

					if (genderList[minVertex.no] == genderList[node.to])
						continue;
					else {
						minEdge[node.to] = node.weight;
						pq.add(new Vertex(node.to, minEdge[node.to]));
					}
				}
			}
		}
		if(cnt != N)
			System.out.println(-1);
		else
			System.out.println(result);
	}

}
