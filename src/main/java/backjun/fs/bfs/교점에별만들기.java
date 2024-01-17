package backjun.fs.bfs;

import java.util.ArrayList;
import java.util.Arrays;

public class 교점에별만들기 {
    //Ax + By + C = 0
    //Ax + By + C = 0으로 표현할 수 있는 n개의 직선이 주어질 때, 이 직선의 교점 중 정수 좌표에 별을 그리려 합니다.

    //Ax + By + E = 0
    //Cx + Dy + F = 0
    //두 직선의 교점이 유일하게 존재할 경우, 그 교점은 다음과 같습니다.
    // x = BF-ED / AD-BC y = EC-AF/AD-BC

    public String[] solution(int[][] line) {
        int length = line.length;
        int maxX = 0;
        int minX = Integer.MAX_VALUE;
        int maxY = 0;
        int minY = Integer.MAX_VALUE;
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            int[] curLine = line[i];
            float A = curLine[0];
            float B = curLine[1];
            float E = curLine[2];
            for (int j = i + 1; j < length; j++) {
                int[] diffLine = line[j];
                float C = diffLine[0];
                float D = diffLine[1];
                float F = diffLine[2];
                float mod = ((A * D) - (B * C));
                if (mod == 0)
                    continue;
                float x = ((B * F) - (E * D)) / mod;
                float y = ((E * C) - (A * F)) / mod;
                int dumpX = (int) x;
                int dumpY = (int) y;
                if (x == dumpX && dumpY == y) {
                    list.add(new int[]{dumpX, dumpY});
                    maxX = Math.max(maxX, dumpX);
                    minX = Math.min(minX, dumpX);
                    maxY = Math.max(maxY, dumpY);
                    minY = Math.min(minY, dumpY);
                }
            }
        }
        int xLineNumber = maxX + 1 - minX;
        int yLineNumber = maxY + 1 - minY;
        String[] result = new String[yLineNumber];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < xLineNumber; i++) {
            sb.append(".");
        }
        Arrays.fill(result, sb.toString());
        for (int i = 0; i < list.size(); i++) {
            int[] xy = list.get(i);
            int x = xy[0] - minX;
            int y = xy[1] + minY;
            result[y] = result[y].substring(0, x) + "*"  + result[y].substring((x + 1));
        }
        for (String str : result){
            System.out.println(str);
        }
        return result;
    }

}
