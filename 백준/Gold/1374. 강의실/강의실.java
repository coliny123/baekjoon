import java.util.*;
import java.io.*;

class Subject implements Comparable<Subject>{
    int num, st, ed;
    
    public Subject(int num, int st, int ed){
        this.num=num;
        this.st=st;
        this.ed=ed;
    }
    
    @Override
    public int compareTo(Subject o){
        if(st == o.st){
            return ed - o.ed;
        }else{
            return st - o.st;
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.valueOf(br.readLine());
        
        Subject[] subjects = new Subject[N];
        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            int num = Integer.valueOf(input[0]);
            int st = Integer.valueOf(input[1]);
            int ed = Integer.valueOf(input[2]);
            
            subjects[i] = new Subject(num, st, ed);
        }
        
        Arrays.sort(subjects);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int max = 0;
        for(int i=0; i<N; i++){
            while (!pq.isEmpty() && pq.peek() <= subjects[i].st){
                pq.poll();
            }
            pq.add(subjects[i].ed);
            max = Math.max(max, pq.size());            
        }
        
        System.out.println(max);
    }
}
