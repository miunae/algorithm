import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16929_이재훈 {
	
	public static void rotate(int[][] arr) {
		int r = arr.length;
		int c = arr[0].length;
		int ltop = arr[0][0]; // 각 꼭지점 기록
		int llow = arr[r-1][0];
		int rtop = arr[0][c-1];
		int rlow = arr[r-1][c-1];
		for(int i=0;i<c-1;i++)
			arr[0][i] = arr[0][i+1]; // 맨윗줄 왼쪽으로 
		for(int i=r-1;i>0;i--)
			arr[i][0] = arr[i-1][0];
		arr[1][0] = ltop;
		for(int i=c-1;i>0;i--)
			arr[r-1][i] = arr[r-1][i-1];
		arr[r-1][1] = llow;
		for(int i=0;i<r-1;i++)
			arr[i][c-1] = arr[i+1][c-1];
		arr[r-2][c-1] = rlow;
//		if(r == 2 || c == 2)
//			return;
//		int[][] inarr = new int[r-2][c-2];
//		for(int i=1;i<arr.length-1;i++) {
//			for(int j=1;j<arr[0].length-1;j++) {
//				inarr[i-1][j-1] = arr[i][j];
//			}
//		}
//		rotate(inarr);
//		for(int i=1;i<arr.length-1;i++) {
//			for(int j=1;j<arr[0].length-1;j++) {
//				arr[i][j] = inarr[i-1][j-1];
//			}
//		}
		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<Math.min(M, N)/2;i++) {
			int[][] inarr = new int[arr.length-2*i][arr[0].length-2*i];
			for(int ini=1*i;ini<arr.length-1*i;ini++) {
				for(int inj=1*i;inj<arr[0].length-1*i;inj++) {
					inarr[ini-1*i][inj-1*i] = arr[ini][inj];
				}
			}
			int iter = R%(inarr.length*2+inarr[0].length*2-4);
			while(iter --> 0)
				rotate(inarr);
			for(int ini=1*i;ini<arr.length-1*i;ini++) {
				for(int inj=1*i;inj<arr[0].length-1*i;inj++) {
					arr[ini][inj] = inarr[ini-1*i][inj-1*i];
				}
			}
			
		}
//		R = R%(2*N+2*M-4);
//		while(R --> 0) {
//			rotate(arr);
//			
//		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				sb.append(arr[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
