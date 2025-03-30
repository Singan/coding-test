import java.util.*;

public class Main {
    static int[] arr;
    static int N, S;
    static ArrayList<Integer> leftSum = new ArrayList<>();
    static ArrayList<Integer> rightSum = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); 
        S = sc.nextInt();
        arr = new int[N];

        for (int i = 0; i < N; i++) arr[i] = sc.nextInt();

        getSubsetSums(0, N / 2, 0, leftSum);  // 왼쪽 부분
        getSubsetSums(N / 2, N, 0, rightSum); // 오른쪽 부분
        Collections.sort(rightSum);  // 이분 탐색을 위해 정렬

        long count = countPairs();
        System.out.println(count);
    }

    static void getSubsetSums(int start, int end, int sum, ArrayList<Integer> list) {
        if (start == end) {
            list.add(sum);
            return;
        }
        getSubsetSums(start + 1, end, sum + arr[start], list);
        getSubsetSums(start + 1, end, sum, list);
    }

    static long countPairs() {
        long count = 0;
        for (int left : leftSum) {
            int target = S - left;
            int low = lowerBound(rightSum, target);
            int high = upperBound(rightSum, target);
            count += (high - low); // 개수만큼 추가
        }
        if (S == 0) count--; // 공집합 제외
        return count;
    }

    static int lowerBound(List<Integer> list, int key) {
        int lo = 0, hi = list.size();
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (list.get(mid) < key) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    static int upperBound(List<Integer> list, int key) {
        int lo = 0, hi = list.size();
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (list.get(mid) <= key) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}
