package leetcode_interviewed_100;
//最长的相同的前缀
public class Longest_Common_Prefix {
	//解法一
	public String longestCommonPrefix1(String[] strs) {
        if(strs.length==0){
            return "";
        }
        String prefix=strs[0];
        for(int i=1;i<strs.length;i++){
            //int indexOf(String str): 返回指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
            while(strs[i].indexOf(prefix)!=0){
                prefix=prefix.substring(0,prefix.length()-1);
                if(prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
	//解法二
	public String longestCommonPrefix2(String[] strs) {
        if(strs.length==0){
            return "";
        }
        
        for(int i=0;i<strs[0].length();i++){
            char c=strs[0].charAt(i);
            for(int j=1;j<strs.length;j++){
                if(i==strs[j].length()||strs[j].charAt(i)!=c){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }
	//解法三
	public String longestCommonPrefix3(String[] strs) {
        if(strs.length==0||strs.length==0){
            return "";
        }
        return longestCommonPrefix(strs, 0 , strs.length - 1);
    }
    
    private String longestCommonPrefix(String[] strs,int l,int r){
        if(l==r){
            return strs[l];
        }else{
            int mid=(l+r)/2;
            String lcpLeft=longestCommonPrefix(strs,l,mid);
            String lcpright=longestCommonPrefix(strs,mid+1,r);
            return commonPrefix(lcpLeft,lcpright);
        }
    }
    
    private String commonPrefix(String left,String right) {
    int min = Math.min(left.length(), right.length());       
    for (int i = 0; i < min; i++) {
        if ( left.charAt(i) != right.charAt(i) )
            return left.substring(0, i);
    }
    return left.substring(0, min);
 }
}
