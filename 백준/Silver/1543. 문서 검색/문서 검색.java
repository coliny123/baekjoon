import java.util.*;

public class Main {
    public static void main(String[] args){
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        
        String str = sc.nextLine();
        String word = sc.nextLine();
        
        int cnt=0;
        for(int i=0; i<=str.length()-word.length(); i++){
            // System.out.println(i + " " + cnt);
            boolean match = true;
            for(int j=0; j<word.length(); j++){
                if(word.charAt(j) != str.charAt(j+i)) match = false;
            }
            if(match){
                cnt++;
                i += word.length()-1;
            }
        }
        
        System.out.println(cnt);
    }
}
