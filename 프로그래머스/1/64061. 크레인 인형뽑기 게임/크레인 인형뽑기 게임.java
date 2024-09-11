import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        /*
        * 정사각형 N X N
        
        * 뽑은 인형을 담을 stack과 맨 마지막(Peek) 과 지금 뽑는 인형이 같을 때 Pop하기
        */
        int boardSize = board.length;
        int moveSize = moves.length;
        
        int removedTimes = 0;
        
        Stack<Integer> basket = new Stack<>();
        for(int i = 0; i < moveSize; i++) {
            int pickNum = moves[i];
            
            for(int j = 0; j < boardSize; j++) {
                int checkNum = board[j][pickNum-1];
                
                if(checkNum != 0) {
                    if(!basket.isEmpty() && basket.peek() == checkNum) {
                        basket.pop();
                        removedTimes++;
                    }else{
                        basket.push(checkNum);
                    }
                
                    board[j][pickNum-1] = 0;
                    break;
                }
            }
        }
        return removedTimes * 2;
    }
}