package programers;

import java.util.*;


public class 네트워크 {
    class Solution {
        public int solution(int n, int[][] computers) {
            int answer = 0;
            boolean [][] chk = new boolean[n][n];
            for(int i = 0 ;i<n;i++){
                for(int j = i; j<n;j++){
                    if(!chk[i][j]&&computers[i][j]==1){
                        chk[i][j] = true;
                        chk[j][i] = true;
                    }
                }
            }
            String str [] = new String[5];
            Queue<Integer> queue = new LinkedList<>();
            for(int i = 0 ;i<n;i++){
                for(int j = 0; j<n;j++){
                    if(chk[i][j]){
                        queue.offer(j);
                        while(!queue.isEmpty()){
                            int poll = queue.poll();
                            for(int h=0;h<computers[poll].length;h++){
                                if(chk[poll][h]){
                                    chk[poll][h] = false;
                                    chk[h][poll] = false;
                                    queue.offer(h);
                                }
                            }
                        }
                        answer++;
                    }
                }
            }
            return answer;
        }
    }
}
