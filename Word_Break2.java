package leetcode_interviewed_100;
//����һ���ǿ��ַ��� s ��һ�������ǿյ����б���ֵ� wordDict�����ַ��������ӿո�������һ�����ӣ�
//ʹ�þ��������еĵ��ʶ��ڴʵ��С�����������Щ���ܵľ���
import java.util.*;
public class Word_Break2 {

	//����һ��������
	//ʱ�临�Ӷȣ�O(n^n)
	//�ռ临�Ӷȣ�O(n^3)
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
    
    //��������
    //Ϊ�˱����������������ʹ�ü��仯�ķ���������ʹ��һ�� key:value�����Ĺ�ϣ���������Ż���
    //�ڹ�ϣ���У� key �ǵ�ǰ�����ַ����Ŀ�ʼ�±꣬ value ���������д�ͷ��ʼ�����п��о��ӡ�
    //�´�����������ͬλ�ÿ�ʼ�ĵ���ʱ�����ǿ���ֱ�Ӵӹ�ϣ���ﷵ�ؽ����������Ҫ���¼�������
    //ʱ�临�Ӷȣ�O(n^3)
     
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

     //������ ��̬�滮
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
