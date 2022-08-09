import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution_1861_이재훈 {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] arr;
//	static boolean[][] check;
	static int N;
	public static int BFS(int[] node) {
		Deque<int[]> deq = new ArrayDeque<>();
		deq.add(node);
		int cnt = 0;
		while(deq.size() != 0) {
			int[] tmp = deq.removeFirst();
//			check[tmp[0]][tmp[1]] = true;
			for(int d=0;d<4;d++) {
				int nx = tmp[0]+dx[d];
				int ny = tmp[1]+dy[d];
				if(nx>=0 && nx<N && ny>=0 && ny<N && arr[nx][ny]-arr[tmp[0]][tmp[1]] == 1 ) {
					cnt += 1;
					deq.addLast(new int[] {nx,ny});
				}
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int max = 0;
			int point = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
//					if(check[i][j] == true) {
//						continue;
//					}
//					check = new boolean[N][N];

					int cur = BFS(new int[] {i,j});
					if(cur > max) {
						max = cur;
						point = arr[i][j];
					}else if(cur == max) {
						if(arr[i][j]<point)
							point = arr[i][j];
					}
				}
			}
			System.out.printf("#%d %d %d\n",t,point,max+1);
		}
	}

}
