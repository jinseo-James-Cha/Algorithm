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

/* This is another answer I like.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] solution(int N, int[] lastStages) {
        int nPlayers = lastStages.length;
        int[] nStagePlayers = new int[N + 2];
        for (int stage : lastStages) {
            nStagePlayers[stage] += 1;
        }

        int remainingPlayers = nPlayers;
        List<Stage> stages = new ArrayList<>();
        for (int id = 1 ; id <= N; id++) {
            double failure = (double) nStagePlayers[id] / remainingPlayers;
            remainingPlayers -= nStagePlayers[id];

            Stage s = new Stage(id, failure);
            stages.add(s);
        }
        Collections.sort(stages, Collections.reverseOrder());

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = stages.get(i).id;
        }
        return answer;
    }

    class Stage implements Comparable<Stage> {
        public int id;
        public double failure;

        public Stage(int id_, double failure_) {
            id = id_;
            failure = failure_;
        }

        @Override
        public int compareTo(Stage o) {
            if (failure < o.failure ) {
                return -1;
            }
            if (failure > o.failure ) {
                return 1;
            }
            return 0;
        }
    }
}

*/