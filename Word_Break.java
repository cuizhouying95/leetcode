package leetcode_interviewed_100;
//给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
//拆分时可以重复使用字典中的单词。
//你可以假设字典中没有重复的单词。
import java.util.*;
public class Word_Break {
	//时间复杂度：O(n^2) 求出dp数组需要两重循环。
	public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        set.addAll(wordDict);

        boolean[] f=new boolean[s.length()+1];//boolean[i]表示str[0..i-1]可被匹配
        f[0]=true;
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(f[j]==true&&set.contains(s.substring(j,i))){
                    f[i]=true;
                    break;
                }
            }
        }
        return f[s.length()];
    }
	//为了找到解，我们可以检查字典单词中每一个单词的可能前缀，如果在字典中出现过，那么去掉这个前缀后剩余部分回归调用。
	//同时，如果某次函数调用中发现整个字符串都已经被拆分且在字典中出现过了，函数就返回 true 。
    //在先前的方法中，我们看到许多函数调用都是冗余的，也就是我们会对相同的字符串调用多次回溯函数。
	//为了避免这种情况，我们可以使用记忆化的方法，其中一个 memomemo 数组会被用来保存子问题的结果。
	//每当访问到已经访问过的后缀串，直接用 memomemo 数组中的值返回而不需要继续调用函数。
	//时间复杂度：O(n^2) 
	public boolean wordBreak2(String s, List<String> wordDict) {
        return word_Break(s, new HashSet(wordDict), 0, new Boolean[s.length()]);
    }
    public boolean word_Break(String s, Set<String> wordDict, int start, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && word_Break(s, wordDict, end, memo)) {
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }
}
