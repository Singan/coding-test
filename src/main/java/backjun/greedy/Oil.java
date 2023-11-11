package backjun.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Oil {
    //어떤 나라에 N개의 도시가 있다. 이 도시들은 일직선 도로 위에 있다. 편의상 일직선을 수평 방향으로 두자.
    // 제일 왼쪽의 도시에서 제일 오른쪽의 도시로 자동차를 이용하여 이동하려고 한다. 인접한 두 도시 사이의 도로들은 서로 길이가 다를 수 있다.
    // 도로 길이의 단위는 km를 사용한다.
    //
    //처음 출발할 때 자동차에는 기름이 없어서 주유소에서 기름을 넣고 출발하여야 한다. 기름통의 크기는 무제한이어서 얼마든지 많은 기름을 넣을 수 있다.
    // 도로를 이용하여 이동할 때 1km마다 1리터의 기름을 사용한다. 각 도시에는 단 하나의 주유소가 있으며, 도시 마다 주유소의 리터당 가격은 다를 수 있다.
    // 가격의 단위는 원을 사용한다.
    //
    //예를 들어, 이 나라에 다음 그림처럼 4개의 도시가 있다고 하자. 원 안에 있는 숫자는 그 도시에 있는 주유소의 리터당 가격이다.
    // 도로 위에 있는 숫자는 도로의 길이를 표시한 것이다.
    //제일 왼쪽 도시에서 6리터의 기름을 넣고, 더 이상의 주유 없이 제일 오른쪽 도시까지 이동하면 총 비용은 30원이다.
    // 만약 제일 왼쪽 도시에서 2리터의 기름을 넣고(2×5 = 10원) 다음 번 도시까지 이동한 후 3리터의 기름을 넣고(3×2 = 6원)
    // 다음 도시에서 1리터의 기름을 넣어(1×4 = 4원) 제일 오른쪽 도시로 이동하면, 총 비용은 20원이다.
    // 또 다른 방법으로 제일 왼쪽 도시에서 2리터의 기름을 넣고(2×5 = 10원) 다음 번 도시까지 이동한 후 4리터의 기름을 넣고(4×2 = 8원) 제일 오른쪽 도시까지 이동하면,
    // 총 비용은 18원이다.
    //각 도시에 있는 주유소의 기름 가격과, 각 도시를 연결하는 도로의 길이를 입력으로 받아 제일 왼쪽 도시에서 제일
    // 오른쪽 도시로 이동하는 최소의 비용을 계산하는 프로그램을 작성하시오.
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[] dis =new int[count-1];
        String []s =  br.readLine().split(" ");
        for (int i =0;i<dis.length;i++){
            dis[i] = Integer.parseInt(s[i]);
        }

        int[] cost = Arrays.stream(br.readLine().split(" ")).mapToInt(value -> Integer.parseInt(value)).toArray();
        long min =  1000000000;
        long result = 0;
        for (int i = 0;i<dis.length;i++){
            if(min>=cost[i]){
                min = cost[i];
            }
            result += min*dis[i];
        }
        System.out.println(result);
    }
}