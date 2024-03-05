class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        for(int a=0; a<queries.length; a++){
            int s = queries[a][0];
            int e = queries[a][1];
            int k = queries[a][2];
            int min = 1000000;
            for(int i = s; i<=e; i++){
                if(arr[i] > k){
                    if(min>arr[i]){
                        min = arr[i];
                    }
                }   
            }
            if(min == 1000000){
                min = -1;
            }
            answer[a] = min;
        }
        return answer;
    }
}