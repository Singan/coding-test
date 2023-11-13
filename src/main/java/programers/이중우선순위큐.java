package programers;

public class 이중우선순위큐 {

    public static void main(String[] args) {

    }
    public static int[] solution(String[] operations) {
        int[] answer = new int[operations.length];
        int minIndex = 0;
        int maxIndex = 0;
        for (int i = 0; i < operations.length; i++) {
            String[] s = operations[i].split(" ");
            String op = s[0];
            int number = Integer.parseInt(s[1]);
            if(op.equals("I")){
                minIndex = number<answer[minIndex]? i:minIndex;
                maxIndex = number>answer[maxIndex]? i:maxIndex;
            }else if(op.equals("D")){
                
            }
        }

        return answer;
    }
}
