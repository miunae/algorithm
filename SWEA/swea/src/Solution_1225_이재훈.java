import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution_1225_이재훈 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=10;t++) {
			int N = Integer.parseInt(br.readLine());
			Deque<Integer> deq = new ArrayDeque<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<8;i++) {
				deq.add(Integer.parseInt(st.nextToken()));
			}
			boolean finish = false;
			while(finish == false) {
				for(int i=1;i<=5;i++) {
					int tmp = deq.removeFirst();
					tmp -= i;
					if(tmp<=0) {
						deq.addLast(0);
						finish = true;
						break;
					}else {
						deq.addLast(tmp);
					}
				}
			}
			sb.append("#"+t).append(" ");
			while(!deq.isEmpty()) {
				sb.append(deq.removeFirst()).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
