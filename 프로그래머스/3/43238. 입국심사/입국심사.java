import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        answer = parametricSearch(1, 1000000000000000000L, n, times);
        
        return answer;
    }
    
    
    public long parametricSearch(long st, long ed, int target, int[] times){
        long min = ed;
        while(st <= ed){
            long mid = (st + ed) / 2;
            
            long sum = 0;
            for(int i=0; i<times.length; i++){
                sum += mid / times[i];
            }
            
            if(sum < target){
                st = mid + 1;
            }else{
                ed = mid - 1;
                min = Math.min(min, mid);
            }
        }
        
        return min;
    }
}