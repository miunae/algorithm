import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1987_이재훈 {
	static int R, C, cnt = 0, max = 0;
	static int[][] arr;
	static int[] dx;
	static int[] dy;
	static boolean[] visited = new boolean[26];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new int[R][C];
		dx = new int[] { -1, 1, 0, 0 };
		dy = new int[] { 0, 0, -1, 1 };
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for(int j=0;j<C;j++) {
				arr[i][j] = str.charAt(j)-'A';
			}
		}
		dfs(0,0,0);
		System.out.println(max);
	}

	static void dfs(int x, int y, int cnt) {
		if(visited[arr[x][y]]) {
			max = Math.max(max, cnt);
			return;
		}
		visited[arr[x][y]] = true;
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
				dfs(nx, ny,cnt+1);
			}
		}
		visited[arr[x][y]] = false;

	}
}
