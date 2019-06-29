package leetcode_interviewed_100;

public class Majority_Element {
	public int majorityElement(int[] nums) {
        //每次在数组中删除两个不同的数，不停的删除，最后剩下的数一定是目标值
        int cand=0;
        int times=0;
        for(int i=0;i<nums.length;i++){
            if(times==0){
                cand=nums[i];
                times=1;
            }
            else if(nums[i]==cand){
                times++;
            }else{
                times--;
            }
        }
        return cand;
    }
	
	
}
