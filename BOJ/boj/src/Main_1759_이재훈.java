import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1759_이재훈 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[] chars = new char[C];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<C;i++)
			chars[i] = st.nextToken().charAt(0);
		char[] moeum = new char[] {'a','e','i','o','u'};
		Arrays.sort(chars);
		char[] tmps = new char[L];
		dfs(0,0,L,chars,tmps);
	}
	static void dfs(int cnt, int start, int L,char[] chars, char[] tmps) {
		if(cnt == L) {
			int moeumCnt = moCnt(tmps);
			if(moeumCnt<1 || L-moeumCnt<2)
				return;
			else {
				for(int i=0;i<L;i++) {
					System.out.print(tmps[i]);
				}
				System.out.println();
				return;
			}
		}
		for(int i=start;i<chars.length;i++) {
			tmps[cnt] = chars[i];
			dfs(cnt+1,i+1,L,chars,tmps);
		}
	}
	
	static int moCnt(char[] chars) {
		int cnt = 0;
		for(char c:chars) {
			if(c == 'a' || c=='e'||c=='i'||c=='o'||c=='u')
				cnt += 1;
		}
		return cnt;
	}
}
