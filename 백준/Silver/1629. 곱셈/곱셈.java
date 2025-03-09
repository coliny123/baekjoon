import java.util.*;

public class Main {
    static int C;
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        
        int A = sc.nextInt();
        int B = sc.nextInt();
        C = sc.nextInt();
        
        System.out.println(pow(A, B));
        
    }
    
    
    static long pow(int A, int exponent){
        if(exponent == 1){
            return A % C;
        }
        
        long temp = pow(A, exponent / 2);
        
        if(exponent % 2 == 1){
            return (temp * temp % C) * A % C;
        }
        return temp * temp % C;
    }
}
