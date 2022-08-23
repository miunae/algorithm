import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_7465_이재훈 {
	static ArrayList<ArrayList<Integer>> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			boolean[] visited = new boolean[N+1];
			int from=0,to=0;
			list = new ArrayList<ArrayList<Integer>>();
			for(int i=0;i<=N;i++) {
				list.add(new ArrayList<Integer>());
			}
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				list.get(from).add(to);
				list.get(to).add(from);
			}
			
		}
	}
	
	static void bfs()

}
