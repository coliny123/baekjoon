import java.util.*;

// 4000000000
// 2000000000 + 
public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int Sx = sc.nextInt();
        int Sy = sc.nextInt();
        int Ex = sc.nextInt();
        int Ey = sc.nextInt();
        
        int answer = 0;
        long min=Long.MAX_VALUE;
        for(int i=1; i<=N; i++){
            int T = sc.nextInt();
            int Px = Sx;
            int Py = Sy;
            long sum=0;
            while(T-- > 0){
                int Tx = sc.nextInt();
                int Ty = sc.nextInt();
                
                sum += (long)Math.abs(Px - Tx) + (long)Math.abs(Py - Ty);
                Px = Tx;
                Py = Ty;
            }
            sum += (long)Math.abs(Px - Ex) + (long)Math.abs(Py - Ey);
            if(min > sum){
                min = sum;
                answer = i;
            }
        }
        
        System.out.println(answer);
        
    }
}
