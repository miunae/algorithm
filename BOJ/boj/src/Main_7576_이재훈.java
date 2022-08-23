import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576_이재훈 {
	static int N,M, notCnt;
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		notCnt = 0; // 토마토가 존재하지 않는 칸 수
		visited = new boolean[N][M];
		ArrayList<int[]> tomatoList = new ArrayList<>();
		int x,y=0;
		int sum = 0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					sum += 1;
					x=i;
					y=j;
					tomatoList.add(new int[] {x,y});
				}else if(map[i][j] == -1) {
					notCnt += 1;
				}
			}
		}
		if(sum == M*N-notCnt)
			System.out.println(0);
		else {
			System.out.println(bfs(tomatoList));
			
		}
		
		
	}
	static int bfs(ArrayList<int[]> tomatoList) {
		int cnt = 0;
		Queue<int[]> que = new LinkedList<>();
		for(int i=0;i<tomatoList.size();i++) {
			que.offer(tomatoList.get(i));
		}
		while(!que.isEmpty()) {
			int qSize = que.size();
			for(int t=0;t<qSize;t++) { // qSize만큼 반복
				int[] tmp = que.poll();
				visited[tmp[0]][tmp[1]] = true;
				for(int d=0;d<4;d++) {
					int nx = tmp[0]+dx[d];
					int ny = tmp[1]+dy[d];
					if(nx>=0 && nx < N && ny>=0 && ny<M && !visited[nx][ny]) {
						if(map[nx][ny] == -1) {
							visited[nx][ny] = true;
							continue;
						}else if(map[nx][ny] == 0) {
							map[nx][ny] = 1;
							que.offer(new int[] {nx,ny});
						}
					}
				}
			}
			cnt++;
//			System.out.println(cnt);
		}
		boolean success = true;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] == 0) {
					success = false;
					break;
				}
			}
			if(!success)
				break;
		}
		if(!success)
			return -1;
		return cnt-1;
	}
}
