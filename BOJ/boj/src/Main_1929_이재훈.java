import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1929_이재훈 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[] isNotPrime = new boolean[M+1];
		isNotPrime[0] = isNotPrime[1] = true;
		for(int i=2;i*i<=M;i++) {
			if(isNotPrime[i]) {
				continue;
			}
			for(int j=i+i;j<=M;j+=i) {
				isNotPrime[j] = true;
			}
		}
		for(int i=N;i<=M;i++) {
			if(!isNotPrime[i]) {
				sb.append(i).append("\n");
			}
		}
		System.out.println(sb);
	}

}
