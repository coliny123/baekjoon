import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.valueOf(br.readLine());
        
        int[] nums = new int[N];
        int[] sum = new int[N+1];
        
        String[] input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            nums[i] = Integer.valueOf(input[i]);
        }
        
        for(int i=1; i<=N; i++){
            sum[i] = sum[i-1] + nums[i-1];
        }
        
        int M = Integer.valueOf(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        while(M-- > 0){
            input = br.readLine().split(" ");
            int s = Integer.valueOf(input[0])-1;
            int e = Integer.valueOf(input[1]);
            
            sb.append(sum[e] - sum[s]).append("\n");
        }
        
        System.out.print(sb);
    }
}
