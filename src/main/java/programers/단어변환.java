package programers;
import java.util.*;

public class 단어변환 {
    class Solution {
        public int solution(String begin, String target, String[] words) {
            int answer = 0;
            int[] targetCost = new int[words.length];
            boolean[] chk = new boolean[words.length];
            Queue<Integer> queue = new LinkedList();
            for ( int i = 0; i < words.length; i++ ) {
                if (targetCost[i] == 0 && bfs(begin, words[i]) ) {
                    queue.offer(i);
                    targetCost[i] = 1;
                    chk[i] = true;
                }
            }
            while(!queue.isEmpty()){
                int poll = queue.poll();
                for(int i = 0 ; i <words.length;i++){
                    boolean check = false;
                    String word = words[i];
                    for(int j = 0;j < words[poll].length(); j++){
                        check = bfs(words[poll],words[i]);
                    }
                    if(check && ! chk[i]){
                        queue.offer(i);
                        targetCost[i] = targetCost[poll]+1;
                        chk[i] = true;
                    }
                }
            }
            for(int i = 0 ; i <words.length;i++){
                int check = 0;
                String word = words[i];
                if(word.equals(target)){
                    answer = targetCost[i];
                }
            }

            return answer;
        }
        public boolean bfs(String begin, String words){
            int chk = 0;
            for(int j = 0;j < begin.length(); j++){
                if(begin.charAt(j)==words.charAt(j)){
                    chk++;
                }
            }
            return chk == begin.length()-1;
        }
    }
}
