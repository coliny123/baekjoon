import java.util.*;

public class Main {
    public static void main(String[] args){
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        // false가 소수
        boolean[] prime = new boolean[N+1];
        prime[0] = prime[1] = true;
        for(int i=2; i<=Math.sqrt(prime.length); i++){
            if(prime[i]){
                continue;
            }
            for(int j=i*i; j<prime.length; j+=i){
                prime[j] = true;
            }
        }
        
        List<Integer> nums = new ArrayList<>();
        for(int i=0; i<=N; i++){
            if(!prime[i]) nums.add(i);
        }
        
        int sum = 0;
        int count = 0;
        int lt = 0;
        int rt = 0;
        while(lt < nums.size()) {
            // 현재 합이 N보다 작고 rt가 범위 내에 있으면 rt 이동
            if(sum < N && rt < nums.size()) {
                sum += nums.get(rt++);
            }else {  // 그 외의 경우 lt 이동
                sum -= nums.get(lt++);
            }
            
            if(sum == N) {
                count++;
            }
        }
        
        System.out.println(count);
        
    }
}
