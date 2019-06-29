package leetcode_interviewed_100;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class Group_Anagrams {
	//�ⷨһ
	public List<List<String>> groupAnagrams1(String[] strs) {
        if(strs.length==0) return new ArrayList<List<String>>();
        HashMap<String,List<String>> ans=new HashMap <String,List<String>>();
        for(String s:strs){
            char[] ca=s.toCharArray();
            Arrays.sort(ca);
            String key=String.valueOf(ca);
            if(!ans.containsKey(key)){
                ans.put(key,new ArrayList<String>());
            }
            ans.get(key).add(s);
        }
        return new ArrayList<List<String>>(ans.values());
    }
	//�ⷨ��
	public List<List<String>> groupAnagrams2(String[] strs) {
        if(strs.length==0) return new ArrayList<List<String>>();
        HashMap<String,List<String>> ans=new HashMap <String,List<String>>();
        int[] count=new int[26];
        for(String s:strs){
            Arrays.fill(count,0);
            for(char c:s.toCharArray()) count[c-'a']++;//ÿ����ĸ���ֵĴ���
            StringBuilder sb=new StringBuilder("");
            for(int i=0;i<26;i++){
                sb.append('#');
                sb.append(count[i]);        
            }
            String key=sb.toString();
            if(!ans.containsKey(key)) ans.put(key,new ArrayList<String>());
            ans.get(key).add(s);
        }
        return new ArrayList<List<String>>(ans.values());
    }
}
