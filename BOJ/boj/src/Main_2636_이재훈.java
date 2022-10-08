import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_2636_이재훈 {
	static int N,M;
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean allMelt = false;
		int time = 0;
		int cnt = 0;
		while(!allMelt) {
			bfs(0,0);
			cnt = melt(--time);
			allMelt = true;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(map[i][j] == 1) {
						allMelt = false;
					}
				}
			}
		}
		System.out.println(Math.abs(time));
		System.out.println(cnt);
	}
	
	static class Point{
		int x,y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static void bfs(int x,int y) {
		ArrayDeque<Point> deq = new ArrayDeque<>();
		deq.add(new Point(x,y));
		boolean[][] visited = new boolean[N][M];
		visited[x][y] = true;
		while(!deq.isEmpty()) {
			Point cur = deq.poll();
			int cx = cur.x;
			int cy = cur.y;
			for(int d=0;d<4;d++) {
				int nx = cx + dx[d];
				int ny = cy + dy[d];
				if(nx>=0 && nx<N && ny>=0 && ny<M && !visited[nx][ny] && map[nx][ny] != 1) {
					visited[nx][ny] = true;
					deq.add(new Point(nx,ny));
					map[nx][ny] = 2;
				}
			}
		}
	}
	
	static int melt(int time) {
		ArrayDeque<Point> deq = new ArrayDeque<>();
		deq.add(new Point(0,0));
		boolean[][] visited = new boolean[N][M];
		visited[0][0] = true;
		int cnt = 0;
		while(!deq.isEmpty()) {
			Point cur = deq.poll();
			int cx = cur.x;
			int cy = cur.y;
			for(int d=0;d<4;d++) {
				int nx = cx + dx[d];
				int ny = cy + dy[d];
				if(nx>=0 && nx<N && ny>=0 && ny<M && !visited[nx][ny]) {
					if(map[nx][ny] == 2) {
						deq.add(new Point(nx,ny));
						visited[nx][ny] = true;
					}else if(map[nx][ny] == 1) {
						map[nx][ny] = time;
						cnt += 1;
					}
				}
			}
		}
		return cnt;
	}
}
