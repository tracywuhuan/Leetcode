//https://leetcode-cn.com/problems/find-the-difference/description/
//
class Solution {
    public char findTheDifference(String s, String t) {
        List<Character> list = new ArrayList<Character>();
        for(int i=0;i<t.length();i++){
            list.add(t.charAt(i));
        }
        
        for(int i = 0;i<s.length();i++){
            int loc = list.indexOf(s.charAt(i));
            if(loc!=-1){
                list.remove(loc);
            }
        }
        return list.get(0);
    }
}
