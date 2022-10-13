import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_2115_이재훈 {
	static int N,M,C, max1, max2;
	static int[][] map;
	static ArrayList<Honey> honeyList; // 모든 경우의 벌꿀 M개로 뽑은 경우
	static int answer;
	static int[] num1,num2;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //벌통 크기
			M = Integer.parseInt(st.nextToken()); //선택할 수 있는 벌통 개수
			C = Integer.parseInt(st.nextToken()); //꿀을 채취할 수 있는 최대 양
			map = new int[N][N];
			honeyList = new ArrayList<>();
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			max1 = max2 = 0;
			num1 = new int[M];
			num2 = new int[M];
			allCase();
			answer = 0;
			comb(0,0,new Honey[2]);
			System.out.printf("#%d %d\n",t,answer);
		}
	}
	
	static class Honey {
		int x,sy,ey;
		Honey(int x,int sy,int ey){
			this.x=x;
			this.sy = sy;
			this.ey = ey;
		}
	}
	
	static void allCase() { // 모든 벌꿀 경우(M개) ---- completed
		for(int i=0;i<N;i++) {
			for(int j=0;j<=N-M;j++) {
				honeyList.add(new Honey(i,j,j+M-1));
			}
		}
	}
	
	static void comb(int cnt, int start, Honey[] honeys) {
		if(cnt == 2) {
			if(honeys[0].x == honeys[1].x && honeys[0].ey >= honeys[1].sy) {
				return;
			}
			else { // 제곱이 최대 일 경우 값 확인해본다.(조합을 한 번 더??)
				max1 = max2 = 0;
				for(int i=0;i<M;i++) {
					num1[i] = map[honeys[0].x][honeys[0].sy+i];
					num2[i] = map[honeys[1].x][honeys[1].sy+i];
				}
				boolean[] visited = new boolean[M];
				dfs(0,visited,num1);
				max2 = max1;
				max1 = 0;
				visited = new boolean[M];
				dfs(0,visited,num2);
				max2 += max1;
				answer = Math.max(max2, answer);
				return;
			}
		}
		for(int i=start;i<honeyList.size();i++) {
			honeys[cnt] = honeyList.get(i);
			comb(cnt+1,i+1,honeys);
		}
	}
	
	static void dfs(int cnt, boolean[] visited, int[] honeys) { //C에 맞게
		if(cnt == M) {
			// C보다 합이 작을 때
			int sum = 0;
			int sumSquare = 0;
			for(int i=0;i<M;i++) {
				if(visited[i]) {
					sum += honeys[i];
					sumSquare += honeys[i] * honeys[i];
				}
			}
			if(sum <= C) {
				max1 = Math.max(max1, sumSquare);
			}
			return;
		}
		visited[cnt] = true;
		dfs(cnt+1,visited,honeys);
		//미선택
		visited[cnt] = false;
		dfs(cnt+1,visited,honeys);
	}
}
