package programers;

import java.util.*;
class 타겟넘버 {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(0,numbers,target,0);

        return answer;
    }
    public void dfs(int i ,int[] numbers,int target,int sum){
        if(i>=numbers.length){
            if(sum == target){
                answer++;
            }
            return;
        }
        System.out.println(i);
        dfs(i+1,numbers,target,numbers[i]+sum);
        dfs(i+1,numbers,target,-numbers[i]+sum);
    }
}
