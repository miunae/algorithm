import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution_1238_이재훈 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1;t<=10;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			ArrayList<ArrayList<Integer>> nodeList = new ArrayList<>();
			for(int i=0;i<101;i++) {
				nodeList.add(new ArrayList<Integer>());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N/2;i++) {
				nodeList.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
			}
			System.out.printf("#%d %d\n",t,BFS(start,nodeList));
		}
	}
	static int BFS(int start, ArrayList<ArrayList<Integer>> nodeList) {
		Deque<Integer> deque = new ArrayDeque<>();
		deque.offerLast(start);
		int max = 0;
		boolean[] visited = new boolean[101];
		while(!deque.isEmpty()) {
			int tmp = deque.pollFirst();
			for(int i=0;i<nodeList.get(tmp).size();i++) {
				int node = nodeList.get(tmp).get(i);
				if(!visited[node]) {
					visited[node] = true;
					deque.offerLast(node);
				}
			}
		}
		
		return max;
	}
}
