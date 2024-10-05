import java.io.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		long[] coins = new long[N+1];
		long[] dp = new long[N+1];
		String[] input = input = br.readLine().split(" ");
		
		for(int i=1; i<=N; i++){
			coins[i] = Long.valueOf(input[i-1]);
		}
		
		long max = 0;
		dp[1] = coins[1];
		for(int i=2; i<=N; i++){
			dp[i] = Math.max(coins[i], dp[i-1] + coins[i]);
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}
}