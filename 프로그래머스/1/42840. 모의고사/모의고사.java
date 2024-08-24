// repetitions
// 1 -> 12345 | 2 -> 21232425 | 3 -> 3311224455

// loop each anwer to the pattern
// create int array to save scores, and increase score when it matches
// get the max score from int array
// find which index has max number and save in ArrayList to sort


import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[][] patterns = {
            {1,2,3,4,5},
            {2,1,2,3,2,4,2,5},
            {3,3,1,1,2,2,4,4,5,5}
        };
        
        int[] scores = new int[3];
        
        for(int i = 0; i < answers.length; i++) {
            for(int j = 0; j < patterns.length; j++){
                if(answers[i] == patterns[j][i % patterns[j].length]) {
                    scores[j]++;
                }
            }
        }
        
        int maxScore = Arrays.stream(scores).max().getAsInt();
        
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = 0; i < scores.length; i++) {
            if(maxScore == scores[i]) {
                answer.add(i+1);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}