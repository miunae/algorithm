import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2493_이재훈 {
	static class Tower{
		int index;
		int height;
		Tower(int index, int height){
			this.index = index;
			this.height = height;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Tower> queue = new LinkedList<>();
		ArrayList<Integer> answer = new ArrayList<>();
		for(int i=1;i<=N;i++) {
			Tower top = new Tower(i,Integer.parseInt(st.nextToken()));
			queue.add(top);
		}
		Tower maxTower = new Tower(0,0);
		Tower curMaxTower = new Tower(0,0);
		while(!queue.isEmpty()) {
			Tower tmp = queue.poll();
			if(maxTower.height < tmp.height) {
				maxTower.index = tmp.index;
				maxTower.height = tmp.height;
				curMaxTower.index = tmp.index;
				curMaxTower.height = tmp.height;
				answer.add(0);
			}
			if(tmp.height < curMaxTower.height) {
				answer.add(curMaxTower.index);
			}
			if(tmp.height > curMaxTower.height) {
				answer.add(maxTower.index);
				curMaxTower.index = tmp.index;
				curMaxTower.height = tmp.height;
			}
			if(queue.size() != 0 && tmp.height>queue.peek().height) {
				curMaxTower.index = tmp.index;
				curMaxTower.height = tmp.height;
			}
		}
		for(int i=0;i<N;i++) {
			System.out.print(answer.get(i)+" ");
		}
		
		
	}

}
