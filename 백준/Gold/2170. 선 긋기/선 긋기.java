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
        if(st == o.st){
            return o.ed - ed;
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
        
        Node[] lines = new Node[N];
        
        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            int st = Integer.valueOf(input[0]);
            int ed = Integer.valueOf(input[1]);
            lines[i] = new Node(st, ed);
        }
        
        Arrays.sort(lines);
        
        
        int sum = 0;
        int st = lines[0].st;
        int ed = lines[0].ed;
        for(Node line : lines){
            // 새로운 선분 시작
            if(line.st > ed){
                sum += (ed - st);
                st = line.st;
                ed = line.ed;
            }
            
            // 선분 확장
            if(ed < line.ed){
                ed = line.ed; 
            }
        }
        sum += (ed - st);
        
        System.out.println(sum);
    }
}
