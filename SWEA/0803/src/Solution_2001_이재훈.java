import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2001_이재훈 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N][N];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int total = 0;
			for(int i=0;i<=N-M;i++) {
				for(int j=0;j<=N-M;j++) {
					int sum = 0;
					for(int a=0;a<M;a++) {
						for(int b=0;b<M;b++) {
							sum += arr[i+a][j+b];
						}
					}
					total = Math.max(total, sum);
				}
			}
			System.out.printf("#%d %d\n",t,total);
		}
		
	}

}
