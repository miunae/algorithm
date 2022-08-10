import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_1260_이재훈 {
	static public Stack<Integer> stack;
	static public Queue<Integer> queue;
	static public List<ArrayList<Integer>> adj;
	static void DFS(int node) {
		
	}
	static void BFS(int node) {
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		adj = new ArrayList<>();
		for(int i=0;i<=M;i++) {
			adj.add(new ArrayList<Integer>());
		}
		// 인접 정보 기록
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			adj.get(x).add(y);
			adj.get(y).add(x);
		}
	}

}
