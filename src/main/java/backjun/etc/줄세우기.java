package backjun.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 줄세우기 {
    //자기 앞에 자기보다 키가 큰 학생이 없다면 그냥 그 자리에 서고 차례가 끝난다.
    //자기 앞에 자기보다 키가 큰 학생이 한 명 이상 있다면 그중 가장 앞에 있는 학생(A)의 바로 앞에 선다.
    // 이때, A부터 그 뒤의 모든 학생들은 공간을 만들기 위해 한 발씩 뒤로 물러서게 된다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int s = Integer.parseInt(br.readLine());
        System.out.println(s);
        int[] arr = new int[s];
        for (int i = 0; i < s; i++) {
            String str[] = br.readLine().split(" ");
            List<Integer> peopleList = new ArrayList();
            peopleList.add(Integer.parseInt(str[1]));
            int count = 0;
            for (int j = 2; j < str.length; j++) {
                int cur = Integer.parseInt(str[j]);
                int pSize = peopleList.size();
                for (int k = 0; k < pSize; k++) {
                    if(cur < peopleList.get(k)){
                        count += pSize-k;
                        peopleList.add(k, cur);
                        break;
                    }
                    if(k+1>=pSize){
                        peopleList.add(cur);
                    }
                }
            }
            arr[i] = count;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + 1 + " " + arr[i]);
        }
    }
}
