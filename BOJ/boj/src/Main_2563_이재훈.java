import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2563_이재훈 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[][] paper = new int[101][101];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for(int row=x;row<x+10;row++) {
				for(int col=y;col<y+10;col++) {
					paper[row][col] = 1;
				}
			}
		}
		int sum = 0;
		for(int i=0;i<101;i++) {
			for(int j=0;j<101;j++) {
				if(paper[i][j] == 1)
					sum +=1;
			}
		}
		sb.append(sum);
		System.out.println(sb);
	}

}
