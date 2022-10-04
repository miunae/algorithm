package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1_이재훈 {
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.println(fib(8));
	}

	static int fib(int n) {
		int[] memory = new int[n+1];
		memory[0] = 1;
		memory[1] = 2;
		for(int i=2;i<=n;i++) {
			memory[i] = memory[i-1]+memory[i-2];
		}
		return memory[n];
	}
	
}
