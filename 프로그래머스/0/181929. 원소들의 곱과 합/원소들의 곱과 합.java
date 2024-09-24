class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        
        int sum=0;
        int mulp=1;
        for(int num:num_list){
            mulp *= num;
            sum += num;
        }
        
        return answer = (mulp < sum*sum) ? 1 : 0;
    }
}