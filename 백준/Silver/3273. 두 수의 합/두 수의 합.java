import java.util.Scanner;
import java.util.Arrays;

public class Main{
    
	public static int count(int n, int[] arr, int x) {
		int result = 0;
		int sum = 0;
		int lt = 0;
		int rt = n-1;
		
		Arrays.sort(arr);
		
		while(lt < rt) {
			sum = arr[rt] + arr[lt];
			
			if(sum == x) result++;
			
			if(sum < x) {
				lt++;
			}else {
				rt--;
			}
		}
		return result;
	}
    
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        
        int x = sc.nextInt();
        System.out.println(count(n, arr, x));
    }
}