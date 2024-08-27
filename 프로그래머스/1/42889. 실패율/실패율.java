// stages의 숫자들은 이미 전단계의 스테이지를 클리어했다.
// 실패율 = stages 숫자가 같거나 큰 숫자들 / 해당 stage
import java.util.HashMap;

class Solution {
    public int[] solution(int N, int[] stages) {
        
        // stage 별 도전자 수 
        int[] challenger = new int[N + 2];
        for(int i = 0; i < stages.length; i++){
            challenger[stages[i]] += 1;
        }
        
        // stage 별 실패한 사용자 수 계산
        HashMap<Integer, Double> fails = new HashMap<>();
        double total = stages.length;
        
        // 각 stage를 순회하며, 실패율 계산
        for(int i = 1; i<= N; i++) {
            if(challenger[i] == 0) {
                fails.put(i, 0.);
            }else {
                fails.put(i, challenger[i] / total); 
                total -= challenger[i];
            }
        }
        
        return fails.entrySet().stream().sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue())).mapToInt(HashMap.Entry::getKey).toArray();
    }
}