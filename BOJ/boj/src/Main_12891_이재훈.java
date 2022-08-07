import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_12891_이재훈{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken()); // 문자열 주어진 길이
		int P = Integer.parseInt(st.nextToken()); // 만들어야 할 문자열 길이
		char[] arr = br.readLine().toCharArray(); // 주어진 문자열 길이
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		// 슬라이딩 윈도우
		int cnt = 0; // 몇 개인지 기록
		char[] pw = Arrays.copyOfRange(arr, 0, P); // 초기 pw를 점진적으로 확인
		int idx = 0;
		int aCnt = 0;
		int cCnt = 0;
		int gCnt = 0;
		int tCnt = 0;
		for(int i=0;i<P;i++) {
			if(pw[i] == 'A') aCnt += 1;
			if(pw[i] == 'C') cCnt += 1;
			if(pw[i] == 'G') gCnt += 1;
			if(pw[i] == 'T') tCnt += 1;
		}
		while(true) {
			//System.out.println(idx);
			
			if(aCnt >= A && cCnt >= C && gCnt >= G && tCnt >= T) {
				cnt += 1;
			}
			if(idx==S-P) {
				break;
			}
			
			if(pw[idx%P] == 'A') aCnt--;
			if(pw[idx%P] == 'C') cCnt--;
			if(pw[idx%P] == 'G') gCnt--;
			if(pw[idx%P] == 'T') tCnt--;
			pw[idx%P] = arr[idx+P];
			if(pw[idx%P] == 'A') aCnt += 1;
			if(pw[idx%P] == 'C') cCnt += 1;
			if(pw[idx%P] == 'G') gCnt += 1;
			if(pw[idx%P] == 'T') tCnt += 1;
			idx++;
		}
		System.out.println(cnt);
	}

}
