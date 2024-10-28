import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[][] arr = new int[N][2];
        
        sc.nextLine();
        int maxHight = 0;
        for(int i=0; i<N; i++){
            String[] input = sc.nextLine().split(" ");
            int idx = Integer.valueOf(input[0]);
            int high = Integer.valueOf(input[1]);
            
            arr[i] = new int[]{idx, high};
            maxHight = Math.max(maxHight, high);
        }
        
        Arrays.sort(arr, (o1, o2) -> (o1[0] - o2[0]));
        
        // left
        long sum=0;
        int[] lt = arr[0];
        for(int i=1; i<N; i++){
            if(lt[1] < arr[i][1]){
                sum += lt[1] * (arr[i][0] - lt[0]);
                lt = arr[i];
                if(lt[1] == maxHight) break;
            }
        }
        
        // right
        int[] rt = arr[N-1];
        for(int i=N-2; i>=0; i--){
            if(rt[1] < arr[i][1]){
                sum += rt[1] * (rt[0] - arr[i][0]);
                rt = arr[i];
                if(rt[1] == maxHight) break;
            }
        }
        
        sum += (rt[0] - lt[0] + 1) * maxHight;
        
        System.out.println(sum);
    }
}
