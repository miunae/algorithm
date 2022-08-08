import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_9229_이재훈 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			List<Integer> list = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp<M)
					list.add(tmp);	
			}
			Collections.sort(list);
			int max = -1;
			for(int i=0;i<list.size()-1;i++) {
				for(int j=i+1;j<list.size();j++) {
					if(list.get(i)+list.get(j)>M) {
						break;
					}
					if(list.get(i)+list.get(j)>max)
						max = list.get(i)+list.get(j);
				}
			}
			sb.append("#"+t).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}

}
