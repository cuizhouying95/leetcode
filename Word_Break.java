package leetcode_interviewed_100;
//����һ���ǿ��ַ��� s ��һ�������ǿյ����б���ֵ� wordDict���ж� s �Ƿ���Ա��ո���Ϊһ���������ֵ��г��ֵĵ��ʡ�
//���ʱ�����ظ�ʹ���ֵ��еĵ��ʡ�
//����Լ����ֵ���û���ظ��ĵ��ʡ�
import java.util.*;
public class Word_Break {
	//ʱ�临�Ӷȣ�O(n^2) ���dp������Ҫ����ѭ����
	public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        set.addAll(wordDict);

        boolean[] f=new boolean[s.length()+1];//boolean[i]��ʾstr[0..i-1]�ɱ�ƥ��
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
	//Ϊ���ҵ��⣬���ǿ��Լ���ֵ䵥����ÿһ�����ʵĿ���ǰ׺��������ֵ��г��ֹ�����ôȥ�����ǰ׺��ʣ�ಿ�ֻع���á�
	//ͬʱ�����ĳ�κ��������з��������ַ������Ѿ�����������ֵ��г��ֹ��ˣ������ͷ��� true ��
    //����ǰ�ķ����У����ǿ�����ຯ�����ö�������ģ�Ҳ�������ǻ����ͬ���ַ������ö�λ��ݺ�����
	//Ϊ�˱���������������ǿ���ʹ�ü��仯�ķ���������һ�� memomemo ����ᱻ��������������Ľ����
	//ÿ�����ʵ��Ѿ����ʹ��ĺ�׺����ֱ���� memomemo �����е�ֵ���ض�����Ҫ�������ú�����
	//ʱ�临�Ӷȣ�O(n^2) 
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
