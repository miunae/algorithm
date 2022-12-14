import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9465 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[2][N+1];
			int[][] memory = new int[2][N+1];
			for(int i=0;i<2;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=1;j<=N;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			memory[0][1] = arr[0][1];
			memory[1][1] = arr[1][1];
			for(int i=2;i<=N;i++) {
				memory[0][i] = Math.max(memory[1][i-1], memory[1][i-2])+arr[0][i];
				memory[1][i] = Math.max(memory[0][i-1], memory[0][i-2])+arr[1][i];
			}
			System.out.println(Math.max(memory[0][N], memory[1][N]));
		}
	}
}
