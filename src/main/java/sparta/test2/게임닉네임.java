package sparta.test2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 게임닉네임 {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Trie trie = new Trie();
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            String prefixStart = trie.findPrefix(str);
            trie.insert(str);
            if (prefixStart.length() >= str.length()) {
                int count = trie.searchCount(str);
                sb.append(str);
                if (count > 1) {
                    sb.append(count);
                }

            } else {
                sb.append(prefixStart);
            }
            sb.append("\n");
        }
        System.out.println(sb);
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
                node.children.putIfAbsent(c, new TrieNode()); // 없으면 넣고 있으면 null
                node = node.children.get(c); // 자식을 계속 찾아야한다.
            }
            node.isEndOfWord = true;
        }

        public int searchCount(String str) {
            int value = countMap.getOrDefault(str, 0);
            return value;
        }

        public String findPrefix(String str) {
            TrieNode node = root;
            StringBuilder sb = new StringBuilder();

            for (char c : str.toCharArray()) {
                sb.append(c);

                node = node.children.get(c);

                if ( node == null || node.isEndOfWord) {
                    break;
                }
            }
            return sb.toString();
        }

    }
}
