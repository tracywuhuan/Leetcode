/*
 * =====================================================================================
 *
 *       Filename:  1_Two_Sum.c
 *
 *    Description: https://leetcode.com/problems/two-sum/description/ 
 *
 *        Version:  1.0
 *        Created:  03/14/2018 10:10:41
 *       Revision:  none
 *       Compiler:  gcc
 *
 *         Author:  YOUR NAME (), 
 *   Organization:  
 *
 * =====================================================================================
 */

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* twoSum(int* nums, int numsSize, int target) {
    int i,j;
    int *retarray = (int*)malloc(2*sizeof(int));
    for(i=0;i<numsSize;i++){
        for(j=i+1;j<numsSize;j++){
            if((nums[i]+nums[j]) == target){
                retarray[0]=i;
                retarray[1]=j;
                return retarray;
            }
        }
    }
    return retarray;
}
