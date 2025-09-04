import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        
        int N = Integer.valueOf(sc.nextInt());
        
        for(int i=0; i<N; i++){
            int lv = Integer.valueOf(sc.nextInt());
            
            if(lv < 250){
                System.out.print(4 + " ");
            }else if(lv < 275){
                System.out.print(3 + " ");
            }else if(lv < 300){
                System.out.print(2 + " ");
            }else{
                System.out.print(1 + " ");
            }
        }
    }
}
