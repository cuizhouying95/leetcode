package leetcode_interviewed_100;
import java.util.HashMap;
public class RandomizedSet {
	private HashMap<Integer,Integer> keyIndexMap;
    private HashMap<Integer,Integer> indexKeyMap;
    private int size;
   /** Initialize your data structure here. */
   public RandomizedSet() {
       this.keyIndexMap= new HashMap<Integer,Integer>();
       this.indexKeyMap= new HashMap<Integer,Integer>();
       this.size=0;
   }
   
   /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
   public boolean insert(int val) {
       if(!this.keyIndexMap.containsKey(val)){
           this.keyIndexMap.put(val,this.size);
           this.indexKeyMap.put(this.size++,val);
           return true;
       }
       return false;
   }
   
   /** Removes a value from the set. Returns true if the set contained the specified element. */
   public boolean remove(int val) {
       if(this.keyIndexMap.containsKey(val)){
           //lastKey放到deleteKey的位置
           int deleteIndex=this.keyIndexMap.get(val);
           int lastIndex=this.size-1;
           int lastKey=this.indexKeyMap.get(lastIndex);
           this.keyIndexMap.put(lastKey,deleteIndex);//键不可以重复，修改了lastKey的值
           this.indexKeyMap.put(deleteIndex,lastKey);
           this.keyIndexMap.remove(val);
           this.indexKeyMap.remove(lastIndex);
           this.size-=1;
           return true;
       }
       return false;
   }
   
   /** Get a random element from the set. */
   public int getRandom() {
       
       int randomIndex=(int) (Math.random()*this.size);
       return this.indexKeyMap.get(randomIndex);
   }
}
