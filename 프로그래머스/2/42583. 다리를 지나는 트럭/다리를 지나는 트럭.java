import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> waitingQ = new LinkedList<>();
        Queue<Integer> bridgeQ = new LinkedList<>();
        Queue<Integer> timeQ = new LinkedList<>();
        
        for(int i=0; i<truck_weights.length; i++){
            waitingQ.add(truck_weights[i]);
        }
        
        int time=0;
        int exit=0;
        int weigthSum=0;
        // 대기 트럭이 다 나가야 종료
        while(exit < truck_weights.length){
            time++;
            // 시간이 다 지난(다리를 다 건넜다면) exit 증가 & 다리Queue에서 제거 + 시간Queue에서 제거
            if(!timeQ.isEmpty() && timeQ.peek() == bridge_length){
                timeQ.poll();
                weigthSum -= bridgeQ.poll();
                exit++;
            }
            
            // 대기 트럭 있으면 weight과 비교해서 다리에 들어갈 수 있는지 없는지 확인
            if(!waitingQ.isEmpty() && weigthSum + waitingQ.peek() <= weight && bridgeQ.size() < bridge_length){
                int truck = waitingQ.poll();
                bridgeQ.add(truck);
                weigthSum += truck;
                timeQ.add(0);
            }
            
            // 핵심! : 다리에서 움직이는 시간 Queue로 전부 1초씩 증가시켜줌
            for(int i=0; i<timeQ.size(); i++){
                timeQ.add(timeQ.poll()+1);
            }
            
        }
        
        
        return time;
    }
}