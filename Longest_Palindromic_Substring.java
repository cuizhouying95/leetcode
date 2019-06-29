package leetcode_interviewed_100;

public class Longest_Palindromic_Substring {
	public String longestPalindrome(String s) {
        if(s==null||s.length()<1) return "";
        int start=0;
        int end=0;
        for(int i=0;i<s.length();i++){
            int len1=expandAroundCenter(s,i,i);//以该位置的字母为中心
            int len2=expandAroundCenter(s,i,i+1);//以该位置的字母后的间隙为中心
            int len=Math.max(len1,len2);
            if(len>end-start){
                start=i-(len-1)/2;
                end=i+len/2;
            }
        }
        return s.substring(start,end+1);
    }
    
    private int expandAroundCenter(String s,int left,int right){
        int L=left;
        int R=right;
        while(L>=0&&R<s.length()&&s.charAt(L)==s.charAt(R)){
            L--;
            R++;
        }
        return R-L-1;
    }
}
