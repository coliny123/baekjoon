import java.util.*;

public class Main {
    public static int M;
    
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        
        int lt = 1;
        int rt = 1000000000;
        
        boolean find = false;
        int min = rt-1;
        while(lt <= rt){
            int mid = (lt + rt) / 2;
            
            int tempCnt = check(mid);
            if(tempCnt >= M){
                if(tempCnt == M){
                    find = true;
                    min = Math.min(min, mid);
                }
                rt = mid-1;
            }else{
                lt = mid+1;
            }
        }
        
        if(find){
            System.out.println(min);
        }else{
            System.out.println(-1);
        }
        
    }
    
    public static int check(int mid){
        int cnt = 0;
        for(int i=5; i<=mid; i*=5){
            cnt+=(mid/i);
        }
        return cnt;
    }
}


// 1
// 2
// 6
// 24
// 120            5!
// 760
// 5060
// 40320
// 362880
// 3628800        10!
// 1307674368000  15!