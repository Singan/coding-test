package programers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 표병합 {
    //당신은 표 편집 프로그램을 작성하고 있습니다.
    //표의 크기는 50 × 50으로 고정되어있고 초기에 모든 셀은 비어 있습니다.
    //각 셀은 문자열 값을 가질 수 있고, 다른 셀과 병합될 수 있습니다.
    //
    //위에서 r번째, 왼쪽에서 c번째 위치를 (r, c)라고 표현할 때, 당신은 다음 명령어들에 대한 기능을 구현하려고 합니다.
    public static void main(String[] args) {
        String[] command = {"UPDATE 1 1 menu", "UPDATE 1 2 category", "UPDATE 2 1 bibimbap", "UPDATE 2 2 korean", "UPDATE 2 3 rice", "UPDATE 3 1 ramyeon", "UPDATE 3 2 korean", "UPDATE 3 3 noodle", "UPDATE 3 4 instant", "UPDATE 4 1 pasta", "UPDATE 4 2 italian", "UPDATE 4 3 noodle", "MERGE 1 2 1 3", "MERGE 1 3 1 4", "UPDATE korean hansik", "UPDATE 1 3 group", "UNMERGE 1 4", "PRINT 1 3", "PRINT 1 4"};
        Solution s= new Solution();
        String[] strArr = (s.solution(command));
        for (String str: strArr) {
            System.out.println(str);
        }
    }

    static class Solution {
         String table[][];

        public  String[] solution(String[] commands) {
            table = new String[51][51];
            List<String> answer = new LinkedList();

            for (String command : commands) {
                System.out.println(command);
                String[] commandSplit = command.split(" ");
                switch (commandSplit[0]) {
                    case "UPDATE" -> {
                        switch (commandSplit.length) {
                            case 4 -> update(commandSplit[1], commandSplit[2], commandSplit[3]);
                            case 3 -> update(commandSplit[1], commandSplit[2]);
                        }
                    }
                    case "MERGE" -> {
                        merge(commandSplit[1], commandSplit[2], commandSplit[3], commandSplit[4]);
                    }
                    case "UNMERGE" -> {
                        unMerge(commandSplit[1], commandSplit[2]);
                    }
                    case "PRINT" -> {
                        answer.add(print(commandSplit[1], commandSplit[2]));
                    }
                }
            }
            return answer.toArray(String[]::new);
        }

        public int[] parseString(String... args) {
            int[] arr = new int[args.length];
            for (int i = 0; i < args.length; i++) {
                arr[i] = Integer.parseInt(args[i]);
            }
            return arr;
        }

        public String print(String r, String c) {
            int arr[] = parseString(r, c);
            return table[arr[0]][arr[1]];
        }

        public void unMerge(String r1, String c1) {
            int[] arr = parseString(r1, c1);
            String str = table[arr[0]][arr[1]];
            table[arr[0]][arr[1]] = null;
            System.out.println(table[1][3]);
            table[arr[0]][arr[1]] = new String(str);
        }

        public void merge(String r1, String c1, String r2, String c2) {
            int[] arr = parseString(r1, c1, r2, c2);
            if (table[arr[0]][arr[1]].isEmpty() && !table[arr[2]][arr[3]].isEmpty()) {
                table[arr[0]][arr[1]] = table[arr[2]][arr[3]];
            } else {
                table[arr[2]][arr[3]] = table[arr[0]][arr[1]];
            }
        }

        public void update(String r, String c, String value) {
            int[] arr = parseString(r, c);
            table[arr[0]][arr[1]] = value;
        }

        public void update(String value1, String value2) {
            for (String[] row : table) {
                for (int i = 0; i < row.length; i++) {
                    String cell = row[i];
                    if (cell!=null&&cell.equals(value1)) {
                        cell = value2;
                    }
                }
            }
        }
    }
}
