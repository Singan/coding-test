package programers;

import java.util.LinkedList;
import java.util.Queue;

public class Test {
    //직사각형을 만드는 데 필요한 4개의 점 중 3개의 좌표가 주어질 때 나머지 한개의 좌표
    public static void main(String[] args) {
        int [][] v = new int[][]{{1,4},{3,4},{1,10}};
        int[] answer = new int[2];

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if(queue.isEmpty()){
                    queue.add(v[j][i]);
                }else{
                    if(queue.peek()==v[j][i]){
                        queue.peek();
                    }else{
                        queue.add(v[j][i]);
                    }
                }
            }
            answer[i] = queue.poll();
        }
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }

    }

}
