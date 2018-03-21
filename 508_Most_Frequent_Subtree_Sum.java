//https://leetcode.com/problems/most-frequent-subtree-sum/description/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.Map.Entry;
class Solution {
    public int visit(TreeNode root,HashMap<Integer, Integer> map){
        if(root==null){
            return 0;
        }
        int left=0;
        int right=0;
        if(root.left!=null){
            left = visit(root.left,map);
        }
        if(root.right!=null){
            right = visit(root.right,map);
        }
        
        int sum = left+right+root.val;//计算当前节点的sum值
        if(map.containsKey(sum)){//如果有了，对应值的次数+1
            map.put(sum,map.get(sum)+1);
        }else{
            map.put(sum,1);
        }
        return sum;
    }
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root==null){
            return new int[0];
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int rootsum = visit(root,map);
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {  //对map的value进行排序
            //降序排序  
            @Override  
            public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {   
                return o2.getValue().compareTo(o1.getValue());  
            }  
        }); 
        ArrayList<Integer> array = new ArrayList<Integer>();
        int max = list.get(0).getValue();//出现次数最多的肯定是第一个
        for (Map.Entry<Integer,Integer> mapping : list) {
            if(max == mapping.getValue()){//所有次数最多的sum都放入list,一旦次数变了意味着变小了,就跳出
                array.add(mapping.getKey());
            }else{
                break;
            }
            //System.out.println(mapping.getKey() + ":" + mapping.getValue());  
        } 
        int[] a = new int[array.size()];
        for(int i=0;i<array.size();i++)//转数组返回
        {
            a[i] = array.get(i);
        } 
        return a;
    }
}
