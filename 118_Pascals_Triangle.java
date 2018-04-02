//https://leetcode-cn.com/problems/pascals-triangle/description/
//
//
class Solution {
    public List<List<Integer>> generate(int numRows) {
        if(numRows<=0){
            return new ArrayList<>();
        }
        List<List<Integer>> array = new ArrayList<>();
        array.add(new ArrayList<Integer>(){{add(1);}});
        if(numRows==1){
            return array;
        }
        array.add(new ArrayList<Integer>(){{add(1);add(1);}});
        if(numRows ==2){
            return array;
        }
        for(int i =2;i<numRows;i++){
            List<Integer> line = new ArrayList<Integer>();
            line.add(1);
            List<Integer> lastline = array.get(i-1);
            for(int j=0;j<lastline.size()-1;j++){
                line.add(lastline.get(j)+lastline.get(j+1));
            }
            line.add(1);
            array.add(line);
        }
        return array;
    }
}
