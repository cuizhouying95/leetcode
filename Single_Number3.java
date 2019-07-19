package leetcode_interviewed_100;

//Given an array of numbers nums, in which exactly two elements appear only once and 
//all the other elements appear exactly twice. 
//Find the two elements that appear only once.
public class Single_Number3 {

	public int[] singleNumber(int[] nums) {
      int eO=0;
      int eOhasOne=0;
      for(int curNum:nums){
          eO^=curNum;
      }
      int rightOne=eO&(~eO+1);
      for(int cur:nums){
          if((cur&rightOne)!=0){
              eOhasOne^=cur;
          }
      }
      return new int[] { eOhasOne, eOhasOne^eO };    
  }
	
}