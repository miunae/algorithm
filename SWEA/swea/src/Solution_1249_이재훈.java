import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Solution_1249_이재훈 {
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			int[][] sum = new int[N][N];
			for(int i=0;i<N;i++) {
				char[] row = br.readLine().toCharArray();
				for(int j=0;j<N;j++) {
					map[i][j] = row[j]-'0';
				}
			}
			bfs(map,sum,N);
			System.out.printf("#%d %d\n",t,sum[N-1][N-1]);
		}
	}
	
	static void bfs(int[][] map, int[][] sum, int N) {
		ArrayDeque<Point> deq = new ArrayDeque<>();
		deq.add(new Point(0,0));
		boolean[][] visited = new boolean[N][N];
		visited[0][0] = true;
		while(!deq.isEmpty()) {
			Point cur = deq.pollFirst();
			for(int d=0;d<4;d++) {
				int nx = cur.x+dx[d];
				int ny = cur.y+dy[d];
				if(nx>=0 && nx<N && ny>=0 && ny<N) {
					if(visited[nx][ny]) {
						if(sum[nx][ny] > sum[cur.x][cur.y] + map[nx][ny]) {
							sum[nx][ny] = sum[cur.x][cur.y]+map[nx][ny];
							deq.add(new Point(nx,ny));
						}
					} else if(!visited[nx][ny]) {
						sum[nx][ny] = sum[cur.x][cur.y]+map[nx][ny];
						visited[nx][ny] = true;
						deq.add(new Point(nx,ny));
					}
				}
			}
		}
	}

	static class Point {
		int x,y;
		Point(int x, int y){
			this.x =x;
			this.y =y;
		}
	}
	
}
