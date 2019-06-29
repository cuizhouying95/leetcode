package leetcode_interviewed_100;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
public class Letter_Combinations_of_a_Phone_Number {
	HashMap<Character, String> phone = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
   }};
       
     List<String> output = new ArrayList<String>();
   public List<String> letterCombinations(String digits) {
       
    if(digits.length()!=0) backtrack("",digits,0);
       return output;
   }

   public void backtrack(String combination,String digits,int i){
       if(i>=digits.length()){
           output.add(combination);
           return;
       }else{
           char digit=digits.charAt(i);
           String letters=phone.get(digit);
           for(int j=0;j<letters.length();j++){
           String letter=letters.substring(j,j+1);
           backtrack(combination+letter,digits,i+1);    
           }
       } 
     }

}
