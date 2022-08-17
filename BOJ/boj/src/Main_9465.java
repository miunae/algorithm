import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
<<<<<<< HEAD
import java.util.StringTokenizer;
=======
>>>>>>> 137bb96024fb02be2e34bcf2dacc101a4a3d9138

public class Main_9465 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[2][N];
<<<<<<< HEAD
			// 스티커판 생성
			for(int i=0;i<2;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int sum = 0; //뗀 스티커 합
			// N이짝수일때
			if(N%2 ==0) {
				int firstSum = 0;
				int secondSum = 0;
				int sum1 = 0,sum2 = 0;
				// 첫번째 행 먼저
				for(int i=0;i<N;i++) {
					sum1 += arr[0][i];
					if(i%2==0) firstSum += arr[0][i];
				}
				// 두번째행
				for(int i=0;i<N;i++) {
					sum2 += arr[1][i];
					if(i%2 == 0) secondSum += arr[0][i];
				}
				sum = Math.max(firstSum+(sum2-secondSum), secondSum+(sum1-firstSum));
			}
			if(N== 1) {
				sum = Math.max(arr[0][0], arr[1][0]);
			}
			else if(N%2==1) {
				int firstSum =0;
				int secondSum = 0;
				int sum1=0,sum2=0;
				for(int i=0;i<N-2;i++) {
					sum1 += arr[0][i];
					if(i%2 == 0) firstSum += arr[0][i];
					sum2 += arr[1][i];
					if(i%2==0)secondSum += arr[1][i];
				}
				int max1 = Math.max(arr[0][N-1]+arr[1][N-2], arr[1][N-1]);
				int max2 = Math.max(arr[0][N-2]+arr[1][N-1], arr[0][N-1]);
				sum = Math.max(firstSum+(sum2-secondSum)+max1, secondSum+(sum1-firstSum)+max2);
			}
			System.out.println(sum);
=======
>>>>>>> 137bb96024fb02be2e34bcf2dacc101a4a3d9138
		}
	}

}
