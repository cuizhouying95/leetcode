package leetcode_interviewed_100;
import java.util.HashMap;
import java.util.Stack;
public class Valid_Parentheses {
private HashMap<Character,Character> mappings;
    
    public Valid_Parentheses(){
        this.mappings=new HashMap <Character,Character>();
        this.mappings.put(')','(');
        this.mappings.put('}','{');
        this.mappings.put(']','[');
    }
    public boolean isValid(String s) {
       Stack<Character> stack=new Stack<Character>();
        
       for(int i=0;i<s.length();i++){
           char c=s.charAt(i);
           // If the current character is a closing bracket.
           if(this.mappings.containsKey(c)){
               char topElement=stack.isEmpty()?'#':stack.pop();
               // If the mapping for this bracket doesn't match the stack's top element, return false.
               if(topElement!=this.mappings.get(c)){
                   return false;
               }
           }else{
               // If the mapping for this bracket doesn't match the stack's top element, return false.
               stack.push(c);
           }
       }
        return stack.isEmpty();
    }
}
