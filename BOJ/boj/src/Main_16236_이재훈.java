import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_16236_이재훈 {
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int N;
	static ArrayList<Fish> fishList;
	
	static class Fish{
		int x,y,size;
		Fish(int x,int y,int size){
			this.x = x;
			this.y = y;
			this.size = size;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		fishList = new ArrayList<>();
		Fish shark; // 아기 상어
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0)
					continue;
				else if(map[i][j] == 9) {
					shark = new Fish(i,j,2);
				}else {
					fishList.add(new Fish(i,j,map[i][j]));
				}
			}
		}
		
	}
	
	static void bfs(ArrayList<Fish> fishList, Fish shark) {
		// 가장 가까운 먹을 수 있는 물고기를 찾는다.
		
	}
	
	static ArrayList<Fish> find(ArrayList<Fish> fishList, Fish shark){
		ArrayList<Fish> nearList = new ArrayList<>();
		// 가장 짧은 거리부터 찾는다.(dfs)
		return nearList;
		
	}
	
	static void dfs(int cnt, Fish shark, Fish fish, int dist, boolean[][] visited) {
		if(shark.x == fish.x && shark.y == fish.y) {
			
		}
		for(int d=0;d<4;d++) {
			int nx = shark.x+dx[d];
			int ny = shark.y+dy[d];
			if(nx>=0 && nx<N && ny>=0 && ny<N) {
				if(shark.size >= map[nx][ny] && !visited[nx][ny]) {
					
				}
			}
		}
	}
	
	static void move() { // 상어 이동
		
	}
	
	static void eat() { // 상어가 먹는 것(가장 
		
	}
	
}
