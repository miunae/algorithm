import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_3124_이재훈 {
	static int[] parents;
	static int V,E;
	static Edge[] EdgeList;
	static class Edge implements Comparable<Edge>{
		int from,to,weight;
		Edge(int from, int to, int weight){
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
	
	static void make() {
		parents = new int[V+1];
		for(int i=1;i<=V;i++) {
			parents[i] = i;
		}
	}
	
	static int find(int a) {
		if(a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) {
			return false;
		}
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			EdgeList = new Edge[E];
			for(int i=0;i<E;i++) {
				st = new StringTokenizer(br.readLine());
				EdgeList[i] = new Edge(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			make();
			Arrays.sort(EdgeList);
			long sum = 0;
			int cnt = 0;
			for(Edge edge: EdgeList) {
				if(union(edge.from,edge.to)) {
					sum += edge.weight;
					if(++cnt == V-1)
						break;
				}
			}
			System.out.printf("#%d %d\n",t,sum);
		}
	}

}
