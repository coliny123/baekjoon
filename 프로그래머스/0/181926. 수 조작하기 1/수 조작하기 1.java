class Solution {
    public int solution(int n, String control) {
        int answer = 0;
        char arr[] = control.toCharArray();
        for(char c : arr){
            if(c=='w'){
                n += 1;
            }else if(c=='s'){
                n -= 1;
            }else if(c=='d'){
                n += 10;
            }else if(c=='a'){
                n -= 10;
            }
        }
        return n;
    }
}