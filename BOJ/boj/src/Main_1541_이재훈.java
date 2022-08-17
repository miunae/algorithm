import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1541_이재훈 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String exp = br.readLine();
		int answer = 0;
		String[] str = exp.split("-");
		answer = Integer.parseInt(str[0]);
		for(int i=1;i<str.length;i++) {
			String[] tmp = str[i].split("\\+");
			int sum = 0;
			for(int j=0;j<tmp.length;j++) {
				sum += Integer.parseInt(tmp[j]);
			}
			answer -= sum;
		}
		System.out.println(answer);
	}

}
