import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15961_이재훈 {
	static int N,D,K,C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 접시 수
		D = Integer.parseInt(st.nextToken()); // 초밥 가지 수
		K = Integer.parseInt(st.nextToken()); // 연속해서 먹는 수
		C = Integer.parseInt(st.nextToken()); // 쿠폰 번호
		int[] sushi = new int[N]; // 초밥리스트
		int[] eaten = new int[D+1];
		for(int i=0;i<N;i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		int cnt = 0;
		int max = 0;
		for(int i=0;i<K;i++) {
			if(eaten[sushi[i]]==0) {
				cnt +=1;
			}
			eaten[sushi[i]]+=1;
		}
		max = cnt;
		for(int i=1;i<N;i++) {
			if(max <= cnt) {
				if(eaten[C]==0) {
					max = cnt+1;
				}else {
					max = cnt;
				}
			}
			eaten[sushi[i-1]] -= 1;
			if(eaten[sushi[i-1]]==0) {
				cnt-=1;
			}
			if(eaten[sushi[(i+K-1)%N]]==0) {
				cnt+=1;
			}
			eaten[sushi[(i+K-1)%N]]+=1;
		}
		System.out.println(max);
	}

}
