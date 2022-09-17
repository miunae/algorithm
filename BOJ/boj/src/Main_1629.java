import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1629 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long C = Long.parseLong(st.nextToken());
		long result = 0;
		result = dfs(A,B,C);
		System.out.println(result);
	}
	static long dfs(long x,long n,long y) {
		if(n==1)
			return x%y;
		else if(n%2 == 0) {
			long tmp = dfs(x,n/2,y);
			return tmp*tmp%y;
		}else {
			long tmp = dfs(x,n/2,y);
			return ((x*tmp)%y*tmp)%y;
		}
	}
}
