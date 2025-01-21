import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    int w, v;
    
    public Node(int w, int v){
        this.w=w;
        this.v=v;
    }
    
    @Override
    public int compareTo(Node o){
        if(w == o.w) return v-o.v;
        else return w-o.w;
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.valueOf(input[0]);
        int K = Integer.valueOf(input[1]);
        
        int[] bags = new int[K+1];
        
        Node[] things = new Node[N];
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            things[i] = new Node(Integer.valueOf(input[0]), Integer.valueOf(input[1]));
        }
        
        Arrays.sort(things);
        
        for(int i=0; i<N; i++){
            for(int weight=K; weight>=0; weight--){
                Node cur = things[i];
                if(weight < cur.w) break;
                bags[weight] = Math.max(bags[weight], bags[weight-cur.w] + cur.v);
            }
        }
        
        int max = 0;
        for(int i=0; i<=K; i++){
            max = Math.max(max, bags[i]);
        }
        System.out.println(max);
    }
}
