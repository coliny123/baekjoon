import java.util.*;

class Node{
    long idx;
    int cnt;
    
    public Node(long idx, int cnt){
        this.idx=idx;
        this.cnt=cnt;
    }
}

public class Main {
    public static long A;
    public static long B;
    public static int answer=Integer.MAX_VALUE;
    public static Queue<Node> q = new LinkedList<>();
    
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        A = sc.nextLong();
        B = sc.nextLong();
        
        q.add(new Node(A, 0));
        BFS();
        
        if(answer==Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(answer+1);
        }
        
    }
    
    public static void BFS(){
        while(!q.isEmpty()){
            Node curN = q.poll();
            if(curN.idx == B){
                answer = Math.min(answer, curN.cnt);
            }
            
            String curStr = String.valueOf(curN.idx);
            if((curN.idx*10+1) <= B){
                q.add(new Node(curN.idx*10+1, curN.cnt+1));
            }
            if((curN.idx*2) <= B){
                q.add(new Node(curN.idx*2, curN.cnt+1));
            }
        }
    }
}