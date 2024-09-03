import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        
        int answer=0;
        int count=0;
        for(int i=1; i<M-1; i++){
            if(str.charAt(i-1)=='I' && str.charAt(i)=='O' && str.charAt(i+1)=='I'){
                count++;
                if(count == N){
                    count--;
                    answer++;
                }
                i++;
            }else{
                count=0;
            }
            
        }
        
        System.out.println(answer);
    }
}
