package leetcode_interviewed_100;

public class Majority_Element {
	public int majorityElement(int[] nums) {
        //ÿ����������ɾ��������ͬ��������ͣ��ɾ�������ʣ�µ���һ����Ŀ��ֵ
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
