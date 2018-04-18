// https://leetcode.com/problems/array-nesting/description/
// 
class Solution {
    public int arrayNesting(int[] nums) {
        boolean[] hitted = new boolean[nums.length];
        int max = 1;
        for(int i =0;i<nums.length;i++){
            if(!hitted[i]){
                HashSet hashset=new HashSet();
                while(hashset.add(nums[i])){
                    hitted[i]=true;
                    i = nums[i];
                }
                max = Math.max(max,hashset.size());
            }
        }
        return max;
    }
}
