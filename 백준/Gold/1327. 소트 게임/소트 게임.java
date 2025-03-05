import java.util.*;
import java.io.*;

class Node {
    String str;
    int count;
    
    public Node(String str, int count){
        this.str = str;
        this.count = count;
    }
}

public class Main {
    static int N, K;
    static String answer = "";
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        N = Integer.valueOf(input[0]);
        K = Integer.valueOf(input[1]);
        
        StringBuilder sb = new StringBuilder();
        input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            sb.append(input[i]);
        }
        
        String init = sb.toString();
        sb.setLength(0);
        for(int i=1; i<=N; i++){
            sb.append(i);
        }
        
        answer = sb.toString();
        
        System.out.println(bfs(init));
        
        
    }
    
    static int bfs(String init){
        Queue<Node> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.add(new Node(init, 0));        
        visited.add(init);
        
        int cnt = -1;
        while(!q.isEmpty()){
            Node cur = q.poll();
            
            if(cur.str.equals(answer)){
                cnt = cur.count;
                break;
            }
            
            for(int i=0; i <= N-K; i++){
                char[] arr = cur.str.toCharArray();
                for(int j=0; j < K/2; j++){
                    char tmp = arr[i+j];
                    arr[i+j] = arr[i-j+K-1];
                    arr[i-j+K-1] = tmp;
                }
                String result = String.valueOf(arr);
                if(!visited.contains(result)){
                    q.add(new Node(result, cur.count+1));
                    visited.add(result);
                }
            }
        }
        return cnt;
    }
}
