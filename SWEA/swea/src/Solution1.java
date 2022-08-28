import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1 {
	static boolean[] gatevisited; // 게이트
	static int[] visited; // -1로 초기화
	static int[][] gates;
	static int min;
	static int N;
	static int[][] permList;
	static int totalNum;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		permList = new int[][] {{0,0,0},{0,0,1},{0,1,0},{1,0,0},{1,0,1},{1,1,0},{0,1,1},{1,1,1}};
//		for(int i=0;i<8;i++) {
//			System.out.println(Arrays.toString(permList[i]));
//		}
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = null;
			N = Integer.parseInt(br.readLine());
			int[] numbers = new int[3];
			totalNum = 0;
			gates = new int[3][2]; // gates[n][0] : 게이트, gates[n][1] : 인원 수
			gatevisited = new boolean[3]; // 먼저 입장할 게이트 순서를 위해
			visited = new int[N + 1]; // 낚시터
			min= Integer.MAX_VALUE;
			for (int i = 0; i < 3; i++) {
				st = new StringTokenizer(br.readLine());
				gates[i][0] = Integer.parseInt(st.nextToken());
				gates[i][1] = Integer.parseInt(st.nextToken());
				totalNum += gates[i][1];
			}
			int[] nums = new int[3];
			perm(0, nums);
			System.out.printf("#%d %d\n", t, min);
		}

	}

	static void perm(int depth, int[] nums) {
		if (depth == 3) {
			for (int[] plist : permList) {
				visited = new int[N + 1];
				Arrays.fill(visited, -1);
				for (int i = 0; i < 3; i++) {
					fill(nums[i], visited, plist[i]);
				}
				int totalCnt=0;
				for(int i=1;i<=N;i++) {
					if(visited[i] != -1) {
						totalCnt += 1;
					}
				}
//				System.out.println(Arrays.toString(visited));

				if(totalCnt != totalNum)
					continue;
				int dist = 0;
				for (int i = 1; i <= N; i++) {
					if(visited[i] == -1) continue;
					dist += Math.abs(visited[i]-i) + 1;
				}
				min = Math.min(min, dist);
			}
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
	static void fill(int gateIdx, int[] visited, int direction) { // visited를 갱신해주는 역할? dir: 0이면 왼쪽(마지막)
		int person = gates[gateIdx][1]; // 인원 수
		int gNum = gates[gateIdx][0]; // 게이트 번호
		int dCnt = 0;
		if (direction == 0) {
			while (person != 0) {
				if (dCnt == 0) { // 바로 위
					if (visited[gNum] == -1) {
						visited[gNum] = gNum;
						person -= 1;
					}
					if (person == 0)
						break;
				} else {
					int left = gNum - dCnt;
					int right = gNum + dCnt;
					if (left>=1 && visited[left] == -1) {
						visited[left] = gNum;
						person -= 1;
					}
					if (person == 0)
						break;
					if(right<=N && visited[right] == -1) {
						visited[right] = gNum;
						person -= 1;
					}
				}
				dCnt += 1;
			}
		} else if (direction == 1) {
			while (person-- > 0) {
				if (dCnt == 0) { // 바로 위
					if (visited[gNum] == -1) {
						visited[gNum] = gNum;
						person -= 1;
					}
					if (person == 0)
						break;
				} else {
					int left = gNum - dCnt;
					int right = gNum + dCnt;
					if(right<=N && visited[right] == -1) {
						visited[right] = gNum;
						person -= 1;
					}
					if (person == 0)
						break;
					if (left>=1 && visited[left] == -1) {
						visited[left] = gNum;
						person -= 1;
					}	
				}
				dCnt += 1;
			}
		}
	}


}
