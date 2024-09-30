import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        int nums[] = new int[N];
        for(int i=0; i<N; i++){
            nums[i] = sc.nextInt();
        }
        
        int sum = 0;
        for(int i=0; i<K; i++){
            sum += nums[i];
        }
        
        int cnt=1;
        int max=sum;
        for(int i=1; i<=N-K; i++){
            sum -= nums[i-1];
            sum += nums[i+K-1];
            if(sum > max){
                max = sum;
                cnt = 1;
            }else if(sum == max){
                cnt++;
            }
        }
        
        if(max == 0){
            System.out.println("SAD");
        }else{
            System.out.println(max);
            System.out.println(cnt);
        }
    }
}
