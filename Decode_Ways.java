package leetcode_interviewed_100;

public class Decode_Ways {
	public int numDecodings(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        char[] chars=s.toCharArray();
        int[] dp=new int[chars.length+1];//dp[i] means the way to decode a string of size 1.
        dp[0]=1;
        dp[1]=chars[0]=='0'?0:1;
        for(int i=2;i<=chars.length;i++){
            char first=chars[i-1];
            char second=chars[i-2];
            if(first>='1'&&first<='9'){
                dp[i]+=dp[i-1];
            }
            if((second=='1'&&first>='0'&&first<='9')||(second=='2'&&first>='0'&&first<='6')){
                dp[i]+=dp[i-2];
            }
        }
        return dp[chars.length];
    }
}
