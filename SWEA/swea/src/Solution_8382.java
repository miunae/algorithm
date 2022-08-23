import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_8382 {
	static class Point{
		int x,y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[][] map = new int[202][202];
			boolean[][] visited = new boolean[202][202];
			Point start = new Point(Integer.parseInt(st.nextToken())+100, Integer.parseInt(st.nextToken())+100);
			Point end = new Point(Integer.parseInt(st.nextToken())+100, Integer.parseInt(st.nextToken())+100);
		}
	}
	
}
