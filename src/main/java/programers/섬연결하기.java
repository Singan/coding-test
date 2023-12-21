package programers;

public class 섬연결하기 {
    //크루스칼 알고리즘
    public static void main(String[] args) {

    }
    public static int solution(int n, int[][] costs) {
        int answer = 0;
        int[] landCost = new int[n];
        for(int i = 0;i<n;i++){
            int land1 = costs[i][0];
            int land2 = costs[i][1];
            int cost = costs[i][2];
            if( landCost[land1] ==0 ||cost<landCost[land1]){
                landCost[land1] = cost;
            }
            if( landCost[land2] ==0 ||cost<landCost[land2]){
                landCost[land2] = cost;
            }
        }
        for(int i = 0 ; i<n;i++){
            answer+=landCost[i];
        }
        return answer;
    }
}
