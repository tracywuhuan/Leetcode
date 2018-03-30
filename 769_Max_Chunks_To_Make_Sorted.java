//https://leetcode-cn.com/problems/max-chunks-to-make-sorted/description/
//
//
class Solution {
    public int maxChunksToSorted(int[] arr) {
        if(arr.length<=1){
            return 1;
        }
        int max = arr[0];
        int min = arr[0];
        int num=0;
        //List<Integer>  list = new ArrayList<Integer>();
        //List<List<Integer>> list = new ArrayList<List<Integer>>();
        for(int i = 0;i<arr.length-1;i++){
            if(max<arr[i]){//前半段的最大值
                max=arr[i];
            }
            min = arr[i+1];
            for(int j=i+1;j<arr.length;j++){//后半段最小值
                min = Math.min(min,arr[j]);
            }
            if(arr[i]<=arr[i+1]){//只要当前想切的点 前面小于后面，就有机会切
                if(max<=min)//只要前半段最大值小于等于后半段最小值，就满足切完排序不影响整个顺序，记录切的点
                    num++;
            }
        }
        return num+1;
    }
}
