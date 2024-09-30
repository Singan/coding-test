package sparta.day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 중위순회는 트리에서 항상 가운데 값이 부모 노드라는 것을 알아냈다.
// 예
// 3
// 1 6 4 3 5 2 7
// 정중앙인 3이 루트 노드이고 1 6 4 의 중앙인 6이 또 상위 노드이다. 이를 반복하면 될 것같다.
// 재귀를 통해 전체 문자열의 중앙으로 반을 나누고
// 또 나머지 문자열의 좌 우 로 재귀를 반복한다.
// 노드의 개수는 층의 제곱 -1 이다.
// 2층이라면 총 3개
// 3층이라면 7개
// 각 층별로 표현할 문자열이 필요하며 이를 층으로 구분하기에 배열이 필요할 것 같다. String 또는 StringBuilder 등이 필요할 것
public class 완전이진트리 {


    static StringBuilder[] sb;
    static String[] str;
    static int n;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        str = br.readLine().split(" ");
        sb = new StringBuilder[n];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder();
        }


        dfs(0, str.length-1 , 0);

        for (int i = 0; i < sb.length; i++) {
            System.out.println(sb[i].toString());
        }
    }
    static void dfs(int start , int end , int depth ){

        if(n == depth)
            return;

        int mid = (start + end) / 2;


        sb[depth].append(str[mid] + " ");
        dfs(start,mid-1 , depth+1 ); // 왼쪽

        dfs( mid+1,end ,depth+1 ); // 오른쪽

    }
}
