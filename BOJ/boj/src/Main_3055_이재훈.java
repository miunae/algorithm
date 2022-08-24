import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3055_이재훈 {
	static char[][] map;
	static int R, C, day = 0;
	static Point go; // 고슴도치, 굴
	static Queue<Point> waterList;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean notFinish=true;

	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		waterList = new ArrayDeque<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'S') {
					go = new Point(i, j);
				}
				if (map[i][j] == '*') {
					waterList.add(new Point(i, j));
				}
			}
		}
		dayBFS();
		if (notFinish) {
			System.out.println("KAKTUS");
		} else {
			System.out.println(day);
		}
	}



	static void dayBFS() {
		Queue<Point> goq = new ArrayDeque<>();
		goq.offer(go);
		boolean[][] visited = new boolean[R][C];
		boolean arrive = false;
		while (!goq.isEmpty()) {
			int goqSize = goq.size();
			if (arrive)
				break;
			int qSize = waterList.size();
			for (int i = 0; i < qSize; i++) {
				Point water = waterList.poll();
				for (int d = 0; d < 4; d++) {
					int nx = water.x + dx[d];
					int ny = water.y + dy[d];
					if (nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] == '.') {
						map[nx][ny] = '*'; // 물 채우고
						waterList.offer(new Point(nx, ny)); // waterList에 다시 추가
					}
				}
			}
			for (int i = 0; i < goqSize; i++) {
				if (arrive)
					break;
				Point cur = goq.poll();
//				visited[cur.x][cur.y] = true;
				for (int d = 0; d < 4; d++) {
					int nx = cur.x + dx[d];
					int ny = cur.y + dy[d];
					if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[nx][ny]) {
						if (map[nx][ny] == 'D') {
							arrive = true;
							notFinish = false;
							day++;
							return;
						}
						if (map[nx][ny] == '.') {
							goq.offer(new Point(nx, ny));
							visited[nx][ny] = true;
						}
					}
				}
			}
			day++;
		}
//		if (!arrive) {
//			notFinish = true;
//		}
	}
}
