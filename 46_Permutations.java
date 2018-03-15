//https://leetcode.com/problems/permutations/description/
class Solution {
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> array = new ArrayList<>();
        List<Integer> line = new ArrayList<Integer>();
    	if(nums.length<=0){
    		return array;
    	}
    	line.add(nums[0]);
    	array.add(line);
        //System.out.println(array);
        for(int i=1;i<nums.length;i++){//循环数组
        	int current_row_size = array.size();//当前结果多少行
        	int current_col_size = array.get(0).size();//当前结果多少列
            for(int j=0;j<current_row_size;j++){//row loop
            	for(int k=0;k<=current_col_size;k++){//col loop 对每一行进行插入操作，n列，就插入n+1次
                    List<Integer> cline = new ArrayList<Integer>(Arrays.asList(new Integer[array.get(j).size()]));
                   //复制进行插入操作的那一列
            		Collections.copy(cline, array.get(j));
                    if(k<cline.size()){
                       cline.add(k, nums[i]); 
                    }else{
                        cline.add(nums[i]);
                    }
            		array.add(cline);//最终的插入结果放入array
                   // System.out.println(cline);
                   // System.out.println(array);
            	}
            }
            //System.out.println(array);
            for (int m = 0; m < current_row_size; m++) {//把已经没用的前几列删除
                array.remove(0);
			}
        }
        return array;
    }
}
