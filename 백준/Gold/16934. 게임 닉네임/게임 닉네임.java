import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// 게임 닉네임
// 트라이 문제 
public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		StringBuilder sb = new StringBuilder();
		Trie16934 trie = new Trie16934();
		
		for(int i = 0; i < n; i++) {
			String word = br.readLine();
			int aliasIndex = trie.insertAndGetAliasIndex(word);	// 삽입한 다음 같은 접두사의 끝위치 인덱스 리턴 
			if(aliasIndex == -1) {	// 완전히 일치하는 단어가 존재하면 
				int count = trie.getSameCount(word);
				
				if(count == 1) {	// 같은 단어가 1개만 존재하는 경우	 
					sb.append(word);
				}
				if(count > 1) {
					sb.append(word).append(count);
				}
			}
			else {
				sb.append(word.substring(0, aliasIndex));
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}

//트라이 알고리즘에 사용되는 노드 
class TrieNode16934 {
	private Map<Character, TrieNode16934> childNode = new HashMap<>();
	private boolean isLastChar;
	private int count;

	// 해당 문자가 마지막 문자인지
	public boolean isLastChar() {
		return this.isLastChar;
	}

	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public void setLastChar(boolean isLastChar) {
		this.isLastChar = isLastChar;
	}

	public Map<Character, TrieNode16934> getChildNodes() {
		return this.childNode;
	}
	
	public TrieNode16934 makeChildNodes(char ch) {
		this.childNode.put(ch, new TrieNode16934());
		return this.childNode.get(ch);
	}
}

//트라이 알고리즘 
class Trie16934 {
	public TrieNode16934 rootTemp;

	// 생성자 생성
	Trie16934() {
		this.rootTemp = new TrieNode16934();
	}

	// 삽입 및 별칭을 만들 수 있는 인덱스 위치 리턴
	// -1 리턴 : 똑같은 단어가 기존에 존재 
	public int insertAndGetAliasIndex(String word) {
		TrieNode16934 tempNode = this.rootTemp;
		int index = -1;
		boolean isEnd = false;
		
		for(int i = 0; i < word.length(); i++) {
			// 이미 기존에 i번째 단어까지 접두사가 같은 경우 
			if(tempNode.getChildNodes().containsKey(word.charAt(i))) {
				tempNode = tempNode.getChildNodes().get(word.charAt(i));
			}
			else {	// 같은 접두사가 끝나버린 경우 
				if(!isEnd) {
					index = i + 1;
					isEnd = true;
				}
			
				tempNode = tempNode.makeChildNodes(word.charAt(i));
			}
		}
	
		if(index != -1) {	// 같은 접두사가 없는 경우 맨 끝 노드 count 1로 설정 
			tempNode.setCount(1);
		}
		else {
			tempNode.setCount(tempNode.getCount() + 1);
		}
		
		return index;
	}

	// 같은 단어가 존재할 때, 같은 단어의 개수 가져오기 
	public int getSameCount(String word) {
		TrieNode16934 tempNode = this.rootTemp;
		
		for(int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode16934 node = tempNode.getChildNodes().get(ch); 
			tempNode = node;
		}
	  	
		return tempNode.getCount();
	}
}