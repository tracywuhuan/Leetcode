//https://leetcode.com/problems/edit-distance/description/
//
//
class Solution {
    public int minDistance(String word1, String word2) {
        int length_1 = word1.length();
        int length_2 = word2.length();
        if(length_1==0||length_2==0){
            return Math.max(length_1,length_2);
        }
        int[][] dp = new int[length_1 + 1][length_2 + 1];//多创建一圈是为了包含两个空字符串时的值
        for(int i=0;i<=length_1;i++){
            dp[i][0] = i;
        }
        for(int i=0;i<=length_2;i++){
            dp[0][i] = i;
        }
        
        for(int i = 0;i<length_1;i++){
            for(int j = 0;j<length_2;j++){
                if(word1.charAt(i)==word2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j];
                }else{
                    int up = dp[i][j+1];
                    int left = dp[i+1][j];
                    int up_left = dp[i][j];
                    dp[i+1][j+1] = Math.min(up,Math.min(left,up_left))+1;//前一步的结果+当前一步
                }
            }
        }
        return dp[length_1][length_2];
    }
}
