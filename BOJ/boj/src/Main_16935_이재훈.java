import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16935_이재훈 {
	
	static void rotate1(int[][] arr) {
		int r = arr.length;
		int c = arr[0].length;
		for(int i=0;i<r/2;i++) {
			for(int j=0;j<c;j++) {
				int temp  = arr[i][j];
				arr[i][j] = arr[r-1-i][j];
				arr[r-1-i][j] = temp;
			}
		}
	}
	
	static void rotate2(int[][] arr) {
		int r = arr.length;
		int c = arr[0].length;
		for(int i=0;i<r;i++) {
			for(int j=0;j<c/2;j++) {
				int temp  = arr[i][j];
				arr[i][j] = arr[i][c-1-j];
				arr[i][c-1-j] = temp;
			}
		}
	}
	
	static int[][] rotate3(int[][] arr) { // 시계방향
		int r = arr.length;
		int c = arr[0].length;
		int[][] arr2 = new int[c][r];
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				arr2[j][r-1-i] = arr[i][j];
			}
		}
		return arr2;
	}
	
	static int[][] rotate4(int[][] arr) { // 시계방향
		int r = arr.length;
		int c = arr[0].length;
		int[][] arr2 = new int[c][r];
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				arr2[c-1-j][i] = arr[i][j];
			}
		}
		return arr2;
	}
	
	static int[][] rotate5(int[][] arr){
		int r=arr.length/2;
		int c = arr[0].length/2;
		int[][] arr2 = new int[arr.length][arr[0].length];
		//1사분면
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				arr2[i][j] = arr[r+i][j];
			}
		}//2사분면
		for(int i=0;i<r;i++) {
			for(int j=c;j<arr[0].length;j++) {
				arr2[i][j] = arr[i][j-c];
			}
		}//4사분면
		for(int i=r;i<arr.length;i++) {
			for(int j=c;j<arr[0].length;j++) {
				arr2[i][j] = arr[i-r][j];
			}
		}//3사분면
		for(int i=r;i<arr.length;i++) {
			for(int j=0;j<c;j++) {
				arr2[i][j] = arr[i][c+j];
			}
		}
		return arr2;
	}
	
	static int[][] rotate6(int[][] arr){
		int r=arr.length/2;
		int c = arr[0].length/2;
		int[][] arr2 = new int[arr.length][arr[0].length];
		//1사분면
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				arr2[i][j] = arr[i][j+c];
			}
		}//2사분면
		for(int i=0;i<r;i++) {
			for(int j=c;j<arr[0].length;j++) {
				arr2[i][j] = arr[i+r][j];
			}
		}//4사분면
		for(int i=r;i<arr.length;i++) {
			for(int j=c;j<arr[0].length;j++) {
				arr2[i][j] = arr[i][j-c];
			}
		}//3사분면
		for(int i=r;i<arr.length;i++) {
			for(int j=0;j<c;j++) {
				arr2[i][j] = arr[i-r][j];
			}
		}
		return arr2;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] cmds = new int[R];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<R;i++)
			cmds[i] = Integer.parseInt(st.nextToken());
		for(int cmd : cmds) {
			if(cmd == 1) {
				rotate1(arr);
			}
			if(cmd == 2) {
				rotate2(arr);				
			}
			if(cmd == 3) {
				arr = rotate3(arr);
			}
			if(cmd == 4) {
				arr = rotate4(arr);
			}
			if(cmd == 5) {
				arr = rotate5(arr);
			}
			if(cmd ==6) {
				arr = rotate6(arr);
			}
		}
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				sb.append(arr[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
