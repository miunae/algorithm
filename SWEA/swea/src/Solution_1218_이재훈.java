import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class Solution_1218_이재훈 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=10;t++) {
			int N = Integer.parseInt(br.readLine()); // 입력 문자열 길이
			char[] chars = br.readLine().toCharArray(); // 문자 배열
			Stack<Character> stack = new Stack<>();
			// 스택에 삽입
			for(int i=0;i<N;i++) {
				// 여는 괄호거나 비어있으면 무조건 push
				if(stack.isEmpty() || chars[i]=='(' || chars[i]=='[' || chars[i]=='{' || chars[i] == '<') {
					stack.push(chars[i]);
				}
				if(!stack.isEmpty()) {
					if(stack.peek() == '(' ) {
						if(chars[i] == ')') {
							stack.pop();
							continue;
						}
						if(chars[i] == ']' || chars[i] == '>' || chars[i] =='}')
							break;
					}
					if(stack.peek() == '[' ) {
						if(chars[i] == ']') {
							stack.pop();
							continue;
						}
						if(chars[i] == ')' || chars[i] == '>' || chars[i] =='}')
							break;
					}
					if(stack.peek() == '{' ) {
						if(chars[i] == '}') {
							stack.pop();
							continue;
						}
						if(chars[i] == ']' || chars[i] == '>' || chars[i] ==')')
							break;
					}
					if(stack.peek() == '<' ) {
						if(chars[i] == '>') {
							stack.pop();
							continue;
						}
						if(chars[i] == ']' || chars[i] == ')' || chars[i] =='}')
							break;
					}
				}
			}
			int answer;
			if(stack.isEmpty()) {
				answer = 1;
			}
			else {
				answer = 0;
			}
			sb.append("#"+t+" ").append(answer).append('\n');
			//System.out.println(Arrays.toString(stack.toArray()));
		}
		System.out.println(sb);
	}

}
