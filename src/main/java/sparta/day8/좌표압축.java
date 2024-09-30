package sparta.day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//5
//2 4 -10 4 -9
// 숫자를 압축하여 등수대로 출력하면 된다.
// 등수대로 출력하는 부분에서 정렬을 하면 될 것같다.
// 하지만 인덱스는 유지해야한다. 즉 인덱스를 따로 관리해야 할 것 같다.
// 또한 동일한 숫자의 경우 같은 값을 출력해야 하며 2->4로 넘어가는 식이 아니다.

// 로직 : 값과 인덱스를 저장하고 값을 기준으로 정렬한다.
// 그렇게 오름차순으로 정렬했을 때 다시 for 문을 통해 랭크를 매긴다.
// 이 때 이전 값과 같은 값일 경우 rank 는 오르지 않는다. (같은 값은 같은 등수이기 때문)
// 이 값을 rankArr[인덱스] 에 넣는다.
public class 좌표압축 {

        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int arr[][] = new int[n][];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = new int[]{Integer.parseInt(st.nextToken()),i};
        }
        Arrays.sort(arr); // 인덱스를 제외한 값 만으로 정렬을 하기 위해

        int rank = -1;
        int temp[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            if( i==0 || arr[i][0] != arr[i-1][0]){
                rank++;
            }
            temp[arr[i][1]] = rank;

        }
        for (int i = 0; i < temp.length; i++) {
            sb.append(temp[i]).append(" ");
        }
        System.out.println(sb);

    }
//    public static void main(String[] args) throws IOException {
//        // 원본 배열과 복사 배열을 만든 후
//        // 값에 해당하는 랭크를 MAP 에 저장하기
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        int n = Integer.parseInt(br.readLine());
//        int arr[] = new int[n];
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < n; i++) {
//            arr[i] = Integer.parseInt(st.nextToken());
//        }
//        int sortArr[] =  Arrays.stream(arr).distinct().sorted().toArray();
//
//        int rank = 0;
//        Map map = new HashMap();
//        for (int i = 0; i < sortArr.length; i++) {
//            if (!map.containsKey(sortArr[i])){
//                map.put(sortArr[i],rank);
//                rank++;
//            }
//        }
//
//        for (int i = 0; i < arr.length; i++) {
//            sb.append(map.get(arr[i])).append(" ");
//        }
//        System.out.println(sb);
//    }


}
