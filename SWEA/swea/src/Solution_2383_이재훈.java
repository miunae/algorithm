import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_2383_이재훈 {
	static int N;
	static int[][] map;
	static ArrayList<Point> personList;
	static Point[] spots;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int t=1;t<=T;t++) {
			int spotCnt = 0; //계단 idx
			spots = new Point[2];
			personList = new ArrayList<>();
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) {
						personList.add(new Point(i,j));
					}
					if(map[i][j] > 1) {
						spots[spotCnt++] = new Point(i,j);
					}
				}
			}
			int[] nums = new int[personList.size()];
		}
	}
	static class Point{
		int x,y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static void comb(int cnt, int start, int[] nums) {
		if(cnt == personList.size()) {
			
			return;
		}
		for(int i=start;i<2;i++) {
			nums[cnt] = i;
			comb(cnt+1,i,nums);
		}
	}
}
