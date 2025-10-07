import java.util.*;
import java.io.*;

class Meeting implements Comparable<Meeting>{
    int st, ed;
    
    public Meeting(int st, int ed){
        this.st=st;
        this.ed=ed;
    }
    
    @Override
    public int compareTo(Meeting o){
        if(o.ed == this.ed) return this.st - o.st;
        return this.ed - o.ed;
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        int N = Integer.valueOf(br.readLine());
        
        PriorityQueue<Meeting> pq = new PriorityQueue<>();
        
        while(N-- > 0){
            String[] input = br.readLine().split(" ");
            int st = Integer.valueOf(input[0]);
            int ed = Integer.valueOf(input[1]);
            pq.add(new Meeting(st, ed));
        }
        
        
        int st = 0;
        int ed = 0;
        int cnt = 0;
        while(!pq.isEmpty()){
            Meeting cur = pq.poll();
            
            if(ed <= cur.st){
                st = cur.st;
                ed = cur.ed;
                cnt++;
                // System.out.println(cur.st + " / " + cur.ed);
            }
        }
        
        
        System.out.println(cnt);
    }
}
