import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2023_이재훈 {
	static int N;
	static boolean f;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dfs("",0);
		System.out.println(sb);
	}
	
	public static void dfs(String s,int n) {
		if(n == N) {
			sb.append(s+"\n");
			return;
		}
		if(n == 0) {
			for(int i=1;i<=9;i++) {
				if(isPrime(Integer.parseInt(s+i)))
					dfs(s+i,n+1);
			}
		}else {
			for(int i=1;i<=9;i+=2) {
				if(isPrime(Integer.parseInt(s+i)))
					dfs(s+i,n+1);
			}
		}
		
	}
	
	public static boolean isPrime(int num) {
		if(num <= 1) return false;
		for(int i=2;i<=(int)Math.sqrt(num);i++) {
			if(num%i==0) {
				return false;
			}
		}
		return true;
	}
}
