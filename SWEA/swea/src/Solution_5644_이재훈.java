import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5644_이재훈 {
	static int[] dx, dy;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		dx = new int[] { 0, -1, 0, 1, 0 };
		dy = new int[] { 0, 0, 1, 0, -1 };
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken()); // 움직인 시간
			int A = Integer.parseInt(st.nextToken());
			int[][] arr = new int[11][11]; // 전체 지도
			int[] moveA = new int[M];
			int[] moveB = new int[M];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++)
				moveA[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++)
				moveB[i] = Integer.parseInt(st.nextToken());
			int[][] spot = new int[A][2]; // 중간지점
			int[][] charge = new int[A][2]; // 스팟마다 거리, 충전 양 저장
			// 좌표에 충전 양 저장(AP가 겹치는 구역은 일단 -1)
			for (int a = 0; a < A; a++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken()); // AP의 좌표(x,y)
				spot[a][0] = y;
				spot[a][1] = x; // 스팟 정보 기억(가운데 점)
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				charge[a][0] = c;
				charge[a][1] = p;
				for (int i = 1; i <= 10; i++) {
					for (int j = 1; j <= 10; j++) {
						if (Math.abs(y - i) + Math.abs(x - j) <= c) {
							if (arr[i][j] == 0) {
								arr[i][j] = p;
							} else {
								arr[i][j] = -1; // 겹치면 -1로 처리해놓음
							}
						}
					}
				}
			}

			// 이동
			int[] curA = new int[] { 1, 1 };
			int[] curB = new int[] { 10, 10 };
			int sumA = 0, sumB = 0; // 충전 양 저장
			int cnt = 0;
			while (cnt < M + 1) {
				// 다른 구역일 때(둘다 -1 아님, A만 -1, B만 -1)
				if (arr[curA[0]][curA[1]] != arr[curB[0]][curB[1]]) {
					if (arr[curA[0]][curA[1]] == -1) { // A가 -1
						sumB += arr[curB[0]][curB[1]];
						int max = 0;
						int Bidx = 0;
						for (int i = 0; i < A; i++) {
							if (Math.abs(curB[0] - spot[i][0]) + Math.abs(curB[1] - spot[i][1]) <= charge[i][0]) {
								Bidx = i;
								break;
							}
						}
						for (int i = 0; i < A; i++) {
							if (Math.abs(curA[0] - spot[i][0]) + Math.abs(curA[1] - spot[i][1]) <= charge[i][0]) {
								if (i == Bidx)
									continue;
								else {
									max = Math.max(max, charge[i][1]);
								}
							}
						}
						sumA += max;
					} else if (arr[curB[0]][curB[1]] == -1) { // B가 -1
						sumA += arr[curA[0]][curA[1]];
						int max = 0;
						int Aidx = 0;
						for (int i = 0; i < A; i++) {
							if (Math.abs(curA[0] - spot[i][0]) + Math.abs(curA[1] - spot[i][1]) <= charge[i][0]) {
								Aidx = i;
								break;
							}
						}
						for (int i = 0; i < A; i++) {
							if (Math.abs(curB[0] - spot[i][0]) + Math.abs(curB[1] - spot[i][1]) <= charge[i][0]) {
								if (i == Aidx)
									continue;
								else {
									max = Math.max(max, charge[i][1]);
								}
							}
						}
						sumB += max;
					} else { // 둘다 -1도 아니고 값이 다르면
						sumA += arr[curA[0]][curA[1]];
						sumB += arr[curB[0]][curB[1]];
					}
					if (cnt == M)
						break;
					curA[0] = curA[0] + dx[moveA[cnt]];
					curA[1] = curA[1] + dy[moveA[cnt]];
					curB[0] = curB[0] + dx[moveB[cnt]];
					curB[1] = curB[1] + dy[moveB[cnt]];
					cnt++;
				}
				// 같은 구역일 때(둘 다 -1일때, 좌표 다를 때)
				else {
					if (arr[curA[0]][curA[1]] == -1 && arr[curB[0]][curB[1]] == -1) { // 둘 다 -1일 때
						
						int[][] charges = new int[2][A]; // 1행: A의 충전소 여부 , 2행: B의 충전소 여부 , data: p(충전량)
						for (int i = 0; i < A; i++) { // A의 최대값
							if (Math.abs(curA[0] - spot[i][0]) + Math.abs(curA[1] - spot[i][1]) <= charge[i][0]) {
								charges[0][i] = charge[i][1];
							}
							if (Math.abs(curB[0] - spot[i][0]) + Math.abs(curB[1] - spot[i][1]) <= charge[i][0]) {
								charges[1][i] = charge[i][1];
							}
						}
						int Amax =0,Bmax=0;
						int realMax = 0;
						for(int i=0;i<A;i++) {
							for(int j=0;j<A;j++) {
								if(i==j)
									continue;
								if(charges[0][i]+charges[1][j] > realMax) {
									realMax = charges[0][i]+charges[1][j];
									Amax = charges[0][i];
									Bmax = charges[1][j];
								}
							}
						}
						sumA += Amax;
						sumB += Bmax;


					} else { // 같은 구역이고 둘다 -1이 아님
						sumA += arr[curA[0]][curA[1]] / 2;
						sumB += arr[curB[0]][curB[1]] / 2;
					}
					if (cnt == M)
						break;
					curA[0] = curA[0] + dx[moveA[cnt]];
					curA[1] = curA[1] + dy[moveA[cnt]];
					curB[0] = curB[0] + dx[moveB[cnt]];
					curB[1] = curB[1] + dy[moveB[cnt]];
					cnt++;
				}
			}
			System.out.println("#"+t+" "+(sumA + sumB));
		}
	}

}
