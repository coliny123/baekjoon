import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
        
        int round = 0;
        int answer = -1;
        while(N >= 2){
            round++;
            if((A+1)/2 == (B+1)/2){
                answer = round;
                break;
            }
            
            A = (A+1)/2;
            B = (B+1)/2;
            N = (N+1)/2;
        }
        
        System.out.println(answer);
    }
}
