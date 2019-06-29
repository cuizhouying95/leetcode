package leetcode_interviewed_100;

public class Move_Zeroes {
	//解法一
	public void moveZeroes1(int[] nums) {
        int n=nums.length;
        
        int numZeroes=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
            	numZeroes++;
            }
        }
        
        int[] ans=new int[n];
        int j=0;
        for(int i=0;i<n;i++){
            if(nums[i]!=0){
                ans[j++]=nums[i];
            }
        }
        for(int i=0;i<n;i++){
            nums[i]=ans[i];
        }
    }
	//解法二
	public void moveZeroes2(int[] nums) {
        int lastNonZeroFoundAt=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[lastNonZeroFoundAt++]=nums[i];
            }
        }
        
        for(int i=lastNonZeroFoundAt;i<nums.length;i++){
            nums[i]=0;
        }
    }
	//解法三
	public void moveZeroes3(int[] nums) {
	    for (int lastNonZeroFoundAt = 0, cur = 0; cur < nums.length; cur++) {
	        if (nums[cur] != 0) {
	            swap(nums,lastNonZeroFoundAt++, cur);
	          }
	        }
	    }
	    
	    public void swap(int[] nums,int i,int j) {
	        int tmp=nums[i];
	        nums[i]=nums[j];
	        nums[j]=tmp;
	    }
}
