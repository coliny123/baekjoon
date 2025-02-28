import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<commands.length; i++){
            int st = commands[i][0] - 1;
            int ed = commands[i][1] - 1;
            int target = commands[i][2] - 1;

            int[] sortingArr = Arrays.copyOfRange(array, st, ed+1);
            // System.out.println(Arrays.toString(sortingArr));   
            Arrays.sort(sortingArr);
            
            list.add(sortingArr[target]);
        }
        
        answer = list.stream().mapToInt(i -> i).toArray();
        
        return answer;
    }
}