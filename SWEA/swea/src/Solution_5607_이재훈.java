

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5607_이재훈 {
	static int mod = 1234567891;
	static long[] factorial = new long[1000001];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		factorial[0] = 1;
        for(int i=1; i<=1000000; i++){
            factorial[i] = factorial[i-1] * i % mod;
        }
		StringTokenizer st = null;
		for(int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			long c1 = factorial[N];
			long c2 = (factorial[N-R]*factorial[R])%mod;
			long c3 = pow(c2,mod-2);
			System.out.printf("#%d %d\n",t,c1*c3%mod);
		}
	}
	static long pow(long n, long r) { 
		if(r==1) {
			return n;
		}
		long x = pow(n,r/2)%mod;
		if(r%2==0) { //짝수면
			return x*x%mod;
		}else {
			return ((x*x)%mod*n)%mod;
		}
	}
}
