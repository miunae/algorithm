import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1228_이재훈 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=10;t++) {
			int N = Integer.parseInt(br.readLine());
			List<Integer> que = new ArrayList<Integer>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				que.add(Integer.parseInt(st.nextToken()));
			}
			int cmd = Integer.parseInt(br.readLine()); // 명령어의 개수
			st = new StringTokenizer(br.readLine());
			
			for(int j=0;j<cmd;j++) {
				char c = st.nextToken().charAt(0);
				int idx = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				for(int i=0;i<num;i++) {
					que.add(idx+i,Integer.parseInt(st.nextToken()));
				}
			}
			
			sb.append("#"+t).append(" ");
			for(int i=0;i<10;i++) {
				sb.append(que.get(i)).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
