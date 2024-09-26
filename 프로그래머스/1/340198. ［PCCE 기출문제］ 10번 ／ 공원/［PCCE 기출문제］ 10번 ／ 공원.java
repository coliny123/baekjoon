class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        
        for(int q=0; q<mats.length; q++){
            for(int i=0; i<=park.length-mats[q]; i++){
                for(int j=0; j<=park[0].length-mats[q]; j++){
                    if(!park[i][j].equals("-1")) continue;

                    boolean flag = true;
                    for(int k=i; k<i+mats[q]; k++){
                        for(int z=j; z<j+mats[q]; z++){
                            if(!park[k][z].equals("-1")){
                                flag = false;
                                break;
                            }
                        }
                    }
                    if(flag) answer = Math.max(answer, mats[q]);
                }
            }
        }
        
        return answer;
    }
}

