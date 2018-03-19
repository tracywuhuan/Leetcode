// https://leetcode.com/problems/basic-calculator-ii/discuss/63003/Share-my-java-solution
public class Solution {
public int calculate(String s) {
    int len;
    s= s.replace(" ","");
    if(s==null || (len = s.length())==0) return 0;
    Stack<Integer> stack = new Stack<Integer>();
    int num = 0;
    char sign = '+';
    for(int i=0;i<len;i++){
        if(Character.isDigit(s.charAt(i))){
            num = num*10+s.charAt(i)-'0';
        }
        if((!Character.isDigit(s.charAt(i))) || i==len-1){
            if(sign=='-'){
                stack.push(-num);// 转成加法
            }
            if(sign=='+'){
                stack.push(num);
            }
            if(sign=='*'){
                stack.push(stack.pop()*num);//先算乘
            }
            if(sign=='/'){
                stack.push(stack.pop()/num);//先算除
            }
            sign = s.charAt(i);
            num = 0;
        }
    }

    int re = 0;
    for(int i:stack){
        re += i;
    }
    return re;
}

}

