import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10026_이재훈 {
	static char[][] map;
	static int N,normalCnt=0;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[][] visited1;
	
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
		 
	}
	static void dfs(Point p) {
		visited1[p.x][p.y] = true;
		for(int d=0;d<4;d++) {
			int nx = p.x+dx[d];
			int ny = p.y+dy[d];
			if(nx>=0 && nx<N && ny>=0 && ny<N)
				dfs(new Point(nx,ny));
		}
	}
}
