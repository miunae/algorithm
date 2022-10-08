import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_9205_이재훈 {
	static String answer;
	static Pos[] location;
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int T=0;T<t;T++) {
			answer = "sad";
			n = Integer.parseInt(br.readLine());
			location = new Pos[n+2];
			for(int i=0;i<n+2;i++) {
				st = new StringTokenizer(br.readLine());
				location[i] = new Pos(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			bfs();
			System.out.println(answer);
		}
	}
	
	static class Pos{
		int x,y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static void bfs() {
		ArrayDeque<Pos> deq = new ArrayDeque<>();
		deq.add(location[0]);
		boolean[] visited = new boolean[location.length+2];
		visited[0] = true;
		while(!deq.isEmpty()) {
			Pos cur = deq.poll();
			if(cur.x == location[n+1].x && cur.y == location[n+1].y) {
				answer = "happy";
				break;
			}
			for(int i=1;i<n+2;i++) {
				if(!visited[i] && dist(cur,location[i])<=1000) {
					deq.add(location[i]);
					visited[i] = true;
				}
			}
		}
	}
	
	static int dist(Pos a,Pos b) {
		return Math.abs(a.x-b.x)+Math.abs(a.y-b.y);
	}
}
