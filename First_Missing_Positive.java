package leetcode_interviewed_100;
//Given an unsorted integer array, find the smallest missing positive integer.
public class First_Missing_Positive {
	public int firstMissingPositive(int[] nums) {
        int l=0;//��ʾ������ĿǰΪֹ�������Ѱ�����������Χ��1~l
        //��ʾ������ĿǰΪֹ���ں�����������״��������£�������ܰ�����������Χ��1~r
        //��δ��ʼ����ǰ��������������״�����������1~N���е�����
        int r=nums.length;
        while(l<r){
            if(nums[l]==l+1){
                l++;
            }else if(nums[l]<=l||nums[l]>r||nums[nums[l]-1]==nums[l]){
                nums[l]=nums[--r];//l+1~r��Χ�ϵ�������һ��
            }else{
                swap(nums,l,nums[l]-1);//����l+1~r��Χ�ϵ���������δ�����ظ�
            }
        }
        return l+1;
    }
    public void swap(int[] arr, int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;           
    }
}
