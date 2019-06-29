package leetcode_interviewed_100;

public class String_to_Integer {
	public int myAtoi(String str) {
        if(str==null||str.equals("")){
            return 0;
        }
        int index = 0;
        while(index < str.length()&&str.charAt(index) == ' ') index++;
        if(index>=str.length()) return 0;//每个位置都为空格
        //确定正负
        int sign=1;
        if(str.charAt(index) == '+' || str.charAt(index) == '-'){
        sign = str.charAt(index) == '+' ? 1 : -1;
        index ++;
    }
       int total=0;
      while(index < str.length()){
         int digit = str.charAt(index) - '0';
         if(digit < 0 || digit > 9) break;//遇到其他字符，直接停止
        //check if total will be overflow after 10 times and add digit
         if(Integer.MAX_VALUE/10 < total || 
            Integer.MAX_VALUE/10 == total && 
            Integer.MAX_VALUE %10< digit)//此处不能有等号
         return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
         total = 10 * total + digit;
         index ++;
       }
      return total * sign;
    }
}
