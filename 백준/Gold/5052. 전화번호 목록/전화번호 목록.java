import java.util.*;


public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        
        int T= sc.nextInt();
        
        while(T-- > 0){
            int N = sc.nextInt();
            String[] numbers = new String[N];
            sc.nextLine();
            for(int i=0; i<N; i++){
                numbers[i] = sc.nextLine();
            }
            
            Arrays.sort(numbers);
            
            boolean flag = false;
            for(int i=1; i<N; i++){
                if(numbers[i].startsWith(numbers[i-1])){
                    flag = true;
                    break;
                }
            }
            
            if(flag) System.out.println("NO");
            else System.out.println("YES");
        }
        
    }
}
