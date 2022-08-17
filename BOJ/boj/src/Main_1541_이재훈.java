import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_1541_이재훈 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String exp = br.readLine();
		int answer = 0;
		String[] strs = exp.split("-");
		ArrayList<Integer> list = new ArrayList<>();
		for(String str : strs) {
			int sum = 0;
			String[] plus = str.split("\\+");
			for(String n : plus) {
				sum += Integer.parseInt(n);
			}
			list.add(sum);
		}
		for(int i=1;i<list.size();i++) {
			answer -= list.get(i);
		}
		answer += list.get(0);
		System.out.println(answer);
	}

}
