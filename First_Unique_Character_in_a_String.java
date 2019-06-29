package leetcode_interviewed_100;

public class First_Unique_Character_in_a_String {
public int firstUniqChar(String s) {
        
        char[] chas=s.toCharArray();
        int n=chas.length;
        int[] count=new int[256];
        for(int i=0;i<n;i++){
            count[chas[i]]++;
        }
        for(int i=0;i<n;i++){
            if(count[chas[i]]==1){
                return i;
            }
        }
        return -1;
    }
}
