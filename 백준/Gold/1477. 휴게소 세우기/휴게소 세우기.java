import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        int N = Integer.valueOf(input[0]);
        int M = Integer.valueOf(input[1]);
        int L = Integer.valueOf(input[2]);
        
        int[] positions = new int[N + 2];
        positions[0] = 0;
        positions[N + 1] = L;
        
        if (N > 0) {
            input = br.readLine().split(" ");
            for (int i = 1; i <= N; i++) {
                positions[i] = Integer.valueOf(input[i-1]);
            }
        }
        
        Arrays.sort(positions);
        
        
        System.out.println(parametricSearch(1, L-1, positions, M));
    }
    
    static int parametricSearch(int st, int ed, int[] positions, int target){
        int answer = ed - 1;
        while (st <= ed) {
            int mid = (st + ed + 1) / 2;
            
            // mid 거리로 설치할 수 있는 휴게소 개수 계산
            int count = 0;
            for (int i = 1; i < positions.length; i++) {
                int dist = positions[i] - positions[i - 1];
                count += (dist - 1) / mid;
            }
            
            if (count > target) {
                st = mid + 1;
            } else {
                answer = Math.min(answer, mid);
                ed = mid - 1;
            }
            
        }
        
        return answer;
    }
}
