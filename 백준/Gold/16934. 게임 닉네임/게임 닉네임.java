
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Trie trie = new Trie();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            StringBuilder sb = new StringBuilder(str);
            int prefixStart = trie.findPrefix(str);
            trie.insert(str);
            if (prefixStart + 1 >= str.length()) {
                int count = trie.searchCount(str);
                if (count > 1) {
                    sb.append(count);
                }
                System.out.println(sb);
            } else {
                System.out.println(sb.substring(0, prefixStart + 1));
            }

        }
    }


    static class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEndOfWord;

        public TrieNode() {
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }

    static class Trie {
        private TrieNode root = new TrieNode();
        private Map<String, Integer> countMap = new HashMap<>();

        public void insert(String str) {
            int value = countMap.getOrDefault(str, 0);
            countMap.put(str, value + 1);

            TrieNode node = root;
            for (char c : str.toCharArray()) {
                node.children.putIfAbsent(c, new TrieNode());
                node = node.children.get(c); // 자식을 계속 찾아야한다.
            }
            node.isEndOfWord = true;

        }

        public int searchCount(String str) {
            int value = countMap.getOrDefault(str, 0);
            return value;
        }

        public int findPrefix(String str) {
            TrieNode node = root;
            int n = 0;
            for (char c : str.toCharArray()) {
                node = node.children.get(c);

                if (node == null) {
                    break;
                }
                n++;
            }
            return n;
        }

    }
}
