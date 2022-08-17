import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1074_이재훈 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int answer = 0;
		while(N != 0) {
			N -= 1;
			// 1사분면
			if(r < Math.pow(2,N) && c < Math.pow(2, N))
				answer += 0;
			// 2사분면
			else if(r < Math.pow(2, N) && c >= Math.pow(2, N)) {
				answer += Math.pow(2,N)*Math.pow(2,N)*1;
			// 한개 사분면 만큼 answer에 추가해주고 c 값을 사분면 하나가 되도록 빼준다.
				c -= Math.pow(2, N);
			}
			// 3사분면
			else if(r >= Math.pow(2, N) && c < Math.pow(2, N)) {
				answer += Math.pow(2,N)*Math.pow(2,N)*2;
				r -= Math.pow(2, N);
			}
			// 4사분면
			else if(r >= Math.pow(2, N) && c >= Math.pow(2,N)) {
				answer += Math.pow(2,N)*Math.pow(2,N)*3;
				r -= Math.pow(2, N);
				c -= Math.pow(2, N);
			}
		}
		System.out.println(answer);
	}

}
