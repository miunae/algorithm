import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1 {
	static boolean[] gatevisited; // 게이트
	static int[] visited; // -1로 초기화
	static int[][] gates;
	static int[] dir = { -1, 1 }; // 양방향 탐색
	static int min = Integer.MAX_VALUE;
	static int N, sum = 0;
	static int[][] permList;
	static int permCnt = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = null;
			N = Integer.parseInt(br.readLine());
			int[] numbers = new int[3];
			gates = new int[3][2]; // gates[n][0] : 게이트, gates[n][1] : 인원 수
			gatevisited = new boolean[3]; // 먼저 입장할 게이트 순서를 위해
			visited = new int[N + 1]; // 낚시터
			for (int i = 0; i < 3; i++) {
				st = new StringTokenizer(br.readLine());
				gates[i][0] = Integer.parseInt(st.nextToken());
				gates[i][1] = Integer.parseInt(st.nextToken());
			}
			permList = new int[8][3];
		}

	}

	static void perm(int depth, int[] nums) {
		if (depth == 3) {
			visited = new int[N + 1];
			Arrays.fill(visited, -1);
			int[] pList = new int[3];
			dfs2(0,pList);
			
			
			return;
		}
		for (int i = 0; i < 3; i++) {
			if (gatevisited[i])
				continue;
			gatevisited[i] = true;
			nums[depth] = i;
			perm(depth + 1, nums);
			gatevisited[i] = false;
		}
	}

	// visited에는 gate의 index가 들어간다
	static void bfs(int gateIdx, int[] visited, int direction) { // visited를 갱신해주는 역할? dir: 0이면 왼쪽(마지막)
		int person = gates[gateIdx][1]; // 인원 수
		Queue<Integer> q = new ArrayDeque<>();
		int gNum = gates[gateIdx][0]; // 게이트 번호
		q.offer(gNum);
		if (direction == 0) {
			while (person > 0) {
				int cur = q.poll();
				if (visited[cur] == -1)
					person -= 1;
				if (person == 0)
					break;
				for (int d = 0; d < 2; d++) {
					int dIdx = cur + dir[d];
					q.offer(dIdx);
					if (dIdx >= 1 && dIdx <= N && visited[dIdx] == -1) {
						visited[dIdx] = gNum;
						person -= 1;
					}
					if (person == 0)
						break;
				}
			}
		}
		else if (direction == 1) {
			while (person > 0) {
				int cur = q.poll();
				if (visited[cur] == -1)
					person -= 1;
				if (person == 0)
					break;
				for (int d = 1; d>=0; d--) {
					int dIdx = cur + dir[d];
					q.offer(dIdx);
					if (dIdx >= 1 && dIdx <= N && visited[dIdx] == -1) {
						visited[dIdx] = gNum;
						person -= 1;
					}
					if (person == 0)
						break;
				}
			}
		}
	}
	static void dfs2(int cnt, int[] pList) {
		if(cnt == 3) {
			permList[permCnt++] = pList;
			return;
		}
		for(int i=0;i<2;i++) {
			pList[cnt] = i;
			dfs2(cnt+1,pList);
		}
	}
}
