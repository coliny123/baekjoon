import java.util.*;

public class Main {
    public static Set<Character> moeum = Set.of('a', 'e', 'i', 'o', 'u');
    
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        
        while(true){
            String input = sc.nextLine();
            if(input.equals("end")) break;
            
            if(check(input)){
                System.out.println("<" + input + "> is acceptable.");
            }else{
                System.out.println("<" + input + "> is not acceptable.");
            }
        }
    }
    
    
    public static boolean check(String pwd){
        boolean moeum_flag = false;
        boolean seq_flag = false;
        for(int i=0; i<pwd.length(); i++){
            if(moeum.contains(pwd.charAt(i))) moeum_flag = true;
            //3번
            if(i != 0 && pwd.charAt(i-1) == pwd.charAt(i)){
                if(pwd.charAt(i) != 'e' && pwd.charAt(i) !='o'){
                    return false;
                }
            }
            //2번
            if(i > 1 && moeum.contains(pwd.charAt(i-2)) && moeum.contains(pwd.charAt(i-1)) && moeum.contains(pwd.charAt(i))){
                return false;
            }
            if(i > 1 && !moeum.contains(pwd.charAt(i-2)) && !moeum.contains(pwd.charAt(i-1)) && !moeum.contains(pwd.charAt(i))){
                return false;
            }
            
        }
        // 1번
        if(!moeum_flag) return false;
        
        return true;
    }
}
