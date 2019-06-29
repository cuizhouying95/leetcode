package leetcode_interviewed_100;
import java.util.HashMap;
import java.util.Map;
//Given a string S and a string T, 
//find the minimum window in S which will contain all the characters in T in complexity O(n).
public class Minimum_Window_Substring {
	public String minWindow(String s, String t) {
        if(s.length()==0||t.length()==0){
              return "";
        }
        
        Map<Character,Integer> dictT=new HashMap<Character,Integer>();
        
        for(int i=0;i<t.length();i++){
            if(!dictT.containsKey(t.charAt(i))){
                dictT.put(t.charAt(i),  1);
            }else{
                Integer val=dictT.get(t.charAt(i));
                dictT.put(t.charAt(i),  val+1);
            }
        }
        int required=dictT.size();
        int l=0;
        int r=0;
    // formed is used to keep track of how many unique characters in t
      // are present in the current window in its desired frequency.
        int formed=0;
        Map<Character,Integer> windowCounts=new HashMap<Character,Integer>();
        // ans list of the form (window length, left, right)
        int[] ans={-1,0,0};
        while(r<s.length()){
            char c=s.charAt(r);
            int count=windowCounts.getOrDefault(c,0);
            windowCounts.put(c,count+1);
            
            if(dictT.containsKey(c)&&windowCounts.get(c).intValue()==dictT.get(c).intValue()){
                formed++;
            }
            //³¢ÊÔÊÕËõ´°¿Ú
            while(l<=r&&formed==required){
                c=s.charAt(l);
                if(ans[0]==-1||r-l+1<ans[0]){
                    ans[0]=r-l+1;
                    ans[1]=l;
                    ans[2]=r;
                }
                
                windowCounts.put(c,windowCounts.get(c)-1);
                if(dictT.containsKey(c)&&windowCounts.get(c).intValue()<dictT.get(c).intValue()){
                formed--;
            }
                l++;
            }
         // Keep expanding the window once we are done contracting.
            r++;
        }
        return ans[0]==-1?"":s.substring(ans[1],ans[2]+1);
    }
}
