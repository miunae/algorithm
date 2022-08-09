import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_6808_이재훈 {
	static int totalCnt;
	static int[] in;
	static int[][] perms;
	static int[] tmp;
	static boolean[] isSelected;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			int[] gyu = new int[9];
			in = new int[9];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<9;i++) {
				gyu[i] = Integer.parseInt(st.nextToken());
			}
			int inCnt = 0;
			for(int i=1;i<=18;i++) {
				boolean exist = false;
				for(int j=0;j<9;j++) {
					if(i == gyu[j])
						exist = true;
				}if(exist == false) {
					in[inCnt] = i;
					inCnt++;
				}
			}
			int iter = 1;
			for(int i=1;i<=9;i++) {
				iter *= i;
			}
			int win = 0;
			int lose = 0;
			perms = new int[iter][9];
			totalCnt = 0;
			isSelected = new boolean[9];
			tmp = new int[9];
			// permutation 구현
			permutation(0);
			for(int i=0;i<totalCnt;i++) {
				int gCnt = 0; // 규영점수
				int iCnt = 0; // 인영점수
				for(int j=0;j<0;j++) {
					if(gyu[j]>perms[i][j])
						gCnt += (gyu[j]+perms[i][j]);
					else
						iCnt += (gyu[j]+perms[i][j]);
				}
				if(gCnt>iCnt)
					win++;
				else if(gCnt<iCnt)
					lose++;
			}
//			System.out.println(totalCnt);
			System.out.println(Arrays.toString(perms[3]));
			System.out.printf("#%d %d %d\n",t,win,lose);
		}
	}
	 static void permutation(int n) {
		 if(n == 9) {
			 totalCnt++;
			 
			 return;
		 }
		 
		 for(int i=0;i<9;i++) {
			 if(isSelected[i])continue;
			 perms[totalCnt][n] = in[i];
			 isSelected[i] = true;
			 permutation(n+1);
			 isSelected[i] = false;
		 }
	 }
}
