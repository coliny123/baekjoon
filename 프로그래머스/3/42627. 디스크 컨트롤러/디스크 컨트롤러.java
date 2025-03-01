import java.util.*;

class Process{
    int in, work;
    
    public Process(int in, int work){
        this.in=in;
        this.work=work;
    }
}

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<Process> inQue = new PriorityQueue<>((o1, o2) -> {
            if(o1.in == o2. in){
                return o1.work - o2.work;
            }else{
                return o1.in - o2.in;
            }
        });
        PriorityQueue<Process> workQue = new PriorityQueue<>((o1, o2) -> {
            if(o1.work == o2. work){
                return o1.in - o2.in;
            }else{
                return o1.work - o2.work;
            }
        });
        
        for(int[] job : jobs){
            inQue.add(new Process(job[0], job[1]));
        }
        
        int totalTime=0;
        int time=0;
        while(!inQue.isEmpty() || !workQue.isEmpty()){
            while(!inQue.isEmpty() && inQue.peek().in <= time){
                workQue.add(inQue.poll());
            }
            
            if(workQue.isEmpty()){
                time = inQue.peek().in;
            }else{
                Process cur = workQue.poll();
                totalTime += time + cur.work - cur.in;
                time += cur.work;
                // System.out.println(cur.in + " " + totalTime);
            }

        }
        
        answer = totalTime / jobs.length;
        
        
        
        return answer;
    }
}