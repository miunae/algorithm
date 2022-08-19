import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1247_이재훈 {
	static int[] work = new int[2];
	static int[] home = new int[2]; 
	static int min,N,distance;
	static int[] nums;
	static boolean[] visited;
	static List<Customer> customers;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			N = Integer.parseInt(br.readLine());
			visited = new boolean[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			work[0] = Integer.parseInt(st.nextToken());
			work[1] = Integer.parseInt(st.nextToken());
			home[0] = Integer.parseInt(st.nextToken());
			home[1] = Integer.parseInt(st.nextToken());
			customers = new ArrayList<>();
			nums = new int[N];
			distance = 0;
			min = Integer.MAX_VALUE;
			for(int i=0;i<N;i++) {
				customers.add(new Customer(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
			}
//			System.out.println(Arrays.toString(customers.toArray()));
			dfs(0,work[0],work[1],0);
			System.out.println("#"+t+" "+min);
			
		}
	}
	static class Customer{
		int x,y;
		Customer(int x,int y){
			this.x=x;
			this.y=y;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return this.x+" "+this.y;
		}
	}
	
	static void dfs(int depth,int x, int y, int dis) {
		
		if(dis > min)
			return;
		if(depth == N) {
			int hdist= Math.abs(home[0]-x)+Math.abs(home[1]-y);
			dis += hdist;
			min = Math.min(dis, min);
			
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(visited[i]) continue;
			int nx = customers.get(i).x;
			int ny = customers.get(i).y;
			nums[depth] = i;
			visited[i] = true;
			int ndist= Math.abs(x-nx)+Math.abs(y-ny);
			dfs(depth+1,nx,ny,dis+ndist);
			visited[i] = false;
		}
		
	}
}
