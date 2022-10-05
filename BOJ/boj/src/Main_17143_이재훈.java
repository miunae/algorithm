import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17143_이재훈 {
	static int R,C,M;
	static ArrayList<Shark> sharkList;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1};
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());//행
		C = Integer.parseInt(st.nextToken());//열
		M = Integer.parseInt(st.nextToken());//상어수
		answer = 0;
		sharkList = new ArrayList<>();
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken()); // 속도
			int d = Integer.parseInt(st.nextToken()); // 방향
			int z = Integer.parseInt(st.nextToken()); // 크기
			sharkList.add(new Shark(r,c,s,d,z));
		}
		int idx = 1;
		while(idx<=C) {
			fishing(idx);
			move();
			eat();
			idx += 1;
		}
		System.out.println(answer);
	}
	
	static class Shark{
		int r,c,s,d,size;

		public Shark(int r, int c, int s, int d, int size) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.size = size;
		}	
	}
	
	static void fishing(int idx) {
		int nearest = 0;
		int dist = Integer.MAX_VALUE;
		for(int i=0;i<sharkList.size();i++) {
			if(sharkList.get(i).c == idx) {
				if(sharkList.get(i).r < dist) {
					dist = sharkList.get(i).r;
					nearest = i;
				}
			}
		}
		if(dist == Integer.MAX_VALUE) 
			return;
		else {
			answer += sharkList.get(nearest).size;
			sharkList.remove(nearest);
		}
	}
	
	static void move() {
		for(int i=0;i<sharkList.size();i++) {
			int restr = (R-1)*2;
			int restc = (C-1)*2;
			int dist = 0;
			if(sharkList.get(i).d == 1 || sharkList.get(i).d ==2) {
				dist = sharkList.get(i).s % restr;
				int nx = sharkList.get(i).r;
				while(dist --> 0) {
					if(sharkList.get(i).d==1) {
						if(sharkList.get(i).r == 1) {
							sharkList.get(i).d = 2;
							sharkList.get(i).r += 1;
						}
					}else if(sharkList.get(i).d==2) {
						if(sharkList.get(i).r == R) {
							sharkList.get(i).d = 1;
							sharkList.get(i).r -= 1;
						}
					}
				}
			}else {
				dist = sharkList.get(i).s % restc;
				int ny = sharkList.get(i).c;
				while(dist --> 0) {
					if(sharkList.get(i).d==3) {
						if(sharkList.get(i).c==C) {
							sharkList.get(i).d=4;
							sharkList.get(i).c -= 1;
						}
					}else if(sharkList.get(i).d==4) {
						if(sharkList.get(i).c == 0) {
							sharkList.get(i).d=3;
							sharkList.get(i).c += 1;
						}
					}
				}
			}
		}
	}
	
	static void eat() {
		ArrayList<int[]> same = new ArrayList<>();
		int cnt = 0;
		for(int i=0;i<sharkList.size()-1;i++) {
			for(int j=1;j<sharkList.size();j++) {
				if(sharkList.get(i).r == sharkList.get(j).r && sharkList.get(i).c == sharkList.get(j).c) {
					same.add(new int[] {i,j});
					cnt += 1;
				}
			}
		}
		int[] delete = new int[cnt];
		for(int i=0;i<same.size();i++) {
			int n1 = same.get(i)[0];
			int n2 = same.get(i)[1];
			if(sharkList.get(n1).size > sharkList.get(n2).size)
				delete[i] = n2;
			else {
				delete[i] = n1;
			}
		}
		Arrays.sort(delete);
		for(int i = cnt-1;i>=0;i--) {
			sharkList.remove(delete[i]);
		}
	}
}
