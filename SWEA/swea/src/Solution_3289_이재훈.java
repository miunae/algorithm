import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3289_이재훈 {
	static int parents[];
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sb.append("#" + t).append(" ");
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			make();
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int cmd = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if (cmd == 0) {
					union(a, b);
				} else if (cmd == 1) {
					if (find(a) == find(b)) {
						sb.append("1");
					} else
						sb.append("0");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void make() {
		parents = new int[N+1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}

	static int find(int a) {
		if (parents[a] == a)
			return a;
		else {
			return parents[a] = find(parents[a]);
		}
	}

	static void union(int a, int b) {
		int aParent = find(a);
		int bParent = find(b);
		if (aParent == bParent)
			return;
		else {
			parents[bParent] = aParent;
		}
	}
}
