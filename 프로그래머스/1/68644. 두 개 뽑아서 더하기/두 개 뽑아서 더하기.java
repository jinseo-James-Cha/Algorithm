// 1. get all possible cases to pick two numbers in the array
// for 1's cases, insert them into a array and remove duplicates
// order ascending and return the answer
import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 0; i < numbers.length - 1; i++) {
            for(int j = i+1; j < numbers.length; j++ ){
                int sum = numbers[i] + numbers[j];
                set.add(sum);
            }
        }
        
        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}