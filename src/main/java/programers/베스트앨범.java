package programers;

import java.util.*;

public class 베스트앨범 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = solution.solution(
                new String[]{"classic", "pop", "classic", "classic", "pop"},
                new int[]{500, 600, 150, 800, 2500}
        );
        for (int i : arr) {
            System.out.println(i);
        }
    }

    static class Solution {
        public int[] solution(String[] genres, int[] plays) {
            HashMap<String, PriorityQueue<int[]>> album = new HashMap<>();

            HashMap<String, Integer> genresPlaysCount = new HashMap<>();
            for (int i = 0; i < plays.length; i++) {
                Queue<int[]> queue = album.computeIfAbsent(genres[i],
                        k -> new PriorityQueue<>((o1, o2) -> o2[1] - o1[1])
                );
                genresPlaysCount.put(genres[i], genresPlaysCount.getOrDefault(genres[i], 0) + plays[i]);
                queue.add(new int[]{i, plays[i]});
            }
            List<Integer> answerList = new ArrayList<>();
            Set<String> keySet = genresPlaysCount.keySet();
            PriorityQueue<Entry> pq = new PriorityQueue<>(Collections.reverseOrder());
            for (String genre : keySet) {
                pq.offer(new Entry(genre, genresPlaysCount.get(genre)));
            }
            int i = 0;
            while (!pq.isEmpty()) {
                Entry entry = pq.poll();
                Queue<int[]> queue = album.get(entry.key);
                int count = 0;
                while (!queue.isEmpty()) {
                    int[] current = queue.poll();
                    answerList.add(current[0]);
                    i++;
                    count++;
                    if (count >= 2)
                        break;
                }
            }

            return answerList.stream().mapToInt(Integer::intValue).toArray();
        }
    }

    static class Entry implements Comparable<Entry> {
        String key;
        int value;

        public Entry(String key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Entry o) {
            return Integer.compare(this.value,o.value);
        }
    }
}