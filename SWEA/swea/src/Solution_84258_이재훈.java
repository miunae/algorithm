import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_84258_이재훈 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			int N = Integer.parseInt(br.readLine());
			int max = 0;
			int[] sum = new int[N];
			int answer = 0;
			StringTokenizer st = null;
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				sum[i] = Math.abs(x)+Math.abs(y);
				max = Math.max(max, sum[i]);
			}
			boolean finish = false;
			if(max%2==0) {
				for(int i=0;i<N;i++) {
					if(sum[i] %2 != 0) {
						answer = -1;
						finish = true;
					}
				}
			}else if(max%2 !=0) {
				for(int i=0;i<N;i++) {
					if(sum[i]%2==0) {
						answer = -1;
						finish = true;
					}
				}
			}
			if(!finish) {
				int cnt = 0;
				for(int i=0;i<N;i++) {
					if(max == sum[i])
						cnt += 1;
				}
				answer = max/cnt;
			}
			System.out.printf("#%d %d\n",t,answer);
		}
	}

}
