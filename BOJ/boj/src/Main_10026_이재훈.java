import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main_10026_이재훈 {
	static char[][] map;
	static int N;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[][] visited1; // 정상인
	
	static class Point{
		int x,y;
		Point(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 N = Integer.parseInt(br.readLine());
		 visited1 = new boolean[N][N];
		 map = new char[N][N];
		 for(int i=0;i<N;i++)
			 map[i] = br.readLine().toCharArray();
		 int normalCnt = 0;
		 for(int i=0;i<N;i++) {
			 for(int j=0;j<N;j++) {
				 if(!visited1[i][j]) {
					 normalCnt += 1;
					 visited1[i][j] = true;
					 bfs(new Point(i,j));
				 }
			 }
		 }
		 System.out.println(normalCnt);
		 for(int i=0;i<N;i++) {
			 for(int j=0;j<N;j++) {
				 if(map[i][j] == 'G') {
					 map[i][j] = 'R';
				 }
			 }
		 }
		 visited1 = new boolean[N][N];
		 int cnt = 0; // 적록색맹 수
		 for(int i=0;i<N;i++) {
			 for(int j=0;j<N;j++) {
				 if(!visited1[i][j]) {
					 cnt+=1;
					 visited1[i][j] = true;
					 bfs(new Point(i,j));
				 }
			 }
		 }
		 System.out.println(cnt);
	}
	
	static void bfs(Point p) {
		Queue<Point> q = new ArrayDeque<>();
		q.offer(p);
		while(!q.isEmpty()) {
			Point tmp = q.poll();
			for(int d=0;d<4;d++) {
				int nx = tmp.x+dx[d];
				int ny = tmp.y+dy[d];
				if(nx>=0 && nx<N && ny>=0 && ny<N && !visited1[nx][ny] && map[tmp.x][tmp.y]==map[nx][ny]) {
					visited1[nx][ny] = true;
					q.offer(new Point(nx,ny));
				}
			}
		}
	}
	
}
