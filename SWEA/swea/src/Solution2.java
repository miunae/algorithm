import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution2 {
	static int N,num;
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[] allVisited;
	static int min;
	static ArrayList<Point> pointList;
//	static ArrayList<Point> customerList;
	static class Point implements Comparable<Point>{
		int x,y,no;
		Point(int x,int y,int no){
			this.x = x;
			this.y = y;
			this.no = no;
		}
		@Override
		public int compareTo(Point o) {
			return this.no - o.no;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = null;
			num = 0; // 몬스터의 수
			map = new int[N][N];
			pointList = new ArrayList<>();
			pointList.add(new Point(0,0,0)); // 한개를 그냥 채워준다.
//			customerList = new ArrayList<>();
			min = Integer.MAX_VALUE;
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]>0) {
						pointList.add(new Point(i,j,map[i][j])); // 몬스터 리스트
						num+=1;
					}
					else if(map[i][j] < 0) {
						pointList.add(new Point(i,j,map[i][j])); // 고객 리스트
						num+=1;
					}
				}
			}
			for(int i=1;i<=num;i++) {
				if(pointList.get(i).no<0) {
					pointList.get(i).no = Math.abs(pointList.get(i).no)+num/2;
				}
			}
			Collections.sort(pointList);
			allVisited = new boolean[num+1];
			int[] nums = new int[num];
			dfs(0,nums);
			System.out.printf("#%d %d\n",t,min);
		}
	}
	
	static void dfs(int depth,int[] nums) {
		if(depth !=0) {
			int tmp = nums[depth-1];
			if(tmp>num/2) {
				if(!allVisited[tmp-num/2])
					return;
			}
		}
		if(depth == num) {
			int curx=0,cury=0; // 현재 사냥꾼 시작점 좌표
			int total=0;
			for(int i=0;i<num;i++) {
				Point p = pointList.get(nums[i]);
				total += Math.abs(p.x-curx)+Math.abs(p.y-cury);
				curx = p.x; cury = p.y;
			}
			min = Math.min(min, total);
			return;
		}
		for(int i=1;i<=num;i++) {
			if(allVisited[i]) continue;
			allVisited[i] = true;
			nums[depth] = i;
			dfs(depth+1,nums);
			allVisited[i] = false;
		}
		
	}
	
}
