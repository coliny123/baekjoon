import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int length = citations.length;
        
        Arrays.sort(citations);
        System.out.println(Arrays.toString(citations));
        
        for(int i=0; i<length; i++){
			int h = length - i; // 인용된 논문의 수
			
			if(citations[i] >= h) {
				answer = h;
				break;
			}
        }


        return answer;
    }
}