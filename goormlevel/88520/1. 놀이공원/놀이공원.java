import java.io.*;


class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int t = Integer.valueOf(input);
		
		while(t-- > 0){
			String[] NK = br.readLine().split(" ");
			int N = Integer.valueOf(NK[0]);
			int K = Integer.valueOf(NK[1]);
			
			int[][] park = new int[N][N];
			for(int i=0; i<N; i++){
				String[] row = br.readLine().split(" ");
				for(int j=0; j<N; j++){
					park[i][j] = Integer.valueOf(row[j]);
				}
			}
			
			int min = Integer.MAX_VALUE;
			for(int row=0; row<=N-K; row++){
				for(int col=0; col<=N-K; col++){
					int cnt=0;
					for(int i=row; i<row+K; i++){
						for(int j=col; j<col+K; j++){
							if(park[i][j] == 1) cnt++;
						}
					}
					min = Math.min(min, cnt);
				}
			}
			System.out.println(min);
		}
	}
}