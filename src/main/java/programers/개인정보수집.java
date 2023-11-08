package programers;

import java.util.ArrayList;
import java.util.List;

public class 개인정보수집 {
    public static void main(String[] args) {
        int a[]=new Solution().solution("2022.05.19",new String[]{"A 6", "B 12", "C 3"},
                new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"});

        for (int i = 0; i <a.length ; i++) {
            System.out.println(a[i]);
        }
    }
    static class Solution {
        public int[] solution(String today, String[] terms, String[] privacies) {
            String[] todaySplit = today.split("[.]");
            int todayYear = Integer.parseInt(todaySplit[0])*28*12;
            int todayMonth = Integer.parseInt(todaySplit[1])*28;
            System.out.println(todayYear);
            int todayDay = Integer.parseInt(todaySplit[2]);
            int totalDay = todayDay+todayYear+todayMonth;
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < privacies.length; i++) {
                String str[]= privacies[i].split(" ");
                String[] date = str[0].split("[.]");
                String type = str[1];

                int year = Integer.parseInt(date[0])*28*12;
                int month = Integer.parseInt(date[1])*28;
                int day = Integer.parseInt(date[2]);
                int total = year+month+day;
                int ddd = totalDay-total;
                int dd = 0;
                for (int j = 0; j < terms.length; j++) {
                    String[] t = terms[j].split(" ");
                    String ty = t[0];
                    dd = Integer.parseInt(t[1])*28;
                    if(ty.equals(type)){
                        break;
                    }
                }
                if(ddd>=dd){
                    list.add(i+1);
                }
            }



            return list.stream().mapToInt(value -> value).toArray();
        }
    }
}
