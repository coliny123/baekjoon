import java.util.*;

public class Main {
    public static boolean flag=false;
    public static HashSet<Long> set = new HashSet<>();
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        
        long N = sc.nextLong();
        long M = sc.nextLong();
        
        DFS(N, M);
        if(flag){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
    
    public static void DFS(long st, long M){
        if(st == M){
            flag = true;
            return;
        }
        if(st < M || set.contains(st)){
            return;
        }
        
        set.add(st);
        
        if(st%2==0){
            DFS(st/2, M);
            DFS(st/2, M);
        }else{
            DFS(st/2, M);
            DFS(st/2+1, M);
        }
    }
}
