package leetcode_interviewed_100;
import java.util.List;
import java.util.ArrayList;
public class Generate_Parentheses {
	//解法一
	public List<String> generateParenthesis(int n) {
        List<String> ans =new ArrayList<String>();
        backtrack(ans,"",0,0,n);
        return ans;
    }
    
    public void backtrack(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max)
            backtrack(ans, cur+"(", open+1, close, max);
        if (close < open)//右括号个数小于左括号个数
            backtrack(ans, cur+")", open, close+1, max);
    } 
}
