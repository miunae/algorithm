import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main_2164_이재훈 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> deq = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		for(int i=N;i>=1;i--) {
			deq.add(i);
			
		}
		while(true) {
			if(deq.size()==1) {
				sb.append(deq.peek()).append('\n');
				break;
			}
			deq.removeLast();
			if(deq.size() == 1) {
				sb.append(deq.removeLast()).append('\n');
				break;
			}
			deq.addFirst(deq.peekLast());
			deq.removeLast();
		}
		System.out.println(sb);
	}

}
