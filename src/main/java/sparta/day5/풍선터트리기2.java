package sparta.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

//https://www.acmicpc.net/problem/2346
public class 풍선터트리기2 {
    // 8번 요세푸스 문제와 동일하게 풀 수 있다고 생각했다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        LinkedList<int[]> list = new LinkedList<>();
        String[] s = br.readLine().split(" ");


        for (int i = 1; i <= n; i++) {
            list.add(new int[]{i, Integer.parseInt(s[i - 1])}); // 값과 이동 위치를 넣는다.
        }
        StringBuffer sb = new StringBuffer();
        int index = 1; // 리스트 0번에서 시작
        while (list.size() > 1) {
            System.out.println(index);


            int[] cur = list.remove(index); // 현재 인덱스의 배열을 꺼내 값과 다음 위치를 확인한다.
            if( cur[1]>0)
                cur[1]-=1;

            index = index + cur[1]; // 현재 위치에 다음 위치를 더한다.


            sb.append(cur[0]).append(" ");
            if(index<0){
                index+=list.size();
            }else if(index>=list.size()){
                index-=list.size();
            }
        }
        sb.append(list.remove()[0]);
        System.out.println(sb);
    }
}
