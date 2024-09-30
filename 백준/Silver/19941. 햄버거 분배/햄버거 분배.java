import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        sc.nextLine();
        String input = sc.nextLine();
        char arr[] = input.toCharArray();
        
        int cnt=0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]=='P'){
                boolean flag = false;
                for(int j=i-K; j<=i+K; j++){
                    if(j<0 || j>=N) continue;
                    
                    if(arr[j]=='H'){
                        flag = true;
                        arr[j] = 'X';
                        // System.out.println(i + " " + j);
                        break;
                    }
                }
                if(flag) cnt++;
            }
        }
        
        System.out.println(cnt);
    }
}
