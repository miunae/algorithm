import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_17135_이재훈 {
	static int[][] map;
	static int N, M, D,answer=0;
	 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		int[] soldier = new int[3];
		map = new int[N + 1][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		combi(0,0,soldier);
		System.out.println(answer);

	}


	static void shoot( int[] soldier) { // 화살: 사거리 안에 적 죽인다.
		int soldiers = N; // 초기 궁수
		int tmp=0;
		int[][] map2 = mapCopy(map);
		while(soldiers>0) {
			ArrayList<Integer[]> enemy = new ArrayList<>();
			for(int d=0;d<3;d++) { // 궁수
				int min = Integer.MAX_VALUE;
				int[] pos = new int[2]; // 가까운 적 위치
				for(int j=0;j<M;j++) { // 열을 전부 스캔
					for(int i=soldiers-1;i>=0;i--) {
						int dist = Math.abs(soldiers-i)+Math.abs(soldier[d]-j);
						if(map2[i][j] == 1 & dist <= D) {
							if(dist<min) {
								min = dist;
								pos[0] = i;
								pos[1] = j;
							}
							break;
						}
					}
				}
				if(min != Integer.MAX_VALUE) { // 적이 있다면 enemy에 추가
					enemy.add(new Integer[] {pos[0],pos[1]});
				}
			}
			for(int i=0;i<enemy.size();i++) {
				if(map2[enemy.get(i)[0]][enemy.get(i)[1]]!=0) {
					tmp+=1;
					map2[enemy.get(i)[0]][enemy.get(i)[1]]=0; //중복되는 거 0으로
				}
			}
			soldiers -= 1;
		}
		if(tmp>answer)
			answer = tmp;
	}

	
	
	static void combi(int cnt, int start, int[] soldier) { // 궁수 세명의 위치를 배치
		if (cnt == 3) {
			shoot(soldier);
			return;
		}
		for(int i= start;i<M;i++) {
			soldier[cnt] = i;
			combi(cnt+1,i+1,soldier);
		}
	}
	
	static int[][] mapCopy(int[][] arr){
		int[][] arr2 = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				arr2[i][j] = arr[i][j];
			}
		}
		return arr2;
	}
}
