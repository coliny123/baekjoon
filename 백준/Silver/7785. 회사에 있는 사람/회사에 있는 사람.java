import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        TreeSet<String> set = new TreeSet<>(Collections.reverseOrder());
        
        sc.nextLine();
        while(n-- > 0){
            String name = sc.next();
            String state = sc.next();
            
            if(state.equals("enter")){
                set.add(name);
            }else{
                if(set.contains(name)) set.remove(name);
            }
        }
        
        for(String name:set) System.out.println(name);
    }
}
