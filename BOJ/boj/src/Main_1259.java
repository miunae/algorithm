import java.util.Scanner;

public class Main_1259 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			char[] str = sc.nextLine().toCharArray();
			if(str[0] == '0')
				break;
			boolean yes = true;
			for(int i=0;i<str.length/2;i++) {			
				if(str[i] != str[str.length-1-i]) {
					yes = false;
					break;
				}
			}
			if(yes) {
				System.out.println("yes");
			}else {
				System.out.println("no");
			}
		}
		
	}
}
