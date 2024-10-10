import java.util.ArrayDeque;
import java.util.Arrays;

/*
 * Approach
 * Goal을 queue를 사용해서 하나씩 뽑아내고 이 값이 card1의 첫번째 값인지? card2의 첫번째 값인지 확인한다.
 * 두쪽 모두에게 발견되지 않은 goal의 값이 존재했을때는 바로 No리턴,
 * goal이 empty일때 Yes리턴
 
 * card1 empty , card2까지 empty였을때 TRUE리턴하는지 확인하자
 */

/*
 * Questions to myself
 * 1. ArrayDeque를 이용하고싶은데 스트링배열을 어떻게 변환하지? Arrays.asList(배열)
 * 2. ArrayDeque에서 빼내는 방법이 아니고 첫번째 나올 값만 확인하는 메소드가 있나? .peekFirst()
 */

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        // Q1 answer
        ArrayDeque<String> cardsDeque1 = new ArrayDeque<>(Arrays.asList(cards1));
        ArrayDeque<String> cardsDeque2 = new ArrayDeque<>(Arrays.asList(cards2));
        ArrayDeque<String> goalDeque = new ArrayDeque<>(Arrays.asList(goal));
        
        while(goalDeque.size() > 0) {
            String checkGoal = goalDeque.pollFirst();
            
            // Q2 answer
            if(checkGoal.equals(cardsDeque1.peekFirst())) {
                cardsDeque1.pollFirst();
            }else if(checkGoal.equals(cardsDeque2.peekFirst())) {
                cardsDeque2.pollFirst();
            }else {
                return "No";
            }
        }
        
        return "Yes";
    }
}