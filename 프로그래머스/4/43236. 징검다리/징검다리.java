import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        Arrays.sort(rocks);
        
        answer = parametricSearch(1, distance, n, rocks);
        
        
        return answer;
    }
    
    public int parametricSearch(int st, int ed, int target, int[] rocks){
        int end = ed;
        int max = 0;
        while(st <= ed){
            int mid = (st + ed) / 2;
            
            int deleteCnt = 0;
            int before = 0;
            for(int i=0; i<rocks.length; i++){
                if(rocks[i] - before < mid){
                    deleteCnt++;
                    continue;
                }
                before = rocks[i];
            }
            if(end - before < mid) deleteCnt++;

            
            if(deleteCnt <= target){
                st = mid + 1;
                max = Math.max(max, mid);
            }else{
                ed = mid - 1;
            }
        }
        return max;
    }
}