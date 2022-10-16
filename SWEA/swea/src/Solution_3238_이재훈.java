import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3238_이재훈 {    
	
	public static int iT=0;
	public static long n,r;
	public static int p;
	public static long[] nCr;
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		iT=Integer.parseInt(br.readLine().trim());
		nCr=new long[p+1];

		for (int T = 1; T <= iT; T++) {
			st=new StringTokenizer(br.readLine().trim());
			n=Long.parseLong(st.nextToken().trim());
			r=Long.parseLong(st.nextToken().trim());
			p=Integer.parseInt(st.nextToken().trim());
			System.out.printf("#%d %d\n",T,nCr(n,r,p));
		}
	}
	static long power(long x, long y, long p)  { 
		long res = 1L; 
        x = x % p; 
        while (y > 0) {    
            if (y % 2 == 1) 
                res = (res * x) % p; 
            y = y >> 1;  
            x = (x * x) % p; 
        } 
        return res; 
    } 
    static long modInverse(long n, long p) { 
        return power(n, p-2, p); 
    } 

    static long nCr(long n, long r, int p) { 
    	 if (r == 0|| r==n) 
             return 1L;
         else if(r==1 || r==n-1) {
         	return n%p;
         }
        long[] fac=new long[p+1];
        fac[0]=1;
		for (int i = 1; i < fac.length; i++) {
			fac[i]=i*fac[i-1]%p;
		}
        if(n<p) {
        	return (fac[(int)n]* modInverse(fac[(int)r], p) 
                    % p * modInverse(fac[(int)(n-r)], p) 
                                        % p) % p; 
        }else {
        	long ret=1;
            while(n>0 || r>0){
                long a=n%p;
                long b=r%p;
                if(a<b) ret=0;
                if(ret==0) break;
                ret*=fac[(int)a];
                ret%=p;
                ret*=modInverse((fac[(int)b]*fac[(int)a-(int)b])%p, p);
                ret%=p;
                n/=p;
                r/=p;
            }
            return ret;
        }
        
    } 
}