import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3109_이재훈 {
	static int R,C;
	static char[][] arr;
	static boolean visited[][];
	static int cnt=0;
	static int[] dx = {-1,0,1};
	static int[] dy = {1,1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		for(int i=0;i<R;i++) {
			arr[i] = br.readLine().toCharArray();
		}
		visited = new boolean[R][C];
		for(int i=0;i<R;i++) {
			dfs(i,0);
		}
		System.out.println(cnt);
	}
	static void dfs(int x, int y) {
		if(y == C-1) {
			cnt+=1;
			return;
		}
		if(visited[x][y]) {
			return;
		}
		for(int d=0;d<3;d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			if(nx>=0 && nx < R && ny>=0 && ny < C && arr[nx][ny] != 'X') {
				visited[nx][ny] = true;
				dfs(nx,ny);
				visited[nx][ny] = false;
			}
		}
	}
}
