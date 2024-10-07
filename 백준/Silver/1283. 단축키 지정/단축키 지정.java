import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        Set<Character> set = new HashSet<>();
        sc.nextLine();
        while(N-- > 0){
            String input = sc.nextLine();
            String[] strArr = input.split(" ");
            
            int idx=-1;
            int stack=0;
            for(int i=0; i<strArr.length; i++){
                Character key = strArr[i].substring(0,1).toUpperCase().charAt(0);
                // System.out.println("1 " + key);
                if(!set.contains(key)){
                    set.add(key);
                    idx=stack;
                    break;
                }
                stack += strArr[i].length()+1;
            }
            
            if(idx==-1){
                for(int i=0; i<input.length(); i++){
                    if(input.charAt(i) == ' ') continue;
                    Character key = input.substring(i,i+1).toUpperCase().charAt(0);
                    // System.out.println("2 " + key);
                    if(!set.contains(key)){
                        set.add(key);
                        idx=i;
                        break;
                    }
                }
            }
            
            if(idx == -1){
                System.out.println(input);
            }else{
                System.out.println(input.substring(0,idx) + "[" + input.charAt(idx) + "]" + input.substring(idx+1));
            }
            
            // for(Character a : set) System.out.print(a + " ");
            // System.out.println();
            
        }
    }
}
