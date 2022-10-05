import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14502_이재훈 {
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int N,M,answer;
	static boolean[][] visited;
	static ArrayList<int[]> list; // 벽을 세울 수 있는 위치 저장
	static ArrayList<int[]> virusList;
	static int[] numbers;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer = 0;
		map = new int[N][M];
		list = new ArrayList<>();
		virusList = new ArrayList<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) {
					list.add(new int[] {i,j}); // 후보군 list에 저장
				}
				else if(map[i][j] == 2) {
					virusList.add(new int[] {i,j});
				}
			}
		}
		numbers= new int[3];
//		System.out.println(list.size());
//		System.out.println(virusList.size());
		combi(0,0);
		System.out.println(answer);
	}
	
	static void combi(int depth, int start) {
		if(depth == 3) { // 기저 조건
//			System.out.println(Arrays.toString(numbers));
//			if(map[0][4] == 1 && map[1][3]==1 && map[3][3]==1) {
//				System.out.println("여기");
//			}
			int res = spread();
			answer = Math.max(res, answer);
			return;
		}
		for(int i=start;i<list.size();i++) {
			int x = list.get(i)[0];
			int y = list.get(i)[1];
//			numbers[depth] = i;
			map[x][y] = 1; // 벽으로
			combi(depth+1,i+1);
			map[x][y] = 0; // 다시 빈 칸으로
		}
	}
	
	static int spread() {
		int[][] arr = copy();
		ArrayDeque<int[]> deq = new ArrayDeque<>();
		for(int i=0;i<virusList.size();i++) {
			int x = virusList.get(i)[0];
			int y = virusList.get(i)[1];
			deq.add(new int[] {x,y});
			while(!deq.isEmpty()) {
				int[] cur = deq.pollFirst();
				for(int d=0;d<4;d++) {
					int nx = cur[0]+dx[d];
					int ny = cur[1]+dy[d];
					if(nx>=0&&nx<N&&ny>=0&&ny<M&&arr[nx][ny]==0) {
						arr[nx][ny]=2;
						deq.add(new int[] {nx,ny});
					}
				}
			}
		}
		int sum = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j] == 0) {
					sum += 1;
				}
			}
		}
		return sum;
	}
	
	static int[][] copy(){
		int[][] arr = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				arr[i][j] = map[i][j];
			}
		}
		return arr;
	}
}
