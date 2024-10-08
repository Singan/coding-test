package sparta.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

//https://www.acmicpc.net/problem/2346
public class 풍선터트리기 {
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
        int index = 0; // 리스트 0번에서 시작
        while (list.size() > 1) {
            System.out.println(index);


            int[] cur = list.remove(index); // 현재 인덱스의 배열을 꺼내 값과 다음 위치를 확인한다.
            int move = cur[1]; // 이동할 값 가져오기

            // 리스트가 하나 줄었으므로 크기를 조정해서 인덱스 계산
            if (move > 0) {
                index = (index + (move - 1)) % list.size(); // 오른쪽 이동
            } else {
                index = (index + move) % list.size(); // 왼쪽 이동
                if (index < 0) {
                    index += list.size(); // 음수일 경우 인덱스 보정
                }
            }


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
