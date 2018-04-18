//https://leetcode-cn.com/problems/single-number-iii/description/


class Solution {
    public int[] singleNumber(int[] nums) {
        HashSet<Integer> hashset=new HashSet<Integer>();
        for(int i = 0;i<nums.length;i++){
            if(!hashset.add(nums[i])){
                hashset.remove(nums[i]);
            }
        }
        // 先将set集合转为Integer型数组  
        Integer[] temp = hashset.toArray(new Integer[] {});//关键语句  
  
        // 再将Integer型数组转为int型数组  
        int[] intArray = new int[temp.length];  
        for (int i = 0; i < temp.length; i++) {  
            intArray[i] = temp[i].intValue();  
        }  
        return intArray;  
    }
}
