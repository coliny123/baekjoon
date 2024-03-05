class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = {};
        for(int i=0; i<queries.length; i++){
            int[] query = queries[i];
            int temp = arr[query[0]];
            arr[query[0]] = arr[query[1]];
            arr[query[1]] = temp;
        }
        answer = arr;
        return answer;
    }
}