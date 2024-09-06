# [Silver III] 터렛 - 1002 

[문제 링크](https://www.acmicpc.net/problem/1002) 

### 분류

많은 조건 분기, 기하학, 수학

### 문제 설명

<p>조규현과 백승환은 터렛에 근무하는 직원이다. 하지만 워낙 존재감이 없어서 인구수는 차지하지 않는다. 다음은 조규현과 백승환의 사진이다.</p>

<p style="text-align: center;"><img alt="" src="https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/upload/201003/dfcmhrjj_142c3w76qg8_b.jpg" style="height: 135px; width: 136px;"></p>

<p>이석원은 조규현과 백승환에게 상대편 마린(류재명)의 위치를 계산하라는 명령을 내렸다. 조규현과 백승환은 각각 자신의 터렛 위치에서 현재 적까지의 거리를 계산했다.</p>

<p>조규현의 좌표 $(x_1, y_1)$와 백승환의 좌표 $(x_2, y_2)$가 주어지고, 조규현이 계산한 류재명과의 거리 $r_1$과 백승환이 계산한 류재명과의 거리 $r_2$가 주어졌을 때, 류재명이 있을 수 있는 좌표의 수를 출력하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 테스트 케이스의 개수 $T$가 주어진다. 각 테스트 케이스는 다음과 같이 이루어져 있다.</p>

<p>한 줄에 공백으로 구분 된 여섯 정수 $x_1$, $y_1$, $r_1$, $x_2$, $y_2$, $r_2$가 주어진다.</p>

### 출력 

 <p>각 테스트 케이스마다 류재명이 있을 수 있는 위치의 수를 출력한다. 만약 류재명이 있을 수 있는 위치의 개수가 무한대일 경우에는 $-1$ 출력한다.</p>



#  🚀  오답노트 

```diff
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.valueOf(br.readLine());
        int x1, y1, r1, x2, y2, r2;
        StringBuilder sb = new StringBuilder();
        while(t-- > 0){
            String row[] = br.readLine().split(" ");
            x1 = Integer.valueOf(row[0]);
            y1 = Integer.valueOf(row[1]);
            r1 = Integer.valueOf(row[2]);
            x2 = Integer.valueOf(row[3]);
            y2 = Integer.valueOf(row[4]);
            r2 = Integer.valueOf(row[5]);
            
            double dx = Math.pow(Math.abs(x1-x2),2);
            double dy = Math.pow(Math.abs(y1-y2),2);
            double len = Math.sqrt(dx + dy);
            
            
            if(x1==x2 && y1==y2){
                if(r1==r2){
                    sb.append(-1).append("\n");
                }else{
                    sb.append(0).append("\n");
                }
            }else{
-                if(len > (r1+r2)){
+                if(len > (r1+r2) || len < Math.abs(r1-r2)){
                    sb.append(0).append("\n");
-                }else if(len == (r1+r2) || dx + dy == Math.pow(Math.abs(r1-r2),2)){
+                }else if(len == (r1+r2) || len == Math.abs(r1-r2)){
                    sb.append(1).append("\n");
                }else{
                    sb.append(2).append("\n");
                }
            }
        }
        
        System.out.println(sb.toString());
    }
}

```


 ## 🏆 전체 코멘트 

1. 두 접점 사이의 거리 구하는 공식
int len = Math.sqrt(Math.pow(Math.abs(x1-x2),2)+ Math.pow(Math.abs(y1-y2),2));

2. 경우의 수
접점 0일 때
1)원 밖에서 겹치지 않는 경우 : 두 점 사이의 거리가 반지름의 합 보다 클 때
2)원 안에서 겹치지 않는 경우 : 두 점 사이의 거리가 반지름의 차 보다 작을 때
접점 1일 때
1)원 밖에서 외접 할 때
2)원 안에서 내접 할 때 : 두 점 사이의 거리와 반지름 간의 차가 같을 때
접점 2일 때
0,1이 아닌 모든 경우