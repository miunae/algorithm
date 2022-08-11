import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2493_이재훈 {
	static class Tower{
		int index;
		int height;
		Tower(int index, int height){
			this.index = index;
			this.height = height;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Tower> stack = new Stack<>();
		int height, index;
		for(int i=1;i<=N;i++) {
			height = Integer.parseInt(st.nextToken());
			while(!stack.isEmpty()) {
				if(stack.peek().height > height) {
					System.out.print(stack.peek().index+" ");
					break;
				}
				stack.pop();
			}
			if(stack.isEmpty())
				System.out.print(0+" ");
			stack.push(new Tower(i,height));
		}
		
		
	}

}
