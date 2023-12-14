package programers;
import java.util.*;
class Solution {

    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        int[] targetCost = new int[words.length];
        Queue<String> queue = new LinkedList();
        queue.offer(begin);
        while(!queue.isEmpty()){
            for(String word : words){
                String poll = queue.poll();
                int check = 0;
                for(int i = 0;i<poll.length();i++){
                    if(poll.charAt(i)==word.charAt(i)){
                        check++;
                    }
                }
                if(poll.length()==check-1){
                    queue.offer(word);
                }
            }
        }
        return answer;
    }
}
