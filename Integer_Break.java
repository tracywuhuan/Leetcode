//https://leetcode-cn.com/problems/integer-break/description/
//
//
class Solution {
    
    public int integerBreak(int n) {
        int result = 1;
        if(n==2){
            return 1;
        }
        if(n==3){
            return 2;
        }
        while(n>1){
            if(n-3>1){
                result*=3;
                n=n-3;
            }else if(n-3==1){
                result*=2;
                n=n-2;
            }else{
                result*=n;
                break;
            }
        }
        return result;
    }
}
