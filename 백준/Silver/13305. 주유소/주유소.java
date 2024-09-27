import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        long dists[] = new long[n-1];
        int costs[] = new int[n];
        
        for(int i=0; i<n-1; i++){
            dists[i] = sc.nextInt();
        }
        
        long sum=0;
        long min = Integer.MAX_VALUE;
        for(int i=0; i<n-1; i++){
            int cost = sc.nextInt();
            // System.out.println(min + " " + cost + " " + sum);
            if(min >= cost){
                min = cost;
            }
            sum += dists[i]*min;
        }
        
        

        System.out.println(sum);
    }
}
