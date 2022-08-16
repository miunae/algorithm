import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_1828_이재훈 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] degree = new int[N][2];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			degree[i][0] = Integer.parseInt(st.nextToken());
			degree[i][1] = Integer.parseInt(st.nextToken());
		}
		// 최저 온도 기준 정렬
		Arrays.sort(degree,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return (o1[1] != o2[1]) ? o1[1]-o2[1] : o1[0] - o2[0]; 
			}
		});
		int answer = 1;
		int premax = degree[0][1];
		if(N == 1)
			System.out.println(answer);
		else {
			for(int i=1;i<N;i++) {
				if(degree[i][0] <= premax)
					continue;
				else {
					premax = degree[i][1];
					answer +=1;
				}
			}
			System.out.println(answer);
		}
	}

}
