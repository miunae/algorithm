import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1043 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[] able = new boolean[M]; // 파티의 가능 여부
		ArrayList<Integer> know = new ArrayList<>(); // 아는 사람 리스트
		Arrays.fill(able, true); // 일단 전부 가능한 파티로
		ArrayList<Integer>[] parties = new ArrayList[M];
		for(int i=0;i<M;i++) {
			parties[i] = new ArrayList<Integer>();
		}
		st = new StringTokenizer(br.readLine());
		int knum = Integer.parseInt(st.nextToken()); // 초기 아는 사람 수
		for(int i=0;i<knum;i++) {
			know.add(Integer.parseInt(st.nextToken())); // 초기 아는 사람들 세팅
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int pnum = Integer.parseInt(st.nextToken()); // 참석 인원 수
			for(int j=0;j<pnum;j++) {
				parties[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		// 진실을 아는 사람들의 수만큼 파티의 가능여부 체크 및 새로운 진실을 알게 될 사람 추가
		for(int i=0;i<know.size();i++) {
			for(int p=0;p<M;p++) {
				if(parties[p].contains(know.get(i))) {
					able[p] = false;
					for(int j=0;j<parties[p].size();j++) {
						if(!know.contains(parties[p].get(j))) {
							know.add(parties[p].get(j));
						}
					}
				}
			}
		}
		int answer = 0;
		for(int i=0;i<M;i++) {
			if(able[i])
				answer+=1;
		}
		System.out.println(answer);
	}

}
