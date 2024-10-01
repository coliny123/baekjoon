import java.util.*;

public class Main {
    
    public static int N;
    public static char[] arr;
    public static char[] answer;
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        sc.nextLine();
        while(t-- > 0){
            String row = sc.nextLine();
            N = row.length();
            arr = row.toCharArray();
            Arrays.sort(arr);
            answer = new char[N];
            visited = new boolean[N];
            BT(0);
        }
        
        System.out.print(sb.toString());
    }
    
    public static void BT(int depth){
        if(depth == N){
            for(int i=0; i<arr.length; i++){
                sb.append(answer[i]);
            }
            sb.append("\n");
            return;
        }
        
        char before = '1';
        for(int i=0; i<N; i++){
            if(!visited[i]){
                if(before != arr[i]){
                    visited[i] = true;
                    answer[depth] = arr[i];
                    before = arr[i];
                    BT(depth+1);
                    visited[i] = false;
                }
            }
        }
    }
}
