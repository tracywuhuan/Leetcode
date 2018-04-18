//https://leetcode.com/problems/permutation-sequence/description/
//
class Solution {
    public String getPermutation(int n, int k) {//核心思想第k个数，算出第一个数字是什么，k减去相应的值，然后继续算第二数字是什么。。。
        int[] factorial = new int[n+1];
        List<Integer> numbers = new ArrayList<Integer>();
        factorial[0] = 1;
        StringBuilder result = new StringBuilder();
       
        for(int i =1;i<=n;i++){//1,2,6...
            factorial[i] = factorial[i-1]*i;
        }
        for(int i =1;i<=n;i++){//1,2,3,4....
            numbers.add(i);
        }
        k--;
        for(int i = 1;i<=n;i++){
            int section = k/factorial[n-i];//在第几个section里面，比如k=3，n=3，那么第k个数肯定在2[1,3]这个里面，因为3/factorial[2] =1
            result.append(String.valueOf(numbers.get(section)));//把第一个数存起来，上面的例子就是2
            numbers.remove(section);//删除出现了的那个数，上面例子就是2
            k=k-section*factorial[n-i];//k需要减掉前面section,上面例子就是1[2,3]这么多需要减掉
        }
        return result.toString();
    }
}
