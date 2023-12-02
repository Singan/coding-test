package backjun.fs.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class MooTube {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] firstLineSplit = br.readLine().split(" ");
        int movieCount = Integer.parseInt(firstLineSplit[0]);
        int question = Integer.parseInt(firstLineSplit[1]);
        int movie[][] = new int[movieCount][movieCount];

        for (int i =0;i<movieCount-1;i++){
            String[] movieRelation = br.readLine().split(" ");
            int movieOne = Integer.parseInt(movieRelation[0])-1;
            int movieTwo = Integer.parseInt(movieRelation[1])-1;
            int osando = Integer.parseInt(movieRelation[2]);
            movie[movieOne][movieTwo] = osando;
            movie[movieTwo][movieOne] = osando;
        }
        for (int i = 0;i<question;i++){
            String[] questionLine = br.readLine().split(" ");
            int questionMovie = Integer.parseInt(questionLine[1])-1;
            int questionOsando = Integer.parseInt(questionLine[0]);
            int count = 0;
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(questionMovie);
            boolean[] chk = new boolean[movieCount];
            while (!queue.isEmpty()){
                int poll = queue.poll();
                chk[poll] = true;
                for (int j = 0; j < movie[poll].length; j++) {
                    if(movie[poll][j]>=questionOsando && !chk[j] ){
                        queue.offer(j);
                        count++;
                    }
                }
            }
            bw.write(count + "\n");
        }
        bw.flush();
    }
}
