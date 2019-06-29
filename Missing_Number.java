package leetcode_interviewed_100;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
public class Missing_Number {
//解法一，先排序
	public int missingNumber1(int[] nums) {
	     Arrays.sort(nums);
	     if (nums[nums.length-1] != nums.length) {
	            return nums.length;
	        }else if (nums[0] != 0) {
	            return 0;
	        }
	      
	      for (int i = 1; i < nums.length; i++){
	          if(nums[i] != i){
	              return i;
	          }
	      }  
	        return -1;
	    }
	//解法二
	public int missingNumber2(int[] nums) {
        Set<Integer> numSet = new HashSet<Integer>();
        for (int num : nums) numSet.add(num);

        int expectedNumCount = nums.length + 1;
        for (int number = 0; number < expectedNumCount; number++) {
            if (!numSet.contains(number)) {
                return number;
            }
        }
        return -1;
    }
	//解法三，位运算
	public int missingNumber3(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
	//解法四
	public int missingNumber4(int[] nums) {
        int expectedSum = nums.length*(nums.length + 1)/2;
        int actualSum = 0;
        for (int num : nums) actualSum += num;
        return expectedSum - actualSum;
    }
}
