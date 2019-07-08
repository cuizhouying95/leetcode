package leetcode_interviewed_100;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
public class Word_Search2 {

	Set<String> res=new HashSet<String>();
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie =new Trie();
        for(String str:words){
            trie.insert(str);
        }
        int m=board.length;
        int n=board[0].length;
        boolean[][] visited=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dfs(board,visited,"",i,j,trie);
            }
        }
        return new ArrayList<String>(res);
    }
    
    public void dfs(char[][] board,boolean[][] visited,String str,int x,int y,Trie trie){
        if(x<0||x>=board.length||y<0||y>=board[0].length) return;
        if (visited[x][y]) return;
        str+=board[x][y];
        if (trie.prefixNumber(str)==0) return;
        if (trie.search(str)) {
            res.add(str);
        }
        visited[x][y]=true;
        dfs(board, visited, str, x - 1, y, trie);
        dfs(board, visited, str, x + 1, y, trie);
        dfs(board, visited, str, x, y - 1, trie);
        dfs(board, visited, str, x, y + 1, trie);
        visited[x][y]=false; 
    }
    
    public static class TrieNode{
		public int path;//表示有多少个单词共用这个节点
		public int end;//表示有多少个单词以这个节点结尾
		public TrieNode[] map;//map是一个哈希表结构，key代表该节点的一条字符路径，value表示字符路径指向的节点
		
		public TrieNode () {
			path=0;
			end=0;
			map=new TrieNode[26];
		}
	}
	
	public static class Trie{
		private TrieNode root;
		
		public Trie() {
			root=new TrieNode();
		}
		
		public void insert(String word) {
			if(word==null) {
				return;
			}
			char[] chs=word.toCharArray();
			TrieNode node=root;
			int index=0;
			for(int i=0;i<chs.length;i++) {
				index=chs[i]-'a';
				if(node.map[index]==null) {
					node.map[index]=new TrieNode();
				}
				node=node.map[index];
				node.path++;
			}
			node.end++;
		}
		
		public boolean search(String word) {
			if(word==null) {
				return false;
			}
			char[] chs=word.toCharArray();
			TrieNode node=root;
			int index=0;
			for(int i=0;i<chs.length;i++) {
				index=chs[i]-'a';
				if(node.map[index]==null) {
					return false;
				}
				node=node.map[index];			
			}
			return node.end!=0;
		}
		
		public void delete(String word) {
			if (search(word)) {
				char[] chs=word.toCharArray();
				TrieNode node=root;
				int index=0;
				for(int i=0;i<chs.length;i++) {
					index=chs[i]-'a';
					if(node.map[index].path--==1) {
						node.map[index]=null;
						return ;
					}
					node=node.map[index];			
				}
				node.end--;
			}
			}
		public int prefixNumber(String pre) {
			if(pre==null) {
				return 0;
			}
			char[] chs=pre.toCharArray();
			TrieNode node=root;
			int index=0;
			for(int i=0;i<chs.length;i++) {
				index=chs[i]-'a';
				if(node.map[index]==null) {
					return 0;
				}
				node=node.map[index];
		}
			return node.path;
		
	}
	}
}
