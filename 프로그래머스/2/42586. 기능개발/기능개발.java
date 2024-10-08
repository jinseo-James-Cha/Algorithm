import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> answer = new ArrayDeque<>();
        
        // 프로그레스에서 스피드를 이용해 각 작업당 얼마나 걸릴지 소요일을 계산해본다.
        int n = progresses.length;
        int[] daysLeft = new int[n];
        for(int i = 0; i < n; i++) {
            daysLeft[i] = (int)Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }
        
        // 앞에 작업이 기준이기에 첫 기준점을 잡고 loop를 통해 몇개나 포함할수있는지 계산한다.
        int count = 0;
        int maxDay = daysLeft[0];
        for(int i = 0; i < n; i++) {
            if(daysLeft[i] <= maxDay) {
                count++;
            }else {
                // 만약 앞에 작업 소요일보다 뒤 작업 소요일이 적지않다면
                
                // 그렇다면 앞까지의 count를 정답에 넣고
                // 내가 큼을 확인했기떄문에 count는 1로시작하고
                // 기준일을 앞보다 큰 소요일로 변경한다.
                answer.add(count);
                count = 1;
                maxDay = daysLeft[i];
            }
        }
        
        answer.add(count);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}