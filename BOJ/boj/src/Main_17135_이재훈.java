import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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


	static void shoot(int n, int[] soldier) { // 화살: 사거리 안에 적 죽인다.
		for(int i=0;i<3;i++) { // 궁수
			for(int d=1;d<=D;d++) { // 
				if(n-d<0) break; // 범위 넘어가면 break
				int min = Integer.MAX_VALUE;
				int minIdx = -1;
				for(int j=0;j<M;j++) {
					if(map[n-d][j] == 1) {
						int dist = d+Math.abs(j-soldier[i]);
						if(dist<=D && dist < min) {
							min = dist;
							minIdx = j;
						}
					}
				if(minIdx != -1) {	
					map[n-d][j] = 0;
					answer += 1;
				}
				}
			}
		}
	}

	static void move(int n,int[] soldier) { // 궁수가 한 칸씩 위로 전진 : 궁수가 있는 행이 n
		for(int i=0;i<3;i++) {
			map[n-1][soldier[i]] = map[n][soldier[i]];
		}

	}
	
	static void setSoldier(int[] soldier) { // 궁수를 배치
		for(int i=0;i<3;i++) {
			map[N][soldier[i]] = 1;
		}
	}
	
	static void combi(int cnt, int start, int[] soldier) { // 궁수 세명의 위치를 배치
		if (cnt == 3) {
//			setSoldier(soldier);
			for(int i=N;i>0;i--) {
				move(i,soldier);
				shoot(i,soldier);
			}
			return;
		}
		for(int i= start;i<M;i++) {
			soldier[cnt] = i;
			combi(cnt+1,i+1,soldier);
		}
	}
}
