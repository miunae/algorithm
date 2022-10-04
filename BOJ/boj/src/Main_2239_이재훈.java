import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_2239_이재훈 {
	static int[][] map;
	static ArrayList<int[]> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		list = new ArrayList<>();
		for(int i=0;i<9;i++) { // 입력
			char[] tmp = new char[9];
			tmp = br.readLine().toCharArray();
			for(int j=0;j<9;j++) {
				map[i][j] = tmp[j]-'0';
				if(map[i][j] == 0) {
					list.add(new int[] {i,j});
				}
			}
		}
		backtrack(0);
		
	}
	static void backtrack(int idx) {
		if(idx == list.size()) {
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			System.exit(0);
		}
		int x = list.get(idx)[0];
		int y = list.get(idx)[1];
		int[] row = new int[10]; // 행 확인
		int[] col = new int[10]; // 열 확인
		int[] nine = new int[10]; // 3x3확인
		for(int i=0;i<9;i++) {
			col[map[x][i]] += 1;
			row[map[i][y]] += 1;
		}
		int nx = (x/3)*3;
		int ny = (y/3)*3;
		for(int i=nx;i<nx+3;i++) {
			for(int j=ny;j<ny+3;j++) {
				nine[map[i][j]] += 1;
			}
		}
		for(int i=1;i<=9;i++) {
			if(row[i] == 0 && col[i] == 0 && nine[i] ==0) {
				map[x][y] = i;
				backtrack(idx+1);
				map[x][y] = 0;
			}
		}
	}
}
