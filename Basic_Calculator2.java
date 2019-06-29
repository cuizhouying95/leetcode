package leetcode_interviewed_100;
import java.util.Stack;
public class Basic_Calculator2 {
	public int calculate(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        char[] exp=s.toCharArray();
        int num=0;
        char sign = '+';
        for(int i=0;i<exp.length;i++){
            if(exp[i]>='0'&&exp[i]<='9'){
                num=num*10+exp[i]-'0';
            }
            if((!(exp[i]>='0'&&exp[i]<='9') &&exp[i]!=' ') || (i==exp.length-1)){
                if(sign=='-'){
                    stack.push(-num);
                }
                if(sign=='+'){
                    stack.push(num);
                }
                if(sign=='*'){
                    stack.push(stack.pop()*num);
                }
                if(sign=='/'){
                    stack.push(stack.pop()/num);
                }
                sign = exp[i];
                num = 0;
            }
        }
        int total = 0;
        while (!stack.isEmpty()) total += stack.pop();
        return total;
    }
}
