import java.util.LinkedList;
import java.util.Queue;

class Solution2 {
    public static int solution(int[] queue1, int[] queue2) {
        Queue<Long> q1 = new LinkedList<>();
        Queue<Long> q2 = new LinkedList<>();
        Long sum = 0L;
        Long sum1 = 0L;
        Long sum2 = 0L;
        for(int i=0;i<queue1.length;i++){
            sum1 += (long)queue1[i];
            q1.add((long) queue1[i]);
            q2.add((long)queue2[i]);
            sum2 += (long)queue2[i];
        }
        sum = sum1+sum2;
        if(sum%2!=0)
            return -1;
        long check = sum/2;
        int cnt = 0;
        while(cnt<=2*queue1.length+1){
            if(sum1 == check)
                return cnt;
            if(sum1 > check){
                sum1 -= q1.peek();
                sum2 += q1.peek();
                q2.add(q1.poll());
                cnt += 1;
            }
            else if(sum2 > check){
                sum2 -= q2.peek();
                sum1 += q2.peek();
                q1.add(q2.poll());
                cnt += 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] que1 = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 10 };
        int[] que2 = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
        System.out.println(solution(que1,que2));
    }
}