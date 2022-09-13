import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_13549 {
	static int N,K;
	static boolean[] visited = new boolean[100001];
	static int cnt = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		bfs();
		System.out.println(cnt);
	}
	
	static void bfs() {
		PriorityQueue<Point> queue = new PriorityQueue<>();
		queue.offer(new Point(N,0));
		while(!queue.isEmpty()) {
			Point point = queue.poll();
            visited[point.pos] = true; //3가지케이스에 큐에 offer한다음에 방문처리하면 우선순위때문에 최소거리 바뀌는 경우 발생함
            if (point.pos == K) {
                cnt = point.time;
            }
            if (point.pos * 2 <= 100000 && !visited[point.pos * 2]) { // 0초 순간이동
                queue.offer(new Point(point.pos * 2, point.time));
            }
            if (point.pos + 1 <= 100000 && !visited[point.pos + 1]) { //1초 한칸우측
                queue.offer(new Point(point.pos + 1, point.time + 1));
            }
            if (point.pos - 1 >= 0 && !visited[point.pos - 1]) { //1초 한칸좌측
                queue.offer(new Point(point.pos - 1, point.time + 1));
            }
		}
	}
	
	static class Point implements Comparable<Point>{
		int pos,time;
		Point(int pos,int time){
			this.pos = pos;
			this.time = time;
		}
		@Override
		public int compareTo(Point o) {
			return time - o.time;
		}
	}
}
