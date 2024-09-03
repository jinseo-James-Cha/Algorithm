// 괄호가 바르게 짝지어야 하기에 길이는 반드시 "짝수"여야함.

import java.util.Stack;

class Solution {
    boolean solution(String s) {
        if(s.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        for(char c : charArray){
            if(c == '('){
                stack.push(c);
                continue;
            }
            
            if(stack.isEmpty() || stack.pop() == c ){
                return false;
            }
        }
        
        return stack.isEmpty();
    }
}