import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        
        long[] A = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }
        
        long left = 1, right = 1500000000L;
        long ans = Long.MAX_VALUE;
        
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long sum = mid * (mid + 1) / 2;
            
            for (int i = 0; i < N - 1; i++) {
                long diff = Math.min(mid, A[i + 1] - A[i]);
                sum += mid * diff - (diff - 1) * diff / 2;
            }
            
            if (sum >= K) {
                ans = Math.min(ans, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        System.out.println(ans);
    }
}
