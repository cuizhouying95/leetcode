package leetcode_interviewed_100;

public class Single_Number {
	public int singleNumber(int[] nums) {
        int eO=0;
        for(int cur:nums){
            eO^=cur;
        }
        return eO;
    }
}
