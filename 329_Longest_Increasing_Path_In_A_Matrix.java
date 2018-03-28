// https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/description/
// 
class Solution {
    private int row;
    private int col;
    private int max[][];//记录访问过的点的最大值
    public int longestIncreasingPath(int[][] matrix) {
        row = matrix.length;
        if(row<1){
            return 0;
        }
        col = matrix[0].length;
        
        max = new int[row][col];
        
        int maxlen = 1;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){//遍历每一个节点
                maxlen = Math.max(maxlen,getMax(i,j,matrix));
            }
        }
        return maxlen;
    }
    
    public int getMax(int i,int j,int[][] matrix){
        if(max[i][j]!=0){//这个节点原来路过过，直接读取最大值，接上就可以
            return max[i][j];
        }
        int stepmax = 1;
        if((i+1<row)&&matrix[i+1][j]>matrix[i][j]){//右移
            stepmax = Math.max(stepmax,getMax(i+1,j,matrix)+1);//右边的值比较大，可以连上，计算右边的max值，最后加上本节点+1，
        }
        if((i-1>=0)&&matrix[i-1][j]>matrix[i][j]){//左移
            stepmax = Math.max(stepmax,getMax(i-1,j,matrix)+1);//同理
        }
        if((j-1>=0)&&matrix[i][j-1]>matrix[i][j]){//上移
            stepmax = Math.max(stepmax,getMax(i,j-1,matrix)+1);
        }
        if((j+1<col)&&matrix[i][j+1]>matrix[i][j]){//下移
            stepmax = Math.max(stepmax,getMax(i,j+1,matrix)+1);
        }
        max[i][j]=stepmax;
        return stepmax;
    }
}
