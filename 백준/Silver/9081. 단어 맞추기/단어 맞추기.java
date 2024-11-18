import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        sc.nextLine();
        while(N-- > 0){
            String input = sc.nextLine();
            char[] ch = input.toCharArray();
            
            int idx1 = -1;
            int idx2 = 0;
            
            // 1. 뒤에서 부터 앞으로 오름차순으로 진행 중 깨지는 부분 idx1 찾기
            for(int i=ch.length-1; i>0; i--){
                if(ch[i-1] < ch[i]){
                    idx1 = i-1;
                    break;
                }
            }
            
            // 2. 만약에 idx1이 -1이면 = 전체가 내림차순이면 마지막 단어 -> 종료 조건
            if(idx1 == -1){
                System.out.println(input);
                continue;
            }
            
            
            // 3. 다시 뒤에서 부터 확인하면서 [idx1]보다 큰 값 위치 저장
            for(int i=ch.length-1; i>=0; i--){
                if(ch[idx1] < ch[i]){
                    idx2 = i;
                    break;
                }
            }
            
            // 4. idx1 <-> idx2 스왑
            char temp = ch[idx1];
            ch[idx1] = ch[idx2];
            ch[idx2] = temp;
            
            // 5. idx1 뒷 부분 정렬하기
            Arrays.sort(ch, idx1+1, ch.length);
            System.out.println(String.valueOf(ch));
            
        }
    }
}
