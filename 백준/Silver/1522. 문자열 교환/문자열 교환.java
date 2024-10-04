import java.util.*;


public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        
        String str = sc.nextLine();
        
        int a_cnt=0;
        for(int i=0; i<str.length(); i++)
            if(str.charAt(i) == 'a') a_cnt++;
        
        int min = str.length();
        for(int i=0; i<str.length(); i++){
            int b_cnt = 0;
            for(int j=i; j<a_cnt+i; j++){
                if(str.charAt(j%str.length()) == 'b') b_cnt++;
            }
            min = Math.min(min, b_cnt);
        }
        
        System.out.println(min);
    }
}
