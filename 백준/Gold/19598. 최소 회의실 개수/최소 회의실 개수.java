import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    int st, ed;
    
    public Node(int st, int ed){
        this.st=st;
        this.ed=ed;
    }    
    
    @Override
    public int compareTo(Node o){
        if(st == o.ed){
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
        
        Node[] meeting = new Node[N];
        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            int st = Integer.valueOf(input[0]);
            int ed = Integer.valueOf(input[1]);
            meeting[i] = new Node(st, ed);
        }
        
        Arrays.sort(meeting);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        pq.add(meeting[0].ed);
        for(int i=1; i<N; i++){
            if(meeting[i].st >= pq.peek()){
                pq.poll();
            }
            
            pq.add(meeting[i].ed);
        }
        
        System.out.println(pq.size());
    }
}
