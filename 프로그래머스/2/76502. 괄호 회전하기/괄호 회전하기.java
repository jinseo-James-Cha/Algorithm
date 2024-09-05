// 길이만큼 왼쪽으로 회전.
// 그 후, 올바른 괄호 문자열인지 확인.
// 회전별 올바른 괄호 문자열 완성의 수.

// 처음 체크는 Index 0 ~ 6
// 두번째 체크는 Index 1 ~ 7 검사하자.
// 마지막 체크는 Index 문자열의 길이 ~ 문자열의 수 * 2 -1 

// 총 문자열의 갯수는 주어진 s x 2
import java.util.HashMap;
import java.util.ArrayDeque;

class Solution {
    public int solution(String s) {
        // 2. 확인하기쉽도록 hashmap을 이용하자.
        // 3. <닫히는괄호, 열리는괄호>
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        
        int length = s.length();    
        int answer = 0;
        s += s;
        
        A:for(int i = 0; i < length; i++) {
            ArrayDeque<Character> stack = new ArrayDeque<>();
            
            for(int j = i; j < i + length; j++) {
                char c = s.charAt(j);
                
                // 1. 열리는 괄호인지 닫히는 괄호인지 찾아보자.
                // 열리는 괄호 체크 후 Stack에 Push
                if(!map.containsKey(c)){
                    stack.push(c);
                }else {
                    // 4. 닫히는 괄호
                    // 4.1 스택이 비어이으면 닫히는 괄호는 불필요 -> continue
                    // 4.2 혹은, 스택에서 해당 닫히는 괄호를 key로 여는 괄호 value를 가져왔을때 똑같지않으면 -> continue
                    // 왜냐하면, 괄호체크는 닫히는 괄호는 가장 가까이 똑같은 모양의 여는괄호가 있어야 되기때문에.
                    if(stack.isEmpty() || !stack.pop().equals(map.get(c))) {
                        continue A;
                    }
                }
            }
            
            if(stack.isEmpty()) {
                answer++;
            }
        }
        
        return answer;
    }
}