import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15686_이재훈 {
	static boolean[] visited;
	static int hCnt,M, cCnt,min;
	static int[] dist;
	// 집에서 가장 가까운 치킨집 치킨거리 뽑아내는 메서드
	// arr 
	static void distances(ArrayList<int[]> homes, int x, int y) {
		for(int i=0;i<hCnt;i++) {
			dist[i] = Math.min(dist[i], Math.abs(homes.get(i)[0]-x)+Math.abs(homes.get(i)[1]-y));
		}
		 
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] city = new int[N][N];
		ArrayList<int[]> chickens = new ArrayList<>(); // 치킨집  인덱스
		ArrayList<int[]> homes = new ArrayList<>(); // 집 인덱스 정보 저장
		// 치킨집의 인덱스 정보 저장 배열
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp == 2) {
					int[] ctmp = new int[2];
					ctmp[0] = i;
					ctmp[1] = j;
					chickens.add(ctmp);
				}
				if(tmp == 1) {
					int[] htmp = new int[2];
					htmp[0] = i;
					htmp[1] = j;
					homes.add(htmp);
				}
				city[i][j] = tmp;
			}
		}
		hCnt = homes.size();
		cCnt = chickens.size();
		dist = new int[hCnt]; // 집에서 치킨집까지 거리를 치킨집 조합마다 돌면서 최단거리 계속 갱신
		for(int i=0;i<hCnt;i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		visited = new boolean[cCnt];
		min = Integer.MAX_VALUE;
		subset(0,0,homes,chickens);
		sb.append(min).append("\n");
		System.out.println(sb);
		
	} 
	static void subset(int cnt, int getCnt, ArrayList<int[]> homes, ArrayList<int[]> chickens ) {
		if(cnt == cCnt) {
			if(getCnt == 0)
				return;
			if(getCnt <= M) {
				for(int i=0;i<cCnt;i++) {
					if(visited[i]) {
						int x = chickens.get(i)[0];
						int y = chickens.get(i)[1];
						distances(homes,x,y);
					}
				}
				int distSum = 0;
				for(int i=0;i<hCnt;i++) {
					distSum += dist[i];
				}
				min = Math.min(min,distSum);
				for(int i=0;i<hCnt;i++) {
					dist[i] = Integer.MAX_VALUE;
				}
			}
			return;
		}
		
		visited[cnt] = true;
		subset(cnt+1,getCnt+1,homes,chickens);
		visited[cnt] = false;
		subset(cnt+1,getCnt,homes,chickens);
	}
}
