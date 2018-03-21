//https://leetcode.com/problems/container-with-most-water/description/
//
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxArea = Math.min(height[left],height[right])*(right-left);//初始最大值
        while(left!=right){
            if(height[left]<height[right]){//移动两个边中的较长边必定导致面积缩短，所以移动较短边
                left++;
            }
            else{
                right--;
            }
            maxArea = Math.max(maxArea,Math.min(height[left],height[right])*(right-left));
        }
        return maxArea;
    }
}
