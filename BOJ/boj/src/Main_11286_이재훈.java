import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_11286_이재훈 {
	static class Node implements Comparable<Node>{
		Node(int data, int abs){
			this.data = data;
			this.abs = abs;
		}
		
		int data;
		int abs;
		
		@Override
		public int compareTo(Node o) {
			if(this.abs != o.abs)
				return this.abs - o.abs;
			return this.data - o.data;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Node> pq = new PriorityQueue<>();
		for(int i=0;i<N;i++) {
			int tmp = Integer.parseInt(br.readLine());
			if(tmp != 0) {
				Node node = new Node(tmp,Math.abs(tmp));
				pq.add(node);
			}
			if(tmp ==0) {
				if(pq.isEmpty()) {
					sb.append(0).append('\n');
				}
				else {
					int n = pq.poll().data;
					sb.append(n).append('\n');
				}
			}
		}
		System.out.println(sb);
	}

}
