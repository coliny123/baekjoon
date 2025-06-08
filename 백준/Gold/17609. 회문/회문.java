import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        String[] arr = new String[T];
        for (int i = 0; i < T; i++) {
            arr[i] = br.readLine();
        }

        for (int i = 0; i < T; i++) {
            String current = arr[i];
            System.out.println(point(0, current.length() - 1, current, 0));
        }
    }

    private static int point(int start, int end, String str, int remove) {
        if(remove >=2) return 2;

        while (start < end) { 
            if (str.charAt(start) == str.charAt(end)) {
                start++;
                end--;
            } else {
                return Math.min(point(start + 1, end, str, remove + 1), point(start, end - 1, str, remove + 1));
            }
        }
        return remove;
    }
}