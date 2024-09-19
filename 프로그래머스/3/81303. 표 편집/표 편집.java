import java.util.Arrays;
import java.util.Stack;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        // 삭제된 행의 인덱스를 저장하는 스택
        Stack<Integer> deleted = new Stack<>();
        
        // 각 행을 기준으로 연산에 따른 위치를 표시하기 위한 배열
        int[] up = new int[n+2];
        int[] down = new int[n+2];
        
        for(int i = 0; i < n + 2; i++) {
            up[i] = i - 1;
            down[i] = i + 1;
        }
        
        // 현재 위치를 나타내는 인덱스
        k++;
        
        // 주어진 명령어 처리
        for(String c : cmd) {
            if(c.startsWith("C")) {
                // 삭제
                deleted.push(k);
                
                up[down[k]] = up[k];
                down[up[k]] = down[k];
                
                k = n < down[k] ? up[k] : down[k];
            }else if(c.startsWith("Z")) {
                // 되돌리기
                int restore = deleted.pop();
                down[up[restore]] = restore;
                up[down[restore]] = restore;
            }else {
                String[] s = c.split(" ");
                int x = Integer.parseInt(s[1]);
                
                for(int i = 0; i < x; i++) {
                    k = s[0].equals("U") ? up[k] : down[k];
                }
            }
        }
        
        
        //삭제된 행의 위치를 X, 그렇지않으면 O 로 반환
        char[] answer = new char[n];
        Arrays.fill(answer, 'O');
        
        for(int i : deleted) {
            answer[ i - 1] = 'X';
        }

        return new String(answer);
    }
}