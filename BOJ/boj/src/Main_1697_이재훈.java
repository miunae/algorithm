import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_1697_이재훈 {
	static int N,K, max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		Deque<Integer> deque = new ArrayDeque<>();
		deque.addLast(N);
		max = (int) Math.pow(10, 5);
		int[] memory = new int[max+1];
		bfs(deque,memory);
	}
	
	static void bfs(Deque<Integer> deque,int[] memory) {
		while(!deque.isEmpty()) {
			int tmp = deque.removeFirst();
			if(tmp == K) {
				System.out.println(memory[tmp]);
				break;
			}
			if(tmp*2<=max &&  tmp != 0 && memory[tmp*2] == 0) {
				memory[tmp*2] = memory[tmp]+1;
				deque.addLast(tmp*2);
			}
			if(tmp+1<=max && memory[tmp+1] == 0) {
				memory[tmp+1] = memory[tmp]+1;
				deque.addLast(tmp+1);
			}if(tmp-1<=max && tmp-1 >= 0 &&  memory[tmp-1] == 0) {
				memory[tmp-1] = memory[tmp]+1;
				deque.addLast(tmp-1);
			}
			
		}
	}
	
//	static void dfs(int depth, int n, int k) {
//		if (depth > min)
//			return;
//		if (n == k) {
//			min = Math.min(depth, min);
//			return;
//		}
//		
//		if(n<=k/2) {
//			dfs(depth + 1, n * 2, k);
//			dfs(depth+1,n+1,k);
//			dfs(depth+1,n-1,k);
//		}
//		if(n>k)
//			dfs(depth+1,n-1,k);
//		if(n<k) {
//			dfs(depth + 1, n + 1, k);
//			dfs(depth+1,n*2,k);
//		}
//
//	}

}
