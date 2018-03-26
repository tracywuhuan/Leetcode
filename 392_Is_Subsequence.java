//https://leetcode.com/problems/is-subsequence/description/
//
class Solution {
    public boolean isSubsequence(String s, String t) {
        int slength = s.length();
        int tlength = t.length();
        int i=0;
        int j=0;
        if(slength==0){
            return true;
        }
        for(i=0;i<slength;i++){
            char current = s.charAt(i);
            for(;j<tlength;j++){
                if(current==t.charAt(j)){
                    j++;
                    if(i==slength-1){
                        return true;
                    }
                    break;
                }
            }
        }
        return false;
    }
}
