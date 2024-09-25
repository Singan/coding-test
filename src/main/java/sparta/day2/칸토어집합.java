package sparta.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/4779
public class 칸토어집합 {
    //칸토어 집합은 0과 1사이의 실수로 이루어진 집합으로, 구간 [0, 1]에서 시작해서 각 구간을 3등분하여 가운데 구간을 반복적으로 제외하는 방식으로 만든다.
    //
    //전체 집합이 유한이라고 가정하고, 다음과 같은 과정을 통해서 칸토어 집합의 근사를 만들어보자.
    //
    //1. -가 3N개 있는 문자열에서 시작한다.
    //
    //2. 문자열을 3등분 한 뒤, 가운데 문자열을 공백으로 바꾼다. 이렇게 하면, 선(문자열) 2개가 남는다.
    //
    //3. 이제 각 선(문자열)을 3등분 하고, 가운데 문자열을 공백으로 바꾼다. 이 과정은 모든 선의 길이가 1일때 까지 계속 한다.
    //
    //예를 들어, N=3인 경우, 길이가 27인 문자열로 시작한다.

    // 선을 분할해서 계산하면 될것같다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        while ((str = br.readLine()) != null) {
            int N = Integer.parseInt(str); //입력 값 N => 3의 N승

            System.out.println(칸토어(N));;
        }
    }


    public static String 칸토어(int N){
        if(N == 0) // N 이 0이면 length 가 1이기때문에 - 는 하나만 나온다 그러니 바로 리턴 결국 표시되는 선은 한개다.
            return "-";

        int length = (int) Math.pow(3, N); // N 이 3이라 가정했을 때 27


        StringBuilder sb;
        length = length/3; // N이 3일 때 9 (분할된 공백의 크기)
        sb = new StringBuilder();

        sb.append(칸토어(N-1));
        sb.append(" ".repeat(length));
        sb.append(칸토어(N-1));

        return sb.toString();
    }
}
