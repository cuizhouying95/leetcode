package leetcode_interviewed_100;

public class Container_With_Most_Water {
 public int maxArea(int[] height) {   
        int maxarea=0;
        int l=0;
        int r=height.length-1;
        while(l<r){
            maxarea=Math.max(maxarea,Math.min(height[l],height[r])*(r-l));
            if(height[l]<height[r]){//���Ƚ϶̵�һ���ƶ�����Ϊ������ȡ���ڶ̵�һ���ĳ���
                l++;
            }else{
                r--;
            }
        }
        return maxarea;
    }
}
