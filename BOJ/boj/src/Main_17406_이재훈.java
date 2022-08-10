import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17406_이재훈 {
	static int totalCnt;
	public static void rotate(int[][] arr) {
		int r = arr.length;
		int c = arr[0].length;
		int ltop = arr[0][0]; // 각 꼭지점 기록
		int llow = arr[r-1][0];
		int rtop = arr[0][c-1];
		int rlow = arr[r-1][c-1];
		for(int i=c-1;i>0;i--)
			arr[0][i] = arr[0][i-1]; // 맨윗줄 오른쪽으로 
		for(int i=r-1;i>0;i--)
			arr[i][c-1] = arr[i-1][c-1]; // 오른쪽줄 아래로
		arr[1][c-1] = rtop;
		for(int i=0;i<c-1;i++)
			arr[r-1][i] = arr[r-1][i+1]; // 아래쪽줄 왼쪽으로
		arr[r-1][c-2] = rlow;
		for(int i=0;i<r-1;i++)
			arr[i][0] = arr[i+1][0]; // 왼쪽을 위로
		arr[r-2][0] = llow;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 명령어 순열 짜기
		int[][] cmds = new int[K][3];
		int[] numbers = new int[K]; // 명령어 순열을 돌리기 위한 인덱스 배열
		for(int i=0;i<K;i++) {
			numbers[i] = i;
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				cmds[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int permCnt = 1;
		for(int i=1;i<=K;i++)
			permCnt *= i;
		int[][] perm = new int[permCnt][K]; // 인덱스의 순열
		totalCnt = 0;
		boolean[] isSelected = new boolean[K];
		permutation(0, K,numbers,isSelected,perm);
		// 순열대로 돌리고 최소값 기록
		int min = Integer.MAX_VALUE;
		int tmp[][] = new int[arr.length][arr[0].length];
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				tmp[i][j] = arr[i][j];
			}
		}
		for(int iter=0;iter<totalCnt;iter++) {
			for(int i=0;i<arr.length;i++) {
				for(int j=0;j<arr[0].length;j++) {
					arr[i][j] = tmp[i][j];
				}
			}
			for(int k=0;k<K;k++) {
				int[] cmd = cmds[perm[iter][k]];
				int r = cmd[0];
				int c = cmd[1];
				int s = cmd[2];
				int sx = r-s-1; // startx, starty, endx, endy 
				int sy = c-s-1;
				int ex = r+s-1;
				int ey = c+s-1;
				int[][] arr2 = new int[ex-sx+1][ey-sy+1];
				// 부분 추출
				for(int i=0;i<arr2.length;i++) {
					for(int j=0;j<arr2[0].length;j++) {
						arr2[i][j] = arr[sx+i][sy+j];
					}
				}
				// rotate 
				for(int i=0;i<Math.min(ex-sx+1, ey-sy+1)/2;i++) {
					int[][] inarr = new int[arr2.length-2*i][arr2[0].length-2*i];
					for(int ini=1*i;ini<arr2.length-1*i;ini++) {
						for(int inj=1*i;inj<arr2[0].length-1*i;inj++) {
							inarr[ini-1*i][inj-1*i] = arr2[ini][inj];
						}
					}
					rotate(inarr);
					for(int ini=1*i;ini<arr2.length-1*i;ini++) {
						for(int inj=1*i;inj<arr2[0].length-1*i;inj++) {
							arr2[ini][inj] = inarr[ini-1*i][inj-1*i];
						}
					}
				}
				for(int i=0;i<arr2.length;i++) {
					for(int j=0;j<arr2[0].length;j++) {
						arr[sx+i][sy+j] = arr2[i][j]; 
					}
				}
			}
			for(int i=0;i<arr.length;i++) {
				int rowSum = 0;
				for(int j=0;j<arr[0].length;j++) {
					rowSum +=  arr[i][j];
				}
				if(rowSum<min) min = rowSum;
			}
		}
		sb.append(min);
		System.out.println(sb);
	}
	private static void permutation(int cnt, int N, int[] numbers, boolean[] isSelected, int[][] output) {
		if(cnt == N) {
			for(int i=0;i<N;i++)
				output[totalCnt][i] = numbers[i];
			totalCnt++; // 마지막에 한 번 더 더해진다?
			cnt = 0;
			return;
		}
		for(int i=0;i<N;i++) {
			if(isSelected[i]) continue;
			numbers[cnt] = i;
			isSelected[i] = true;
			permutation(cnt+1,N,numbers,isSelected,output);
			isSelected[i] = false;
		}
	}
}
