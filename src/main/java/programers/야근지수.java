package programers;
import java.util.*;

public class 야근지수 {
// words sum 을 구하고 -n 했을 때
// /length 을 한다 그러 평균값
    class Solution {
        public long solution(int n, int[] works) {
            PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
            for(int i = 0 ; i<works.length;i++){
                q.offer(works[i]);
            }
            for( int i = 0 ; i < n; i++){
                int work = q.poll();
                if ( work == 0 ) return 0; //가장 많이 남은 일이 0 //남은 일이 없다

                q.add( work - 1 );
            }


            long answer = 0;
            for(int work : q) {
                answer += work * work;
            }
            return answer;
        }
    }
}
