import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        
        boolean prime[] = new boolean[N+1];
        
        get_prime(prime);
        StringBuilder sb = new StringBuilder();
        for(int i=M; i<=N; i++){
            if(!prime[i]){
                sb.append(i).append("\n");
            }
        }
        
        System.out.print(sb.toString());
    }
    
    public static void get_prime(boolean prime[]){
        prime[0] = prime[1] = true;
        for(int i=2; i<=Math.sqrt(prime.length); i++){
            if(prime[i]){
                continue;
            }
            for(int j=i*i; j<prime.length; j+=i){
                // System.out.println(j);
                prime[j] = true;
            }
        }
    }
    
}
