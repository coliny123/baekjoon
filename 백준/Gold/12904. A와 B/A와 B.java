import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        
        String A = sc.nextLine();
        String B = sc.nextLine();
        
        StringBuilder bSb = new StringBuilder();
        for(int i=0; i<B.length(); i++){
            bSb.append(B.charAt(i));
        }
        
        while(bSb.length() > A.length()){
            if(bSb.charAt(bSb.length()-1) == 'B'){
                bSb.setLength(bSb.length()-1);
                bSb.reverse();
            }else{
                bSb.setLength(bSb.length()-1);
            }
        }
        
        if(A.equals(bSb.toString())) System.out.println(1);
        else System.out.println(0);
        
    }
}
