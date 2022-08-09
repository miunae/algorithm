import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1233_이재훈 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=10;t++) {
			int N = Integer.parseInt(br.readLine());
			int layer = N;
			int level = 0;
			while(layer != 1) {
				layer /= 2;
				level +=1;
			}
			
			List<ArrayList<String>> tree = new ArrayList<>();
			tree.add(null);
			for(int i=1;i<=N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String num = st.nextToken();
				ArrayList<String> node = new ArrayList<>();
				while(st.hasMoreTokens()) {
					node.add(st.nextToken());
				}
				tree.add(node);
			}
			if(N%2 ==0) {
				sb.append("#"+t).append(" "+0).append("\n");
				continue;
			}
			int idx = 1;
			for(int i=0;i<level;i++) {
				idx *= 2;
			}
			int answer = 1; 
			while(level --> 0) {
				if(answer == 0)
					break;
				for(int i=idx;i<idx*2;i+=2) {
					if(i > N) {
						break;
					}
					// 리프노드에 연산자가 있으면 
					if(tree.get(i).get(0).equals("*") || tree.get(i).get(0).equals("+") || tree.get(i).get(0).equals("-") || tree.get(i).get(0).equals("/")) {
						answer = 0;
						break;
					}
					if(tree.get(i+1).get(0).equals("*") || tree.get(i+1).get(0).equals("+") || tree.get(i+1).get(0).equals("-") || tree.get(i+1).get(0).equals("/")) {
						answer = 0;
						break;
					}
					// 부모중에 연산자이면 1로 바꿔준다. 아니면 유효 x
					if(tree.get(i/2).get(0).equals("*") || tree.get(i/2).get(0).equals("+") || tree.get(i/2).get(0).equals("-") || tree.get(i/2).get(0).equals("/")) {
						tree.get(i/2).set(0, "1");
					}else {
						answer = 0;
						break;
					}
				}
				idx /= 2;
			}
			sb.append("#"+t+" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
}
