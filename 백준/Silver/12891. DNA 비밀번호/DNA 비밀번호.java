import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        
        int S = sc.nextInt();
        int P = sc.nextInt();
        
        sc.nextLine();
        char[] str = sc.nextLine().toCharArray();
        int cnt=0;
        
        int[] DNA = new int[4];
        for(int i=0; i<4; i++){
            DNA[i] = sc.nextInt();
        }
        
        int[] myArr = new int[4];
        for(int i=0; i<P; i++){
			if (str[i]=='A') myArr[0]++;
			if (str[i]=='C') myArr[1]++;
			if (str[i]=='G') myArr[2]++;
			if (str[i]=='T') myArr[3]++;
        }
            
        
        if(DNA[0]<=myArr[0] && DNA[1]<=myArr[1] && DNA[2]<=myArr[2] &&DNA[3]<=myArr[3]){
            cnt++;
        }
        
        // for(int k=0; k<4; k++){
            // System.out.print(myArr[k]+ " ");
        // }
        // System.out.println();
        
        for(int i=0; i<S-P; i++){
            int lt = i;
            int rt = i+P;
			if (str[lt]=='A') myArr[0]--;
			if (str[lt]=='C') myArr[1]--;
			if (str[lt]=='G') myArr[2]--;
			if (str[lt]=='T') myArr[3]--;

			if (str[rt]=='A') myArr[0]++;
			if (str[rt]=='C') myArr[1]++;
			if (str[rt]=='G') myArr[2]++;
			if (str[rt]=='T') myArr[3]++;
           
            if(DNA[0]<=myArr[0] && DNA[1]<=myArr[1] && DNA[2]<=myArr[2] &&DNA[3]<=myArr[3]){
                cnt++;
            }
            // for(int k=0; k<4; k++){
                // System.out.print(myArr[k]+ " ");
            // }
            // System.out.println();
        }
        
        
        System.out.println(cnt);
    }
}
