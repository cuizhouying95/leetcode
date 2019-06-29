package leetcode_interviewed_100;
//Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
//'?' Matches any single character.
//'*' Matches any sequence of characters (including the empty sequence).
//The matching should cover the entire input string (not partial).
//s could be empty and contains only lowercase letters a-z.
//p could be empty and contains only lowercase letters a-z, and characters like ? or *.
public class Wildcard_Matching {
	public boolean isMatch(String s, String p) {
        if(s==null||p==null){
            return false;
        }
        if (p.equals(s) || p.equals("*")) return true;
        char[] ss=s.toCharArray();
        char[] pp=p.toCharArray();
        boolean[][] d=new boolean[pp.length+1][ss.length+1];
        d[0][0]=true;
        
        for(int pi=1;pi<pp.length+1;pi++){
            //如果当前位置的字符为*
            if(pp[pi-1]=='*'){
                int si=1;
                while((!d[pi-1][si-1])&&(si<ss.length+1)) si++;//0-pi-2不能匹配s到的位置
                d[pi][si-1]=d[pi-1][si-1];
                while(si<ss.length+1) d[pi][si++]=true;
            }else if(pp[pi-1]=='?'){//如果当前位置的字符为?
                for(int si=1;si<ss.length+1;si++)
                  d[pi][si]=d[pi-1][si-1]; 
            }else{
                for(int si=1;si<ss.length+1;si++){
                    d[pi][si] = d[pi - 1][si - 1] &&(pp[pi-1]==ss[si-1]);
                }
            }
        }
        return d[pp.length][ss.length];
    }
}
