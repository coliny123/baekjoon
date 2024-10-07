import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = {};
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int a : score){
            if(pq.size()<k){
                pq.add(a);
            }else{
                if(pq.peek() < a){
                    pq.poll();
                    pq.add(a);
                }
            }
            list.add(pq.peek());
        }
        
        answer = list.stream().mapToInt(i->i).toArray();
        
        return answer;
    }
}