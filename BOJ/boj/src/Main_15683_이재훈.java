import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_15683_이재훈 {
	static int min, N, M;
	static int[][] arr;
	static ArrayList<cctv> cctvs;
	static ArrayList<cctv> tmp;
	static int[] dx;
	static int[] dy;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		cctvs = new ArrayList<>(); // cctv들을 저장한 ArrayList
		tmp = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] != 0 && arr[i][j] != 6) {
					cctv ct = new cctv(i, j, arr[i][j]);
					cctvs.add(ct);
				}
			}
		}
		dx = new int[]{0,1,0,1};// 우하좌상
		dy = new int[] {1,0,-1,0};
		min = Integer.MAX_VALUE;
		comb(0, 0);
		System.out.println(min);
	}

	public static class cctv {
		public int x, y, num, option;

		cctv(int x, int y, int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}
	}

	static void comb(int cnt, int start) { // 회전 옵션을 넣는 조합 생성
		if (cnt == cctvs.size()) {
			process(tmp);
			return;
		}
		for (int i = start; i < cctvs.size(); i++) {
			if (cctvs.get(i).num == 5) {
				tmp.add(cctvs.get(i));
				comb(cnt + 1, i + 1);
			} else if (cctvs.get(i).num == 2) {
				cctv c = cctvs.get(i);
				c.option = 1;
				tmp.add(c);
				comb(cnt + 1, i + 1);
				c.option = 2;
				tmp.add(c);
				comb(cnt + 1, i + 1);
			} else if(cctvs.get(i).num == 1 || cctvs.get(i).num == 3 || cctvs.get(i).num == 4){
				cctv c = cctvs.get(i);
				c.option = 1;
				tmp.add(c);
				comb(cnt + 1, i + 1);
				c.option = 2;
				tmp.add(c);
				comb(cnt + 1, i + 1);
				c.option = 3;
				tmp.add(c);
				comb(cnt + 1, i + 1);
				c.option = 4;
				tmp.add(c);
				comb(cnt + 1, i + 1);
			}

		}
	}

	static void process(ArrayList<cctv> list) { // 들어온 회전 옵션을 적용한 cctv를 작동시켜 사각지대 최소값 계산
		int[][] arr2 = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr2[i][j] = arr[i][j];
			}
		}
		for (cctv ct : list) {
			if (ct.num == 1) {
				if (ct.option == 1) { // 우
					for(int i=ct.y+1;i<M;i++) { // 우
						if(i == M)
							break;
						else if(arr2[ct.x][i] == 6)
							break;
						else if(arr2[ct.x][i] == 0)
							arr2[ct.x][i] = -1; //-1로 처리
					}
				}
				else if (ct.option == 2) { // 하
					for(int i=ct.x+1;i<N;i++) { // 하
						if(i == N)
							break;
						else if(arr2[i][ct.y] == 6)
							break;
						else if(arr2[i][ct.y]== 0)
							arr2[i][ct.y]=-1; 
					}
				}
				else if (ct.option == 3) { // 좌
					for(int i=ct.y-1;i>=0;i--) { // 좌
						if(i == -1)
							break;
						else if(arr2[ct.x][i] == 6)
							break;
						else if(arr2[ct.x][i] == 0)
							arr2[ct.x][i] = -1; //-1로 처리
					}
				}
				else if (ct.option == 4) { // 상
					for(int i=ct.x-1;i>=0;i--) { // 상
						if(i == -1)
							break;
						else if(arr2[i][ct.y] == 6)
							break;
						else if(arr2[i][ct.y] == 0)
							arr2[i][ct.y] = -1; //-1로 처리
					}
				}
			}
			else if (ct.num == 2) {
				if (ct.option == 1) {
					for(int i=ct.y+1;i<M;i++) {
						if(i == M)
							break;
						else if(arr2[ct.x][i] == 6)
							break;
						else if(arr2[ct.x][i] == 0)
							arr2[ct.x][i] = -1; //-1로 처리
					}
					for(int i=ct.y-1;i>=0;i--) {
						if(i == -1)
							break;
						else if(arr2[ct.x][i] == 6)
							break;
						else if(arr2[ct.x][i] == 0)
							arr2[ct.x][i] = -1; //-1로 처리
					}
				}
				else if (ct.option == 2) {
					for(int i=ct.x+1;i<N;i++) {
						if(i == N)
							break;
						else if(arr2[i][ct.y] == 6)
							break;
						else if(arr2[i][ct.y]== 0)
							arr2[i][ct.y]=-1; 
					}
					for(int i=ct.x-1;i>=0;i--) {
						if(i == -1)
							break;
						else if(arr2[i][ct.y] == 6)
							break;
						else if(arr2[i][ct.y] == 0)
							arr2[i][ct.y] = -1; //-1로 처리
					}
				}
			}
			else if (ct.num == 3) {
				if (ct.option == 1) {
					for(int i=ct.x-1;i>=0;i--) {
						if(i == -1)
							break;
						else if(arr2[i][ct.y] == 6)
							break;
						else if(arr2[i][ct.y] == 0)
							arr2[i][ct.y] = -1; //-1로 처리
					}
					for(int i=ct.y+1;i<M;i++) {
						if(i == M)
							break;
						else if(arr2[ct.x][i] == 6)
							break;
						else if(arr2[ct.x][i] == 0)
							arr2[ct.x][i] = -1; //-1로 처리
					}
				}
				else if (ct.option == 2) {
					for(int i=ct.y+1;i<M;i++) { // 우
						if(i == M)
							break;
						else if(arr2[ct.x][i] == 6)
							break;
						else if(arr2[ct.x][i] == 0)
							arr2[ct.x][i] = -1; //-1로 처리
					}
					for(int i=ct.x+1;i<N;i++) { // 하
						if(i == N)
							break;
						else if(arr2[i][ct.y] == 6)
							break;
						else if(arr2[i][ct.y]== 0)
							arr2[i][ct.y]=-1; 
					}
				}
				else if (ct.option == 3) {
					for(int i=ct.x+1;i<N;i++) { // 하
						if(i == N)
							break;
						else if(arr2[i][ct.y] == 6)
							break;
						else if(arr2[i][ct.y]== 0)
							arr2[i][ct.y]=-1; 
					}
					for(int i=ct.y-1;i>=0;i--) { // 좌
						if(i == -1)
							break;
						else if(arr2[ct.x][i] == 6)
							break;
						else if(arr2[ct.x][i] == 0)
							arr2[ct.x][i] = -1; //-1로 처리
					}
				}
				else if (ct.option == 4) {
					for(int i=ct.y-1;i>=0;i--) { // 좌
						if(i == -1)
							break;
						else if(arr2[ct.x][i] == 6)
							break;
						else if(arr2[ct.x][i] == 0)
							arr2[ct.x][i] = -1; //-1로 처리
					}
					for(int i=ct.x-1;i>=0;i--) { // 상
						if(i == -1)
							break;
						else if(arr2[i][ct.y] == 6)
							break;
						else if(arr2[i][ct.y] == 0)
							arr2[i][ct.y] = -1; //-1로 처리
					}
				}
			}
			else if (ct.num == 4) {
				if (ct.option == 1) {
					for(int i=ct.y-1;i>=0;i--) { // 좌
						if(i == -1)
							break;
						else if(arr2[ct.x][i] == 6)
							break;
						else if(arr2[ct.x][i] == 0)
							arr2[ct.x][i] = -1; //-1로 처리
					}
					for(int i=ct.x-1;i>=0;i--) { // 상
						if(i == -1)
							break;
						else if(arr2[i][ct.y] == 6)
							break;
						else if(arr2[i][ct.y] == 0)
							arr2[i][ct.y] = -1; //-1로 처리
					}
					for(int i=ct.y+1;i<M;i++) { // 우
						if(i == M)
							break;
						else if(arr2[ct.x][i] == 6)
							break;
						else if(arr2[ct.x][i] == 0)
							arr2[ct.x][i] = -1; //-1로 처리
					}
				}
				else if (ct.option == 2) {
					for(int i=ct.x-1;i>=0;i--) { // 상
						if(i == -1)
							break;
						else if(arr2[i][ct.y] == 6)
							break;
						else if(arr2[i][ct.y] == 0)
							arr2[i][ct.y] = -1; //-1로 처리
					}
					for(int i=ct.y+1;i<M;i++) { // 우
						if(i == M)
							break;
						else if(arr2[ct.x][i] == 6)
							break;
						else if(arr2[ct.x][i] == 0)
							arr2[ct.x][i] = -1; //-1로 처리
					}
					for(int i=ct.x+1;i<N;i++) { // 하
						if(i == N)
							break;
						else if(arr2[i][ct.y] == 6)
							break;
						else if(arr2[i][ct.y]== 0)
							arr2[i][ct.y]=-1; 
					}
				}
				else if (ct.option == 3) {
					for(int i=ct.y+1;i<M;i++) { // 우
						if(i == M)
							break;
						else if(arr2[ct.x][i] == 6)
							break;
						else if(arr2[ct.x][i] == 0)
							arr2[ct.x][i] = -1; //-1로 처리
					}
					for(int i=ct.x+1;i<N;i++) { // 하
						if(i == N)
							break;
						else if(arr2[i][ct.y] == 6)
							break;
						else if(arr2[i][ct.y]== 0)
							arr2[i][ct.y]=-1; 
					}
					for(int i=ct.y-1;i>=0;i--) { // 좌
						if(i == -1)
							break;
						else if(arr2[ct.x][i] == 6)
							break;
						else if(arr2[ct.x][i] == 0)
							arr2[ct.x][i] = -1; //-1로 처리
					}
				}
				else if (ct.option == 4) {
					for(int i=ct.x+1;i<N;i++) { // 하
						if(i == N)
							break;
						else if(arr2[i][ct.y] == 6)
							break;
						else if(arr2[i][ct.y]== 0)
							arr2[i][ct.y]=-1; 
					}
					for(int i=ct.y-1;i>=0;i--) { // 좌
						if(i == -1)
							break;
						else if(arr2[ct.x][i] == 6)
							break;
						else if(arr2[ct.x][i] == 0)
							arr2[ct.x][i] = -1; //-1로 처리
					}
					for(int i=ct.x-1;i>=0;i--) { // 상
						if(i == -1)
							break;
						else if(arr2[i][ct.y] == 6)
							break;
						else if(arr2[i][ct.y] == 0)
							arr2[i][ct.y] = -1; //-1로 처리
					}
				}
			}
			else if(ct.num == 5) {
				for(int i=ct.y+1;i<M;i++) { // 우
					if(i == M)
						break;
					else if(arr2[ct.x][i] == 6)
						break;
					else if(arr2[ct.x][i] == 0)
						arr2[ct.x][i] = -1; //-1로 처리
				}
				for(int i=ct.x+1;i<N;i++) { // 하
					if(i == N)
						break;
					else if(arr2[i][ct.y] == 6)
						break;
					else if(arr2[i][ct.y]== 0)
						arr2[i][ct.y]=-1; 
				}
				for(int i=ct.y-1;i>=0;i--) { // 좌
					if(i == -1)
						break;
					else if(arr2[ct.x][i] == 6)
						break;
					else if(arr2[ct.x][i] == 0)
						arr2[ct.x][i] = -1; //-1로 처리
				}
				for(int i=ct.x-1;i>=0;i--) { // 상
					if(i == -1)
						break;
					else if(arr2[i][ct.y] == 6)
						break;
					else if(arr2[i][ct.y] == 0)
						arr2[i][ct.y] = -1; //-1로 처리
				}
			}
		}
		int sum = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr2[i][j] == 0) {
					sum += 1;
				}
			}
		}
		min = Math.min(min, sum);
	}
}
