package leetcode_interviewed_100;
//给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，
//使得句子中所有的单词都在词典中。返回所有这些可能的句子
import java.util.*;
public class Word_Break2 {

	//方法一，暴力法
	//时间复杂度：O(n^n)
	//空间复杂度：O(n^3)
	public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        set.addAll(wordDict);
        return word_Break(s, set, 0);
    }
    public List<String> word_Break(String s, Set<String> wordDict, int start) {
        LinkedList<String> res = new LinkedList<>();
        if (start == s.length()) {
            res.add("");
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end))) {
                List<String> list = word_Break(s, wordDict, end);
                for (String l : list) {
                    res.add(s.substring(start, end) + (l.equals("") ? "" : " ") + l);
                }
            }
        }
        return res;
    }
    
    //方法二，
    //为了避免这种情况，我们使用记忆化的方法，我们使用一个 key:value这样的哈希表来进行优化。
    //在哈希表中， key 是当前考虑字符串的开始下标， value 包含了所有从头开始的所有可行句子。
    //下次我们遇到相同位置开始的调用时，我们可以直接从哈希表里返回结果，而不需要重新计算结果。
    //时间复杂度：O(n^3)
     
    public List<String> wordBreak2(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
         set.addAll(wordDict);

         return word_Break2(s,set, 0);
     }
     
     HashMap<Integer, List<String>> map = new HashMap<>();

     public List<String> word_Break2(String s, Set<String> wordDict, int start) {
         if (map.containsKey(start)) {
             return map.get(start);
         }
         LinkedList<String> res = new LinkedList<>();
         if (start == s.length()) {
             res.add("");
         }
         for (int end = start + 1; end <= s.length(); end++) {
             if (wordDict.contains(s.substring(start, end))) {
                 List<String> list = word_Break(s, wordDict, end);
                 for (String l : list) {
                     res.add(s.substring(start, end) + (l.equals("") ? "" : " ") + l);
                 }
             }
         }
         map.put(start, res);
         return res;
     }

     //方法三 动态规划
     public List<String> wordBreak3(String s, List<String> wordDict) {
         Set<String> set = new HashSet<>();
         set.addAll(wordDict);
         LinkedList<String>[] dp = new LinkedList[s.length() + 1];
         LinkedList<String> initial = new LinkedList<>();
         initial.add("");
         dp[0] = initial;
         for (int i = 1; i <= s.length(); i++) {
             LinkedList<String> list = new LinkedList<>();
             for (int j = 0; j < i; j++) {
                 if (dp[j].size() > 0 && set.contains(s.substring(j, i))) {
                     for (String l : dp[j]) {
                         list.add(l + (l.equals("") ? "" : " ") + s.substring(j, i));
                     }
                 }
             }
             dp[i] = list;
         }
         return dp[s.length()];

      }
}
