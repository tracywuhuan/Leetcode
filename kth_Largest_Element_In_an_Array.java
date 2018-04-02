//https://leetcode-cn.com/problems/kth-largest-element-in-an-array/description/
//
//
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int length = nums.length;
        return find_k(nums,0,length-1,k);
    }
    public int find_k(int[] nums,int low,int high,int k){
        if(k<0||k>high-low+1)
            return -1;
        int piv = nums[low];//选第一个数为哨兵
        int tlow = low;
        int count = 1;
        for(int i=low+1;i<=high;i++){
            if(piv<nums[i]){//大于哨兵的往左扔
                int temp = nums[i];
                for(int j = i;j>tlow;j--){//调整数组
                    nums[j]=nums[j-1];
                }
                nums[tlow] = temp;
                tlow++;//low位置更新
                count++;//计算左边的个数
            }
        }
 
        if(count>k){//左边的个数大于k，说明数在左边，继续查找
            return find_k(nums,low,tlow-1,k);
        }else if(count<k){//在右边查找
            return find_k(nums,tlow+1,high,k-count);
        }else//找到了
            return nums[tlow];
    }
}
