import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1463_이재훈 {
	static int[] memory;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int num = 1;
		memory = new int[N + 1];
		memory[0] = 1;
		memory[1] = 1;
		System.out.println(update(N)-1);
	}

	static int update(int n) {
		if (memory[n] == 0) {
			if (n % 6 == 0) {
				memory[n] = Math.min(update(n - 1), Math.min(update(n / 3), update(n / 2))) + 1;
			} else if (n % 3 == 0) {
				memory[n] = Math.min(update(n / 3), update(n - 1)) + 1;
			} else if (n % 2 == 0) {
				memory[n] = Math.min(update(n/2), update(n-1))+1;
			}
			else {
				memory[n] = update(n-1)+1;
			}
		}
		return memory[n];
	}
}
