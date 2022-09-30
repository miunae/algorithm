import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 가로(state:1) => 오른쪽 칸 or 대각선 오른쪽아래가 비어있어야함.
 * 세로(state:2) => 아래 칸 or 오른쪽  아래칸 비어있어야함.
 * 대각선(state:3) => 오른쪽 칸 or 아래 칸 or 오른쪽 아래 칸 비어있어야 함.
 */
public class Main_17070_이재훈 {
	static int N, cnt;
	static int[][] map;
	static Pipe cur;
	static int[] dx1 = {0,1}; // 옵션별로 delta 구성
	static int[] dy1 = {1,1}; // 옵션(1,3)
	static int[] dx2 = {1,1};
	static int[] dy2 = {0,1}; // 옵션(2,3)
	static int[] dx3 = {0,1,1};
	static int[] dy3 = {1,0,1}; // 옵션(1,2,3)
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		map = new int[N][N];
		cnt=0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cur = new Pipe(0,1,1); // 가로 상태의 (0,0),(1,1)인 파이프
		dfs(cur);
		if(cnt == 0)
			System.out.println(0);
		else
			System.out.println(cnt);
	}
	/*
	 * pipe 상태 => 1: 가로, 2: 세로, 3: 대각선
	 */
	static class Pipe{	// 파이프 중에 마지막 점
		int x,y,state;
		Pipe(int x, int y, int state){
			this.x = x;
			this.y = y;
			this.state = state;
		}
	}
	
	/*
	 * state별로 dfs를 타주면서 pipe의 x,y값이 N-1이면 dfs를 종료해주고 cnt의 값 1 update
	 */
	static void dfs(Pipe pipe) {
//		System.out.println(pipe.x+" "+pipe.y);
		if(pipe.x == N-1 && pipe.y == N-1) {
			cnt += 1;
			return;
		}
		if(pipe.state == 1) {
			for(int d=0;d<2;d++) {
				int dx = pipe.x+dx1[d];
				int dy = pipe.y+dy1[d];
				if(d == 0) {
					if(dx>=0 && dx<N && dy>=0 && dy<N && map[dx][dy] == 0)
						dfs(new Pipe(dx,dy,1));
				}else if(d == 1) {
					if(dx>=0 && dx<N && dy>=0 && dy<N && map[dx-1][dy]==0 && map[dx][dy-1]==0 && map[dx][dy]==0)
						dfs(new Pipe(dx,dy,3));
				}
			}
		}
		if(pipe.state == 2) {
			for(int d=0;d<2;d++) {
				int dx = pipe.x+dx2[d];
				int dy = pipe.y+dy2[d];
				if(d==0) {
					if(dx>=0 && dx<N && dy>=0 && dy<N && map[dx][dy]==0)
						dfs(new Pipe(dx,dy,2));
				}else if(d==1) {
					if(dx>=0 && dx<N && dy>=0 && dy<N && map[dx-1][dy]==0 && map[dx][dy-1]==0 && map[dx][dy]==0)
						dfs(new Pipe(dx,dy,3));
				}
			}
		}
		if(pipe.state == 3) {
			for(int d=0;d<3;d++) {
				int dx = pipe.x+dx3[d];
				int dy = pipe.y+dy3[d];
				if(d==0) {
					if(dx>=0 && dx<N && dy>=0 && dy<N && map[dx][dy] == 0)
						dfs(new Pipe(dx,dy,1));
				}else if(d==1) {
					if(dx>=0 && dx<N && dy>=0 && dy<N && map[dx][dy]==0)
						dfs(new Pipe(dx,dy,2));
				}else if(d==2) {
					if(dx>=0 && dx<N && dy>=0 && dy<N && map[dx-1][dy]==0 && map[dx][dy-1]==0 && map[dx][dy]==0)
						dfs(new Pipe(dx,dy,3));
				}
			}
		}
	}
}
