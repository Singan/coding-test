package programers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 이중우선순위큐 {

    public static void main(String[] args) {

    }

    public static int[] solution(String[] operations) {
        int[] answer = new int[2];
        List<Integer> answerList = new ArrayList<>();
        int minIndex = 0;
        int maxIndex = 0;
        for (int i = 0; i < operations.length; i++) {
            String[] s = operations[i].split(" ");
            String op = s[0];
            int number = Integer.parseInt(s[1]);
            if (op.equals("I")) {
                answerList.add(number);
            } else if (op.equals("D")) {
                if (answerList.size() > 0) {
                    int delete = 0;
                    if (number == -1) {
                        delete = Collections.min(answerList);
                    } else {
                        delete = Collections.max(answerList);
                    }
                    answerList.remove(answerList.indexOf(delete));
                }
            }
        }
        if (answerList.size() != 0) {
            answer[1] = Collections.min(answerList);
            answer[0] = Collections.max(answerList);
        }
        return answer;
    }
}
