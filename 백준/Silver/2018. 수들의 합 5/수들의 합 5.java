import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        int cnt = 0;
        int lt = 1;
        int rt = 1;
        int sum = 1;
        while(lt <= rt){
            if(sum == N){
                cnt++;
            }
            
            if(N >= sum){
                sum += ++rt;
            }else{
                sum -= lt++;
            };
        }        
        
        System.out.println(cnt);
    }
}
