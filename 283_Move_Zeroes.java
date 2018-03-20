// https://leetcode.com/problems/move-zeroes/description/
class Solution {
    public void moveZeroes(int[] nums) {
        int window = 1;//0的窗口
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==0&&nums[i+window]!=0){//非0数字插入到0窗口之前
                int temp = nums[i+window];
                nums[i+window]=nums[i];
                nums[i]=temp;
            }
            if(nums[i]==0&&nums[i+window]==0){//增加0窗口的长度，并且将index指向0窗口第一个
                window++;
                i--;
            }
            if((i+window)==nums.length-1){//如果0窗口已经到底了，直接退出
                break;
            }
        }
    }
}

