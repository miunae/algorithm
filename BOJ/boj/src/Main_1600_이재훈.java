import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_1600_이재훈 {

	static int K, W, H;
	static int[] dx = { -1, -2, -2, -1, 1, 2, 2, 1, -1, 1, 0, 0 }; // 12개
	static int[] dy = { -2, -1, 1, 2, 2, 1, -1, -2, 0, 0, -1, 1 };
	static int[] dx2 = { -1, 1, 0, 0 };
	static int[] dy2 = { 0, 0, -1, 1 };
	static boolean[][][] visited; // 방문 기록
	static int[][] map;
	static Point pos; // 원숭이 위치
	static int ans = Integer.MAX_VALUE; // 동작 수 최솟값

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					map[i][j] = -1; // -1로 값 바꿔줌
			}
		}
		visited = new boolean[K][H][W];
		pos = new Point(0, 0, 0); // 초기 원숭이 위치
		bfs();
		if (!visited[H - 1][W - 1])
			System.out.println(-1);
		else {
			System.out.println(map[H - 1][W - 1]);
		}
	}

	static void bfs() {
		ArrayDeque<Point> deq = new ArrayDeque<>();
		deq.add(pos);
		visited[0][pos.x][pos.y] = true;
		while (!deq.isEmpty()) {
			Point cur = deq.pollFirst();
			if (cur.x == H - 1 && cur.y == W - 1) {
				break;
			}
			int k = cur.k;
			if(k>0) {
				for (int d = 0; d < 12; d++) {
					int nx = cur.x + dx[d];
					int ny = cur.y + dy[d];
					if (nx >= 0 && nx < H && ny >= 0 && ny < W && map[nx][ny] != -1 && !visited[nx][ny]) {
						map[nx][ny] = map[cur.x][cur.y] + 1;
						visited[nx][ny] = true;
						if (d < 8) {
							deq.add(new Point(nx, ny, k - 1));
						} else {
							deq.add(new Point(nx, ny, k));
						}
					}
				}
			}
			else if(k<=0) {
				for (int d = 0; d < 4; d++) {
					int nx = cur.x + dx2[d];
					int ny = cur.y + dy2[d];
					if (nx >= 0 && nx < H && ny >= 0 && ny < W && map[nx][ny] != -1 && !visited[nx][ny]) {
						map[nx][ny] = map[cur.x][cur.y] + 1;
						visited[nx][ny] = true;
						deq.add(new Point(nx, ny, k - 1));
						deq.add(new Point(nx, ny, k));
					}
				}
			}
		}
	}

	static class Point {
		int x, y, cnt;

		public Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

	}

}
