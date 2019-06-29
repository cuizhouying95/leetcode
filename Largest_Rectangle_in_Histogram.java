package leetcode_interviewed_100;
import java.util.Stack;
public class Largest_Rectangle_in_Histogram {

	public int largestRectangleArea(int[] heights) {
        if(heights==null||heights.length==0){
            return 0;
        }
        int maxArea=0;
        Stack<Integer> stack=new Stack<Integer>();//����ջ�ṹ
        for(int i=0;i<heights.length;i++){
            while(!stack.isEmpty()&&heights[i]<=heights[stack.peek()]){
                //iΪheights[j]���ұ���������ұ���С������λ��
                int j=stack.pop();//�߶�
                int k=stack.isEmpty()?-1:stack.peek();//heights[j]�������������ұ���С������λ��
                int curArea=(i-k-1)*heights[j];
                maxArea=Math.max(maxArea,curArea);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int j=stack.pop();
            int k=stack.isEmpty()?-1:stack.peek();
            int curArea=(heights.length-k-1)*heights[j];
            maxArea=Math.max(maxArea,curArea);
        }
        return maxArea;
    }
	
}
