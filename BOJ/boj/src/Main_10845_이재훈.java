import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_10845_이재훈 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N  = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<>();
		int last = 0;
		while(N --> 0) {
			String str = br.readLine();
			String[] strs = str.split(" ");
			if(strs.length == 2) {
				last = Integer.parseInt(strs[1]);
				queue.offer(Integer.parseInt(strs[1]));
			}else {
				if(str.equals("pop")) {
					if(queue.isEmpty())
						System.out.println(-1);
					else {
						System.out.println(queue.poll());
					}
				}
				if(str.equals("size"))
					System.out.println(queue.size());
				if(str.equals("empty")) {
					if(queue.isEmpty())
						System.out.println(1);
					else System.out.println(0);
				}
				if(str.equals("front")) {
					if(queue.isEmpty()) System.out.println(-1);
					else System.out.println(queue.peek());
				}
				if(str.equals("back")) {
					if(queue.isEmpty()) System.out.println(-1);
					else System.out.println(last);
				}
			}
		}
	}

}
