//https://leetcode.com/problems/search-a-2d-matrix-ii/description/
//
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0){
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i=0,j=col-1;i<row&&j>=0;){//右上角为二叉树的根，往左是左子树，往下是右子树
            if(matrix[i][j]>target){
                j--;
            }else if(matrix[i][j]<target){
                i++;
            }else{
                return true;
            }
        }
        return false;
    }
}
