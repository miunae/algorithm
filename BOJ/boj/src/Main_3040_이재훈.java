import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_3040_이재훈 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[9];
		for(int i=0;i<9;i++)
			arr[i] = Integer.parseInt(br.readLine());
		boolean[] visited = new boolean[9];
		subset(0,0,arr,visited,0);
	}
	static void subset(int cnt,int sum, int[] numbers, boolean[] visited,int getCnt) {
		if(sum == 100 && getCnt == 7) {
			for(int i=0;i<9;i++) {
				if(visited[i])
					System.out.println(numbers[i]);
			}
			return;
		}
		
		if(cnt == 9) {
			return;
		}
		
		visited[cnt] = true;
		subset(cnt+1,sum+numbers[cnt],numbers,visited,getCnt+1);
		visited[cnt] = false;
		subset(cnt+1,sum,numbers,visited,getCnt);
	}
}
