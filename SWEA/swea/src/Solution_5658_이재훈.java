import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution_5658_이재훈 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken()); //k번째
			int n = N/4; // 한쪽 면의 수
			char[] arr = new char[N]; // 0회전
			arr = br.readLine().toCharArray();
			HashSet<String> sets = new HashSet<>();
			for(int i=0;i<n;i++) {
				for(int j=0;j<N;j+=n) {
					String tmp = "";
					char[] chars = Arrays.copyOfRange(arr, j, j+n);
					for(int k=0;k<chars.length;k++)
						tmp += chars[k];
					sets.add(tmp);
				}
				arr = rotate(arr);
			}
			ArrayList<String> al = new ArrayList<>(sets);
			ArrayList<Integer> res = new ArrayList<>();
			for(int i=0;i<al.size();i++) {
				res.add(toDecimal(al.get(i)));
			}
			Collections.sort(res);
			System.out.printf("#%d %d\n",t,res.get(res.size()-K));
		}
	}
	
	static char[] rotate(char[] arr1) {
		char[] arr2 = new char[arr1.length];
		char first = arr1[arr1.length-1]; //마지막 원소
		arr2 = Arrays.copyOfRange(arr1, 0, arr1.length-1);
		char[] result = new char[arr1.length];
		result[0] = first;
		for(int i=1;i<arr1.length;i++) {
			result[i] = arr2[i-1];
		}
		return result;
	}
	
	static int toDecimal(String hex) {
		return Integer.parseInt(hex,16);
	}
}
