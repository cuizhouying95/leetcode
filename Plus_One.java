package leetcode_interviewed_100;
//Input: [1,2,3]
//Output: [1,2,4]
//Explanation: The array represents the integer 123.
public class Plus_One {
	public int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
        if(digits[i] < 9) {
            digits[i]++;
            return digits;
           }
        
          digits[i] = 0;
         }
    
        int[] newNumber = new int [n+1];//ÀýÈç999£»
        newNumber[0] = 1;
        return newNumber;
    }
}
