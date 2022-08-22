import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution_2819_BFS {
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
//	static int[] nums;
	static int cnt = 0;
	static TreeSet<String> set;
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			map = new int[4][4];
			for (int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			set = new TreeSet<>();
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					sb = new StringBuilder();
//					nums = new int[] {map[i][j],0,0,0,0,0,0};
//					dfs(0,i,j,nums);
					bfs(i, j);
				}
			}
			System.out.printf("#%d %d\n", t, set.size());
		}
	}

	static void bfs(int x, int y) {
//		int[] nums = {map[x][y],0,0,0,0,0,0};
		// que와 nums를 같이 6번 작업하면 된다.
		Queue<int[]> que = new LinkedList<>();
		Queue<String> nums = new LinkedList<>();
		que.offer(new int[] { x, y, 1 });
		nums.offer(map[x][y] + "");
		while (!que.isEmpty()) {
			int[] cur = que.poll();
			String curs = nums.poll();
			int cr = cur[0];
			int cc = cur[1];
			int cnt = cur[2];
			if (cnt == 7) {
				set.add(curs);
				continue;
			}
			for (int d = 0; d < 4; d++) {
				int nx = cr + dx[d];
				int ny = cc + dy[d];
				if (!(nx >= 0 && nx < 4 && ny >= 0 && ny < 4)) {
					continue;
				}
				que.offer(new int[] { ny, ny, cnt + 1 });
				nums.offer(curs + (map[nx][ny]) + "");
			}
		}
	}

	static void dfs(int cnt, int x, int y, int[] nums) {
		if (cnt == 6) {
			for (int i = 0; i < 7; i++) {
				sb.append(nums[i]);
			}
			set.add(sb.toString());
			sb.setLength(0);
			return;
		}

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (!(nx >= 0 && nx < 4 && ny >= 0 && ny < 4))
				continue;
			nums[cnt + 1] = map[nx][ny];
			dfs(cnt + 1, nx, ny, nums);
		}
	}
}
