package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2_이재훈  {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] memory = new int[N+1];
		memory[1] = 2;
		memory[2] = 5;
		for (int i = 3; i <= N; i++) {
			memory[i] = memory[i-1]*2 + memory[i-2];
		}
		System.out.println(memory[N]);
	}
}
