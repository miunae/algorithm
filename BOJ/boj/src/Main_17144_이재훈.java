import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17144_이재훈 {
	static int R,C,T;
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static class Point{
		int x,y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		Point[] cleaners = new Point[2];
		map = new int[R][C];
		int cleanerCnt = 0;
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) {
					cleaners[cleanerCnt] = new Point(i,j);
					cleanerCnt += 1;
				}		
			}
		}
		while(T --> 0) {
			diffusion();
//			for(int i=0;i<R;i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
//			System.out.println();
			circulation(cleaners[0],cleaners[1]);
//			for(int i=0;i<R;i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
//			System.out.println();
		}
		int answer = 0;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				answer += map[i][j];
			}
		}
//		for(int i=0;i<R;i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		System.out.println(answer+2);
		
	}
	static void diffusion(){ // 1초동안 확산한 것
		int[][] calMap = new int[R][C]; // 더하고 뺄 양을 저장 (calculatorMap)
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j] == -1 || map[i][j] == 0) continue; // 공청기가 있거나 미세먼지가 없는 곳은 pass
				ArrayList<Point> adjList = new ArrayList<>();
				for(int d=0;d<4;d++) {
					int nx = i+dx[d];
					int ny = j+dy[d];
					if(nx>=0 && nx<R && ny>=0 && ny<C && map[nx][ny] != -1) {
						adjList.add(new Point(nx,ny));
					}
				}
				int plus = map[i][j]/5;
				int minus = plus*adjList.size();
				calMap[i][j] -= minus;
				for(int k=0;k<adjList.size();k++) {
					int x = adjList.get(k).x;
					int y = adjList.get(k).y;
					calMap[x][y] += plus;
				}
			}
		}
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j] == -1) continue;
				map[i][j] += calMap[i][j];
			}
		}
	}

	static void circulation(Point up, Point down) { // 순환
		int upx = up.x;
		int upy = up.y;
		int downx = down.x;
		int downy = down.y;
		// 공청기 위쪽
		int up1 = map[upx][C-1];
		for(int i=C-1;i>0;i--) { // 오른쪽
			map[upx][i] = map[upx][i-1];
		}
		map[upx][1] = 0;
		if(upx!=0) {
			int up2 = map[0][C-1];
			int up3 = map[0][0];
			for(int i=0;i<upx;i++) { // 위로 올리고
				map[i][C-1] = map[i+1][C-1];
			}
			map[upx-1][C-1] = up1; 
			for(int i=0;i<C-2;i++) { // 왼쪽으로
				map[0][i] = map[0][i+1];
			}
			map[0][C-2] = up2;
			for(int i=upx-1;i>1;i--) { // 아래로 내리고
				map[i][0] = map[i-1][0];
			}
			map[1][0] = up3;
		}
		// 공청기 아래쪽
		int down1 = map[downx][C-1];
		for(int i=C-1;i>0;i--) { // 오른쪽으로
			map[downx][i] = map[downx][i-1];
		}
		map[downx][1] = 0;
		if(downx != R-1) {
			int down2 = map[R-1][C-1];
			int down3 = map[R-1][0];
			for(int i=R-1;i>downx;i--) { // 아래로
				map[i][C-1] = map[i-1][C-1];
			}
			map[downx+1][C-1] = down1;
			for(int i=0;i<C-2;i++) { // 왼쪽으로
				map[R-1][i] = map[R-1][i+1];
			}
			map[R-1][C-2] = down2;
			for(int i=downx+1;i<R-2;i++) { // 위로
				map[i][0] = map[i+1][0];
			}
			map[R-2][0] = down3;
		}
		
	}
	
}
