import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1992_이재훈 {
	static int N;
	static int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		char[][] cArray = new char[N][N];
		for(int i=0;i<N;i++) {
			 cArray[i] = br.readLine().toCharArray();
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				arr[i][j] = cArray[i][j]-'0';
			}
		}
		recursion(arr);
	}
	static void recursion(int[][] arr) {
		int n = arr.length;
		if(n == 1) {
			System.out.print(arr[0][0]);
			return;
		}
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				sum += arr[i][j];
			}
		}
		if(sum == n*n)
			System.out.print(1);
		else if(sum == 0)
			System.out.print(0);
		else {
			System.out.print('(');
			int[][] arr1 = new int[n/2][n/2];
			int[][] arr2 = new int[n/2][n/2];
			int[][] arr3 = new int[n/2][n/2];
			int[][] arr4 = new int[n/2][n/2];
			for(int i=0;i<n/2;i++) {
				for(int j=0;j<n/2;j++) {
					arr1[i][j] = arr[i][j];
					arr2[i][j] = arr[i][j+n/2];
					arr3[i][j] = arr[i+n/2][j];
					arr4[i][j] = arr[i+n/2][j+n/2];
				}
			}
			recursion(arr1);
			recursion(arr2);
			recursion(arr3);
			recursion(arr4);
			System.out.print(')');
		}
	}
}
