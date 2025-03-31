package backjun.search;
class Solution {
    public String solution(String region, String[] playerNames, int maxGameCount) {
        String answer = "";
        return answer;
    }

    abstract class Game{
        public String solution(String[] playerNames, int maxGameCount) {
            StringBuilder answer = new StringBuilder();

            int curMemberIndex = 0;
            for(int i = 1 ; i<=maxGameCount;i++){
                String curMember = playerNames[curMemberIndex];
                answer.append(curMember + ": ");
                String str = do369(i);
                answer.append(str).append("\n");
                curMemberIndex++;
                curMemberIndex = curMemberIndex%playerNames.length;
            }
            return answer.toString();
        }
        public abstract String do369(int number);
    }
}
